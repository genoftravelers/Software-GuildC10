/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Mastery.CMS.controller;

import com.example.Mastery.CMS.daos.HashtagDao;
import com.example.Mastery.CMS.dtos.Hashtag;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
@Controller
public class HashtagController {

    @Autowired
    HashtagDao hashtags;

    Set<ConstraintViolation<Hashtag>> violations = new HashSet<>();

    @GetMapping("/hashtag")
    public String getHashtag(Model model) {
        List<Hashtag> hashtagLists = hashtags.getAllHashtags();
        model.addAttribute("hashtags", hashtagLists);
        model.addAttribute("errors", violations);
        return "hashtag";
    
    }
    
    @GetMapping("displayHashtags")
    public String getAllHashtags(Model model){
         List<Hashtag> hashtagLists = hashtags.getAllHashtags();
         model.addAttribute("hashtagLists", hashtagLists);
         return "hashtagLists";
    }

    @PostMapping("addHashtag")
    public String addHashtag(String name) {
        Hashtag hashtag = new Hashtag();
        hashtag.setName(name);
        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(hashtag);

        if (violations.isEmpty()) {
            hashtags.createHashTag(hashtag);
        }
//        hashtags.createHashTag(hashtag);
        
        return "redirect:/hashtag";
    }

    @GetMapping("deleteHashtag")
    public String deleteHashtag(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));

        hashtags.deleteHashtag(id);
        return "redirect:/hashtag";
    }

    }