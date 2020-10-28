/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Mastery.CMS.daos;

import com.example.Mastery.CMS.dtos.Blogpost;
import com.example.Mastery.CMS.dtos.Role;
import java.util.List;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public interface BlogpostDao {

    Blogpost getBlogPostById(int id);

    Blogpost getBlogpostByTitle(String title);

    List<Blogpost> getAllBlogposts();

    void deleteBlogpost(int id);

    void updateBlogpost(Blogpost blogpost);

    Blogpost createBlogpost(Blogpost blogpost);

}
