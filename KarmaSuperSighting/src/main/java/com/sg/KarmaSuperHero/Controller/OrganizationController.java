/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.KarmaSuperHero.Controller;

import com.sg.KarmaSuperHero.dao.HeroDao;
import com.sg.KarmaSuperHero.dao.LocationDao;
import com.sg.KarmaSuperHero.dao.OrganizationDao;
import com.sg.KarmaSuperHero.dto.Hero;
import com.sg.KarmaSuperHero.dto.Location;
import com.sg.KarmaSuperHero.dto.Organization;
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

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
@Controller
public class OrganizationController {

    @Autowired
    LocationDao locationDao;
    @Autowired
    OrganizationDao organizationDao;
    @Autowired
    HeroDao heroDao;

//    @GetMapping("organizations")
//    public String displayOrganizations(Model model){
//        List <Organization> organizations = organizationDao.getAllOrganizations();
//        model.addAttribute("organizations", organizations);
//        return "organizations";
//    }
    Set<ConstraintViolation<Organization>> violations = new HashSet<>();

    @GetMapping("organizations")
    public String displayOrganizations(Model model) {
        List<Organization> organizations = organizationDao.getAllOrganizations();
        List<Hero> heroes = heroDao.getAllHeroes();
        List<Location> locations = locationDao.getAllLocations();
        model.addAttribute("organizations", organizations);
        model.addAttribute("heroes", heroes);
        model.addAttribute("locations", locations);
        model.addAttribute("errors", violations);
        return "organizations";
    }

    @PostMapping("addOrganization")
    public String addOrganization(HttpServletRequest request) {
        Organization organization = new Organization();
        String[] heroIDs = request.getParameterValues("heroId");
        List<Hero> heroes = new ArrayList<>();
        if (heroIDs != null) {
            for (String heroID : heroIDs) {
                heroes.add(heroDao.getHeroById(Integer.parseInt(heroID)));
            }
        }

        String locationId = request.getParameter("locationId");
        Location location = null;
        if (locationId != null) {

            location = locationDao.getLocationById(Integer.parseInt(locationId));
        }

        String organizationName = request.getParameter("organizationName");
        String organizationDescription = request.getParameter("organizationDescription");

        try {
            String organizationPhone = request.getParameter("organizationPhoneNum");
            organization.setOrganizationPhoneNum(organizationPhone);
        } catch (NullPointerException ex) {
        }
        organization.setHeroes(heroes);
        organization.setLocation(location);
        organization.setOrganizationName(organizationName);
        organization.setOrganizationDescription(organizationDescription);
        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(organization);
        if (violations.isEmpty()) {
            organizationDao.addOrganization(organization);
        }
        return "redirect:/organizations";
    }

    @GetMapping("deleteOrganization")
    public String deleteOrganization(HttpServletRequest request) {

        int id = Integer.parseInt(request.getParameter("id"));
        organizationDao.deleteOrganizationById(id);
        return "redirect:/organizations";

    }

    @GetMapping("organizationDetail")
    public String organizationDetail(Integer id, Model model) {
        Organization organization = organizationDao.getOrganizationById(id);
        model.addAttribute("organization", organization);
        return "organizationDetail";

    }

    @GetMapping("editOrganization")
    public String editOrganization(Integer id, Model model) {
        Organization organization = organizationDao.getOrganizationById(id);
        List<Location> locations = locationDao.getAllLocations();
        List<Hero> heroes = heroDao.getAllHeroes();
        model.addAttribute("organization", organization);
        model.addAttribute("locations", locations);
        model.addAttribute("heroes", heroes);

        return "editOrganization";

    }

    @PostMapping("editOrganization")
    public String performEditOrganization(Organization organization, HttpServletRequest request) {
        String locationId = request.getParameter("locationId");
        String[] heroIds = request.getParameterValues("heroId");
        if (locationId != null) {
            organization.setLocation(locationDao.getLocationById(Integer.parseInt(locationId)));
        }
        String organizationName = request.getParameter("organizationName");
        String organizationDescription = request.getParameter("organizationDescription");
        String organizationPhoneNum = request.getParameter("organizationPhoneNum");

        List<Hero> heroes = new ArrayList<>();
        if (heroIds != null) {
            for (String heroId : heroIds) {
                heroes.add(heroDao.getHeroById(Integer.parseInt(heroId)));
            }
        }
        organization.setHeroes(heroes);
//        organization.setLocation(location);
        organization.setOrganizationName(organizationName);
        organization.setOrganizationDescription(organizationDescription);
        organization.setOrganizationPhoneNum(organizationPhoneNum);

        organizationDao.updateOrganization(organization);

        return "redirect:/organizations";

    }

}
