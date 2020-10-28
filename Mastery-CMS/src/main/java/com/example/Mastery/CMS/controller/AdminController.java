/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Mastery.CMS.controller;

import com.example.Mastery.CMS.daos.BlogpostDao;
import com.example.Mastery.CMS.daos.RoleDao;
import com.example.Mastery.CMS.daos.UserDao;
import com.example.Mastery.CMS.dtos.Blogpost;
import com.example.Mastery.CMS.dtos.Role;
import com.example.Mastery.CMS.dtos.User;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
@Controller
public class AdminController {

    @Autowired
    UserDao users;

    @Autowired
    RoleDao roles;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    BlogpostDao blogs;

    @GetMapping("/admin")
    public String displayAdminPage(Model model) {
        model.addAttribute("users", users.getAllUsers());
        List<Blogpost> listOfBlogs = blogs.getAllBlogposts();
        model.addAttribute("blogposts", listOfBlogs);

        return "admin";
    }

    @GetMapping("/approveBlog")
    public String approveBlog(HttpServletRequest request, Boolean staticBlog) {
        int id = Integer.parseInt(request.getParameter("id"));
        Blogpost blog = blogs.getBlogPostById(id);
        blog.setIsVerified(true);

        if (staticBlog != null) {
            blog.setIsStatic(true);
        }
//        else{
//            blog.
//        }
        blogs.updateBlogpost(blog);

        return "redirect:/admin";
    }

    @GetMapping("/makeStatic")
    public String makeStatic(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Blogpost blog = blogs.getBlogPostById(id);

        blog.setIsStatic(true);

//        else{
//            blog.
//        }
        blogs.updateBlogpost(blog);

        return "redirect:/admin";
    }

    @GetMapping("/makeNonStatic")
    public String makeNonStatic(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Blogpost blog = blogs.getBlogPostById(id);

        blog.setIsStatic(false);

        blogs.updateBlogpost(blog);

        return "redirect:/admin";
    }

    @PostMapping("/addUser")
    public String addUser(String username, String password) {

        User user = new User();
        user.setUserName(username);
        user.setPassword(encoder.encode(password));
        user.setEnabled(true);
        user.setFirstName("Karma");
        user.setLastName("Dolkar");
        user.setPhoneNum("9292459121");
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(roles.getRoleByRole("ROLE_USER"));
        user.setRoles(userRoles);

        users.createUser(user);

        return "redirect:/admin";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(Integer id) {
        users.deleteUser(id);
        return "redirect:/admin";
    }

    @GetMapping("/deleteBlog")
    public String deleteBlog(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        blogs.deleteBlogpost(id);
        return "redirect:/admin";
    }

//    @GetMapping("/editUser")
//    public String editUserDisplay(Model model, Integer id) {
//        User user = users.getUserById(id);
//        List<Role> roleList = roles.getAllRoles();
//
//        model.addAttribute("user", user);
//        model.addAttribute("roles", roleList);
//        return "editUser";
//    }
    @GetMapping("/editUser")
    public String editUserDisplay(Model model, Integer id, Integer error) {
        User user = users.getUserById(id);
        List roleList = roles.getAllRoles();

        model.addAttribute("user", user);
        model.addAttribute("roles", roleList);

        if (error != null) {
            if (error == 1) {
                model.addAttribute("error", "Passwords did not match, password was not updated.");
            }
        }

        return "editUser";
    }

    @PostMapping(value = "/editUser")
    public String editUserAction(String[] roleIdList, Boolean enabled, Integer id) {
        User user = users.getUserById(id);
        if (enabled != null) {
            user.setEnabled(enabled);
        } else {
            user.setEnabled(false);
        }

        Set<Role> roleList = new HashSet<>();
        for (String roleId : roleIdList) {
            Role role = roles.getRoleById(Integer.parseInt(roleId));
            roleList.add(role);
        }
        user.setRoles(roleList);
        users.updateUser(user);

        return "redirect:/admin";
    }

    @PostMapping("editPassword")
    public String editPassword(Integer id, String password, String confirmPassword) {
        User user = users.getUserById(id);

        if (password.equals(confirmPassword)) {
            user.setPassword(encoder.encode(password));
            users.updateUser(user);
            return "redirect:/admin";
        } else {
            return "redirect:/editUser?id=" + id + "&error=1";
        }
    }
}
