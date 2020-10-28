/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Mastery.CMS.daos;

import com.example.Mastery.CMS.daos.HashtagDaoDB.HashtagMapper;
import com.example.Mastery.CMS.dtos.Blogpost;
import com.example.Mastery.CMS.dtos.Hashtag;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
@Repository
public class BlogpostDaoDB implements BlogpostDao {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public Blogpost getBlogPostById(int id) {

        try {
            final String GET_BLOGPOST_BY_ID = "SELECT * FROM blogpost WHERE blogId = ?";
            Blogpost blogpost = jdbc.queryForObject(GET_BLOGPOST_BY_ID, new BlogpostMapper(), id);

            blogpost.setHashtags(getHashtagsForBlogpost(blogpost.getId()));
            
            if (blogpost.getHashtags().isEmpty()) {
                blogpost.setHashtags(null);
            }

            return blogpost;

        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public Blogpost getBlogpostByTitle(String title) {
        try {
            final String GET_BLOGPOST_BY_TITLE = "SELECT * FROM blogpost WHERE title = ?";
            Blogpost blogpost = jdbc.queryForObject(GET_BLOGPOST_BY_TITLE, new BlogpostMapper(), title);
            blogpost.setHashtags(getHashtagsForBlogpost(blogpost.getId()));
            //if the hashtags is empty 
            if (blogpost.getHashtags().isEmpty()) {
                //then set it to null
                blogpost.setHashtags(null);
            }

            
            return blogpost;
        } catch (DataAccessException ex) {
            return null;
        }

    }

    @Override
    public List<Blogpost> getAllBlogposts() {
        final String GET_ALL_BLOGPOSTS = "SELECT * FROM blogpost";
        List<Blogpost> blogposts = jdbc.query(GET_ALL_BLOGPOSTS, new BlogpostMapper());
        for (Blogpost blogpost : blogposts) {
            blogpost.setHashtags(getHashtagsForBlogpost(blogpost.getId()));
            if (blogpost.getHashtags().isEmpty()) {
                blogpost.setHashtags(null);
            }

        }
        return blogposts;

    }

    private Set<Hashtag> getHashtagsForBlogpost(int id) throws DataAccessException {

        final String GET_HASHTAGS_FOR_BLOGPOST = "SELECT h.* FROM blogtag bt "
                + "JOIN hashtag h ON bt.hashtagId = h.hashtagId "
                + "WHERE bt.blogId = ? ";
        Set<Hashtag> hashtags = new HashSet(jdbc.query(GET_HASHTAGS_FOR_BLOGPOST, new HashtagMapper(), id));
        return hashtags;

    }

    @Override
    public void deleteBlogpost(int id) {
        final String DELETE_BLOGPOST_HASHTAG = "DELETE FROM blogTag WHERE blogId = ?";
        final String DELETE_BLOGPOST = "DELETE FROM blogpost WHERE blogId = ?";
        jdbc.update(DELETE_BLOGPOST_HASHTAG, id);
        jdbc.update(DELETE_BLOGPOST, id);

    }

    @Override
    public void updateBlogpost(Blogpost blogpost) {
        final String UPDATE_BLOGPOST = "UPDATE blogpost SET title = ?,  static= ?,blogDate =?, expiration = ?, verified =?, blogContent = ? , userId = ? WHERE blogId=? ";
        jdbc.update(UPDATE_BLOGPOST,
                blogpost.getTitle(),
                blogpost.isIsStatic(),
                blogpost.getBlogDate(),
                blogpost.getExpiration(),
                blogpost.isIsVerified(),
                blogpost.getBlogContent(),
                blogpost.getUserId(),
                blogpost.getId());

        final String DELETE_BLOGPOST_HASHTAG = "DELETE FROM blogTag WHERE blogId = ?";
        jdbc.update(DELETE_BLOGPOST_HASHTAG, blogpost.getId());

        if (blogpost.getHashtags() != null) {
            for (Hashtag hashtag : blogpost.getHashtags()) {
                final String INSERT_BLOGPOST_HASHTAG = "INSERT INTO blogTag(blogId, hashTagId) VALUES(?,?)";
                jdbc.update(INSERT_BLOGPOST_HASHTAG, blogpost.getId(), hashtag.getId());
            }
        }
    }

    @Override
    @Transactional
    public Blogpost createBlogpost(Blogpost blogpost) {
        final String INSERT_BLOGPOST = "INSERT INTO blogpost(title, static, blogDate, expiration, verified, blogContent, userId) VALUES (?,?,?,?,?,?,?)";
        jdbc.update(INSERT_BLOGPOST,
                blogpost.getTitle(),
                blogpost.isIsStatic(),
                blogpost.getBlogDate(),
                blogpost.getExpiration(),
                blogpost.isIsVerified(),
                blogpost.getBlogContent(),
                blogpost.getUserId());

        int newId = jdbc.queryForObject("select LAST_INSERT_ID();", Integer.class);
        blogpost.setId(newId);
        //if hashtag is not null, when makign ablogpost, maake sure it is an empty list or set.
        if (blogpost.getHashtags() != null) {
            for (Hashtag hashtag : blogpost.getHashtags()) {
                final String INSERT_BLOGPOST_HASHTAG = "INSERT INTO blogTag(blogId, hashtagId) VALUES (?,?)";
                jdbc.update(INSERT_BLOGPOST_HASHTAG, blogpost.getId(), hashtag.getId());
            }
        }
        return blogpost;

    }

    public static final class BlogpostMapper implements RowMapper<Blogpost> {

        @Override
        public Blogpost mapRow(ResultSet rs, int i) throws SQLException {
            Blogpost blogpost = new Blogpost();
            blogpost.setId(rs.getInt("blogId"));
            blogpost.setTitle(rs.getString("title"));
            blogpost.setIsStatic(rs.getBoolean("static"));
            blogpost.setBlogDate(rs.getTimestamp("blogDate").toLocalDateTime());
            blogpost.setExpiration(rs.getTimestamp("expiration").toLocalDateTime());
            blogpost.setIsVerified(rs.getBoolean("verified"));
            blogpost.setBlogContent(rs.getString("blogContent"));
            blogpost.setUserId(rs.getInt("userId"));

            return blogpost;

        }
    }

}
