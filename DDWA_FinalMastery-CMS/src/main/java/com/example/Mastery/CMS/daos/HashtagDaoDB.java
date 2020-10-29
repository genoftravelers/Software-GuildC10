/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Mastery.CMS.daos;

import com.example.Mastery.CMS.dtos.Hashtag;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
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
public class HashtagDaoDB implements HashtagDao {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public Hashtag getHashTagById(int id) {
        try {
            final String SELECT_HASHTAG_BY_ID = "SELECT * FROM hashtag WHERE hashtagId= ?";
            return jdbc.queryForObject(SELECT_HASHTAG_BY_ID, new HashtagMapper(), id);
        } catch (DataAccessException ex) {
            return null;
        }
    }


   @Override
    public Hashtag getHashtagByName(String name) {
        try {
            final String SELECT_HASHTAG_BY_HASHTAG = "SELECT * FROM hashtag WHERE hashtagName = ?";
            return jdbc.queryForObject(SELECT_HASHTAG_BY_HASHTAG, new HashtagMapper(), name);
        } catch (Exception e) {
            return null;
        }
    }


    @Override
    public List<Hashtag> getAllHashtags() {
        final String SELECT_ALL_HASHTAGS = "SELECT * FROM hashtag;";
        return jdbc.query(SELECT_ALL_HASHTAGS, new HashtagMapper());
    }


    @Override
    public void deleteHashtag(int id) {
        final String DELETE_BLOGPOST_HASHTAG = "DELETE FROM blogTag WHERE hashtagId  = ?";
        final String DELETE_HASHTAG = "DELETE FROM hashtag WHERE hashtagId = ?";
        jdbc.update(DELETE_BLOGPOST_HASHTAG, id);
        jdbc.update(DELETE_HASHTAG, id);
    }

   @Override
    public void updateHashtag(Hashtag hashtag) {
        final String UPDATE_HASHTAG = "UPDATE hashtag SET hashtagName = ? WHERE hashtagId = ?";
        jdbc.update(UPDATE_HASHTAG, hashtag.getName(), hashtag.getId());
    }


    
    @Override
    @Transactional
    public Hashtag createHashTag(Hashtag hashtag) {
        final String INSERT_HASHTAG = "INSERT INTO hashtag(hashtagName) VALUES(?)";
        jdbc.update(INSERT_HASHTAG, hashtag.getName());
        int newId = jdbc.queryForObject("select LAST_INSERT_ID()", Integer.class);
        hashtag.setId(newId);
        return hashtag;
    }

    public static final class HashtagMapper implements RowMapper<Hashtag> {

        @Override
        public Hashtag mapRow(ResultSet rs, int i) throws SQLException {

            Hashtag hashtag = new Hashtag();
            hashtag.setId(rs.getInt("hashtagId"));
            hashtag.setName(rs.getString("hashtagName"));
            return hashtag;

        }

    }

}
