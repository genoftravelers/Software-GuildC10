/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.KarmaSuperHero.Controller;

import com.sg.KarmaSuperHero.dao.SuperpowerDao;
import com.sg.KarmaSuperHero.dto.Superpower;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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
public class SuperpowerController {

    @Autowired
    SuperpowerDao superpowerDao;

    @GetMapping("superpowers")
    public String displaySuperpowers(Model model) {
        List<Superpower> superpowers = superpowerDao.getAllSuperpowers();
        model.addAttribute("superpowers", superpowers);
        return "superpowers";
    }

    @PostMapping("addSuperpower")
    public String addSuperpower(HttpServletRequest request) {
        String powerName = request.getParameter("superpowerName");
        Superpower superpower = new Superpower();
        superpower.setSuperpowerName(powerName);

        superpowerDao.addSuperpower(superpower);

        return "redirect:/superpowers";
    }

    @GetMapping("deleteSuperpower")
    public String deleteSuperpower(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        superpowerDao.deleteSuperpowerById(id);

        return "redirect:/superpowers";
    }
    
    @GetMapping("editSuperpower")
    public String editSuperpower (HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("id"));
        Superpower superpower = superpowerDao.getSuperpowerById(id);
       
        
        model.addAttribute("superpower", superpower);
        return "editSuperpower";
        
        
    }

    @PostMapping("editSuperpower")
    public String performEditSuperpower(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("id"));
        Superpower superpower = superpowerDao.getSuperpowerById(id);
        
        superpower.setSuperpowerName(request.getParameter("superpowerName"));
        superpowerDao.updateSuperpower(superpower);
        
        return "redirect:/superpowers";
                
        
    }
}
