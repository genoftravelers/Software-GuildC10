/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Mastery.CMS.controller;

import com.example.Mastery.CMS.daos.BlogpostDao;
import com.example.Mastery.CMS.dtos.Blogpost;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
@Controller
public class HomeController {

    @Autowired
    BlogpostDao blogpost;

    @GetMapping({"/", "/home"})
    public String displayHomePage(Model model) {
        List<Blogpost> staticBlogs = new ArrayList<>();
        List<Blogpost> blogposts = blogpost.getAllBlogposts();

        for (Blogpost blogpost : blogposts) {
            if (blogpost.isIsStatic()) {
                staticBlogs.add(blogpost);
            }
        }

        model.addAttribute("staticBlogs", staticBlogs);
        model.addAttribute("blogposts", blogposts);

        return "home";
    }

    @GetMapping("/staticPage")
    public String staticPage(HttpServletRequest request, Model model) {

        List<Blogpost> blogposts = blogpost.getAllBlogposts();
        List<Blogpost> staticBlogs = new ArrayList<>();
        for (Blogpost blogpost : blogposts) {
            if (blogpost.isIsStatic()) {
                staticBlogs.add(blogpost);
            }
        }
        int id = Integer.parseInt(request.getParameter("id"));
        Blogpost staticBlog = blogpost.getBlogPostById(id);
        model.addAttribute("blog", staticBlog);
        model.addAttribute("staticBlogs", staticBlogs);
        return "staticPage";
    }
}
