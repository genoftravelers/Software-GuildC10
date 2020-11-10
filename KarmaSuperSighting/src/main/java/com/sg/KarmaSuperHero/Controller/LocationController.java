/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.KarmaSuperHero.Controller;

import com.sg.KarmaSuperHero.dao.HeroDao;
import com.sg.KarmaSuperHero.dao.LocationDao;
import com.sg.KarmaSuperHero.dao.OrganizationDao;
import com.sg.KarmaSuperHero.dto.Location;
import java.math.BigDecimal;
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
public class LocationController {

    @Autowired
    LocationDao locationDao;
    @Autowired
    OrganizationDao organizationDao;
    @Autowired
    HeroDao heroDao;
    
    Set<ConstraintViolation<Location>> violations = new HashSet<>();

    @GetMapping("locations")
    public String displayLocations(Model model) {
        List<Location> locations = locationDao.getAllLocations();
        model.addAttribute("locations", locations);
        model.addAttribute("errors", violations);
        return "locations";
    }

     @PostMapping("addLocation")
    public String addLocation(HttpServletRequest request) {
        Location location = new Location();
        BigDecimal latitude = null;
        BigDecimal longitude = null;
        String locationName = request.getParameter("locationName");
        String description = request.getParameter("locationDescription");
        String address = request.getParameter("locationAddress");
        String city = request.getParameter("locationCity");
        String state = request.getParameter("locationState");
        String zipCode = request.getParameter("zipCode");
        if (!request.getParameter("latitude").isEmpty()) {
            try {
                latitude = new BigDecimal(request.getParameter("latitude"));
            } catch (Exception e) {
                latitude = null;
            }
        }
        if (!request.getParameter("longitude").isEmpty()) {
            try {
                longitude = new BigDecimal(request.getParameter("longitude"));
            } catch (Exception e) {
                longitude = null;
            }
        }
        location.setLocationName(locationName);
        location.setLocationDescription(description);
        location.setLocationAddress(address);
        location.setLocationCity(city);
        location.setLocationState(state);
        location.setZipCode(zipCode);
        location.setLatitude(latitude);
        location.setLongitude(longitude);
        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(location);
        if (violations.isEmpty()) {
            locationDao.addLocation(location);
        }
        return "redirect:/locations";
    }
    @GetMapping("deleteLocation")
    public String deleteLocation(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        locationDao.deleteLocationById(id);
        return "redirect:/locations";
    }
    
    @GetMapping("editLocation")
    public String editLocation(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("id"));
        Location location = locationDao.getLocationById(id);
        
        model.addAttribute("location",location);
        return "editLocation";
        
    }
    
     @PostMapping("editLocation")
    public String performEditLocation(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Location location = locationDao.getLocationById(id);
        BigDecimal latitude = null;
        BigDecimal longitude = null;
        String locationName = request.getParameter("locationName");
        String description = request.getParameter("locationDescription");
        String address = request.getParameter("locationAddress");
        String city = request.getParameter("locationCity");
        String state = request.getParameter("locationState");
        String zipCode = request.getParameter("zipCode");
        if (!request.getParameter("latitude").isEmpty()) {
            try {
                latitude = new BigDecimal(request.getParameter("latitude"));
            } catch (Exception e) {
                latitude = null;
            }
        }
        if (!request.getParameter("longitude").isEmpty()) {
            try {
                longitude = new BigDecimal(request.getParameter("longitude"));
            } catch (Exception e) {
                longitude = null;
            }
        }
        location.setLocationName(locationName);
        location.setLocationDescription(description);
        location.setLocationAddress(address);
        location.setLocationCity(city);
        location.setLocationState(state);
        location.setZipCode(zipCode);
        location.setLatitude(latitude);
        location.setLongitude(longitude);
        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(location);
        if (violations.isEmpty()) {
            locationDao.updateLocation(location);
        }
        return "redirect:/locations";
    }

}
