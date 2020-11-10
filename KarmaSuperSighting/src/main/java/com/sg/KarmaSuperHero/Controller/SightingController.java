/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.KarmaSuperHero.Controller;

import com.sg.KarmaSuperHero.dao.HeroDao;
import com.sg.KarmaSuperHero.dao.LocationDao;
import com.sg.KarmaSuperHero.dao.SightingDao;
import com.sg.KarmaSuperHero.dto.Hero;
import com.sg.KarmaSuperHero.dto.Location;
import com.sg.KarmaSuperHero.dto.Sighting;
import java.time.LocalDate;
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
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
@Controller

public class SightingController {

    @Autowired
    SightingDao sightingDao;

    @Autowired
    LocationDao locationDao;

    @Autowired
    HeroDao heroDao;

    Set<ConstraintViolation<Sighting>> violations = new HashSet<>();
//request mappign takes in multiple pm and its a bigger/broader version of getMapping.

    @RequestMapping(value = {"/", "index"})//gets only 10 sightings
    public String loadIndex(Model model) {
        List<Sighting> sightings = sightingDao.getTopTenSightings();
        List<Hero> heroes = heroDao.getAllHeroes();
        List<Location> locations = locationDao.getAllLocations();
        model.addAttribute("sightings", sightings);
        model.addAttribute("heroes", heroes);
        model.addAttribute("locations", locations);
        return "index";
    }

    @GetMapping("sightings")
    public String displaySightings(Model model) {
        List<Sighting> sightings = sightingDao.getAllSightings();
        List<Hero> heroes = heroDao.getAllHeroes();
        List<Location> locations = locationDao.getAllLocations();
        model.addAttribute("sightings", sightings);
        model.addAttribute("heroes", heroes);
        model.addAttribute("locations", locations);
        model.addAttribute("errors", violations);
        return "sightings";
    }

    @PostMapping("addSighting")
    public String addSighting(HttpServletRequest request) {
        LocalDate date;

        try {
            String dateAsString = request.getParameter("date");
            date = LocalDate.parse(dateAsString);

        } catch (Exception e) {
            date = null;
        }
        int heroID = Integer.parseInt(request.getParameter("heroId"));
        int locationID = Integer.parseInt(request.getParameter("locationId"));
        Sighting sighting = new Sighting();
        sighting.setLocation(locationDao.getLocationById(locationID));
        sighting.setDate(date);
        sighting.setHero(heroDao.getHeroById(heroID));
        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(sighting);
        if (violations.isEmpty()) {
            sightingDao.addSighting(sighting);
        }
        return "redirect:/sightings";
    }

    @GetMapping("sightingDetail")
    public String sightingDetail(Integer id, Model model) {
        Sighting sighting = sightingDao.getSightingById(id);
        model.addAttribute("sighting", sighting);
        return "sightingDetail";
    }

    @GetMapping("deleteSighting")
    public String deleteSighting(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        sightingDao.deleteSightingById(id);
        return "redirect:/sightings";
    }

    @GetMapping("editSighting")
    public String editCourse(Integer id, Model model) {
        Sighting sighting = sightingDao.getSightingById(id);
        List<Hero> heroes = heroDao.getAllHeroes();
        List<Location> locations = locationDao.getAllLocations();
        model.addAttribute("sighting", sighting);
        model.addAttribute("heroes", heroes);
        model.addAttribute("locations", locations);
        return "editSighting";
    }

    @PostMapping("editSighting")
    public String performEditSighting(HttpServletRequest request) {

        String heroId = request.getParameter("heroId");
        String locationId = request.getParameter("locationId");

        LocalDate date;
        try {
            String dateAsString = request.getParameter("date");

            date = LocalDate.parse(dateAsString);
        } catch (Exception e) {
            date = null;
        }

        int sightingId = Integer.parseInt(request.getParameter("sightingId"));
        Sighting sighting = new Sighting();

        sighting.setHero(heroDao.getHeroById(Integer.parseInt(heroId)));
        sighting.setLocation(locationDao.getLocationById(Integer.parseInt(locationId)));
        sighting.setSightingId(sightingId);

        sighting.setDate(date);

        sightingDao.updateSighting(sighting);

        return "redirect:/sightings";
    }

    @GetMapping("topTenSightings")
    public String displayTopTenSightings(Model model) {
        List<Sighting> topTenSightings = sightingDao.getTopTenSightings();
        model.addAttribute("topTenSightings", topTenSightings);
        return "index"; //Can be changed
    }
}
