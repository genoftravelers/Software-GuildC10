package com.sg.KarmaSuperHero.Controller;

import com.sg.KarmaSuperHero.dao.HeroDao;
import com.sg.KarmaSuperHero.dao.LocationDao;
import com.sg.KarmaSuperHero.dao.OrganizationDao;
import com.sg.KarmaSuperHero.dao.SuperpowerDao;
import com.sg.KarmaSuperHero.dto.Hero;
import com.sg.KarmaSuperHero.dto.Organization;
import com.sg.KarmaSuperHero.dto.Superpower;
import java.util.ArrayList;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
@Controller
public class HeroController {

    @Autowired
    LocationDao locationDao;

    @Autowired
    OrganizationDao organizationDao;

    @Autowired
    HeroDao heroDao;

    @Autowired
    SuperpowerDao superpowerDao;

    Set<ConstraintViolation<Hero>> violations = new HashSet<>();

    @GetMapping("heroes")
    public String displayHeroes(Model model) {
        List<Superpower> superpowers = superpowerDao.getAllSuperpowers();
        List<Hero> heroes = heroDao.getAllHeroes();
        List<Organization> organizations = organizationDao.getAllOrganizations();

        model.addAttribute("heroes", heroes);
        model.addAttribute("superpowers", superpowers);
        model.addAttribute("organizations", organizations);
        model.addAttribute("errors", violations); //doesnt work

        return "heroes";
    }

    @PostMapping("addHero")
    public String addHero(Hero hero, HttpServletRequest request) {
        String superpowerId = request.getParameter("superpowerId");
        String[] organizationIds = request.getParameterValues("organizationId");

        hero.setSuperPower(superpowerDao.getSuperpowerById(Integer.parseInt(superpowerId)));

        List<Organization> organizations = new ArrayList<>();
        if (organizationIds != null) {
            for (String organizationId : organizationIds) {
                organizations.add(organizationDao.getOrganizationById(Integer.parseInt(organizationId)));
            }
        }

        hero.setOrganizations(organizations);

        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(hero);

        if (violations.isEmpty()) {
            heroDao.addHero(hero);
        }
        return "redirect:/heroes";

    }

    @GetMapping("heroDetail")
    public String heroDetail(Integer id, Model model) {
        Hero hero = heroDao.getHeroById(id);
        model.addAttribute("hero", hero);
        return "heroDetail";
    }

    @GetMapping("deleteHero")
    public String deleteHero(Integer id) {
        heroDao.deleteHeroById(id);
        return "redirect:/heroes";
    }

    @GetMapping("editHero")
    public String editHero(Integer id, Model model) {
        Hero hero = heroDao.getHeroById(id);
        List<Superpower> superpowers = superpowerDao.getAllSuperpowers();
        List<Organization> organizations = organizationDao.getAllOrganizations();
        model.addAttribute("superpowers", superpowers);
        model.addAttribute("organizations", organizations);
        model.addAttribute("hero", hero);

        return "editHero";

    }

    @PostMapping("editHero")
    public String performEditHero(Hero hero, HttpServletRequest request) {
        String superpowerId = request.getParameter("superpowerId");
        String[] organizationIds = request.getParameterValues("organizationId");

        hero.setSuperPower(superpowerDao.getSuperpowerById(Integer.parseInt(superpowerId)));
        String heroName = request.getParameter("heroName");
        String heroDescription = request.getParameter("heroDescription");

        List<Organization> organizations = new ArrayList<>();
        for (String organizationId : organizationIds) {
            organizations.add(organizationDao.getOrganizationById(Integer.parseInt(organizationId)));
        }
        hero.setOrganizations(organizations);
        hero.setHeroName(heroName);
        hero.setHeroDescription(heroDescription);

        heroDao.updateHero(hero);

        return "redirect:/heroes";
    }
}
