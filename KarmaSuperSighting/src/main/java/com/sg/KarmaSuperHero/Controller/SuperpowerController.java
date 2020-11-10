/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.KarmaSuperHero.Controller;

import com.sg.KarmaSuperHero.dao.SuperpowerDao;
import com.sg.KarmaSuperHero.dto.Superpower;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
@Controller
public class SuperpowerController {

    @Autowired
    SuperpowerDao superpowerDao;

    Set<ConstraintViolation<Superpower>> violations = new HashSet<>();

    @GetMapping("superpowers")
    public String displaySuperpowers(Model model) {
        List<Superpower> superpowers = superpowerDao.getAllSuperpowers();
        model.addAttribute("superpowers", superpowers);
        model.addAttribute("errors", violations);
        return "superpowers";
    }

    @PostMapping("addSuperpower")
    public String addSuperpower(HttpServletRequest request) {
        String powerName = request.getParameter("superpowerName");
        Superpower superpower = new Superpower();
        superpower.setSuperpowerName(powerName);

//        superpowerDao.addSuperpower(superpower);
        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(superpower);
        if (violations.isEmpty()) {
            superpowerDao.addSuperpower(superpower);
        }

        return "redirect:/superpowers";
    }

    @GetMapping("deleteSuperpower")
    public String deleteSuperpower(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        superpowerDao.deleteSuperpowerById(id);

        return "redirect:/superpowers";
    }

    @GetMapping("editSuperpower")
    public String editSuperpower(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("id"));
        Superpower superpower = superpowerDao.getSuperpowerById(id);

        model.addAttribute("superpower", superpower);
        return "editSuperpower";

    }

    @PostMapping("editSuperpower")
    public String performEditSuperpower(@Valid Superpower superpower, BindingResult result) {
        
        if (result.hasErrors()) {
            return "editSuperpower";
        }

        superpowerDao.updateSuperpower(superpower);
        return "redirect:/superpowers";

    }
}
