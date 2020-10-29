/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Mastery.CMS.controller;

import com.example.Mastery.CMS.daos.BlogpostDao;
import com.example.Mastery.CMS.daos.HashtagDao;
import com.example.Mastery.CMS.daos.RoleDao;
import com.example.Mastery.CMS.daos.UserDao;
import com.example.Mastery.CMS.dtos.Blogpost;
import com.example.Mastery.CMS.dtos.Hashtag;
import com.example.Mastery.CMS.dtos.User;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
@Controller
public class ContentController {

    @Autowired
    UserDao users;

    @Autowired
    RoleDao roles;

    @Autowired
    BlogpostDao blogposts;

    @Autowired
    HashtagDao hashtagDao;

    Set<ConstraintViolation<Blogpost>> violations = new HashSet<>();

    @GetMapping("/content")
    public String displayContentPageModel(Model model) {
        List<Hashtag> hashtags = hashtagDao.getAllHashtags();

        model.addAttribute("hashtags", hashtags);
        model.addAttribute("errors", violations);
        return "content";
    }

    @PostMapping("/addBlog")
    public String addBlog(HttpServletRequest request, Model model) {
        String[] hashtagIds = request.getParameterValues("id");
        Set<Hashtag> hashtags = new HashSet<>();

        if (hashtagIds != null) {
            for (String id : hashtagIds) {
                hashtags.add(hashtagDao.getHashTagById(Integer.parseInt(id)));
            }
        }
//        return "redirect:/content";
//        Role role = new Role();
//        role.setRole("Admin");
//        role = roles.createRole(role);
//        
//        Set <Role> roles = new HashSet <>();
//        roles.add(role);
//
//        User user = new User();
//        user.setFirstName("testname");
//        user.setLastName("testlast");
//        user.setEnabled(true);
//        user.setPassword("testpw");
//        user.setPhoneNum("9292456342");
//        user.setUserName("krmdlk");
//        user.setRoles(roles);
//        
//
//        user = users.createUser(user);

//        blogpost = blogposts.createBlogpost(blogpost);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        User user = users.getUserByUserName(userName);

        Blogpost blogpost = new Blogpost();

        String content = request.getParameter("blogContent");
        blogpost.setBlogContent(content);
        blogpost.setBlogDate(LocalDateTime.now().withNano(0));
        blogpost.setExpiration(LocalDateTime.now().withNano(0));
        blogpost.setTitle(request.getParameter("title"));
        
        
        String staticPage = request.getParameter("static");
        if(staticPage ==null){
             blogpost.setIsStatic(false);
        }else{
            blogpost.setIsStatic(true);
        }
       
        blogpost.setIsVerified(false);
        blogpost.setUserId(user.getId());
        blogpost.setHashtags(hashtags);

        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(blogpost);

        if (violations.isEmpty()) {
            blogposts.createBlogpost(blogpost);

        }

        return "redirect:/content";
    }
    
 

//    @GetMapping("/deleteBlogpost")
//    public String deleteBlogpost(Integer id) {
//        blogposts.deleteBlogpost(id);
//        return "redirect:/content";
//    }
}
