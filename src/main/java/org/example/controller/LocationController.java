package org.example.controller;

import org.example.dao.LocationDao;
import org.example.entities.Location;
import org.example.enums.Mainland;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/jsp/entities/location")
public class LocationController {

    @Autowired
    private LocationDao locationDao;

    @RequestMapping("/list.form")
    public ModelAndView showLocations() {

        return new ModelAndView("locations", "locations", locationDao.returnAll());
    }

    @RequestMapping("/add.form")
    public ModelAndView showLocationSaveForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("location", new Location());
        modelAndView.addObject("mainlands", Mainland.values());
        modelAndView.setViewName("locationAdd");
        return modelAndView;
    }

    @RequestMapping(value = "/save.form", method = RequestMethod.POST)
    public String saveLocation(@ModelAttribute("location") Location location, ModelMap model) {
        locationDao.save(location);
        model.addAttribute("id", location.getId());
        model.addAttribute("name", location.getName());
        model.addAttribute("mainlandName", location.getMainland().getDisplayName());
        return "locationSave";
    }

    @RequestMapping(value = "/{id}/edit.form")
    public ModelAndView showLocationEditForm(@PathVariable("id") Integer id) {
        return new ModelAndView("locationEdit", "location", locationDao.findById(id));
    }

    @RequestMapping(value = "/{id}/update.form", method = RequestMethod.POST)
    public String updateLocation(@ModelAttribute("location") Location location, ModelMap model) {
        locationDao.update(location);
        model.addAttribute("id", location.getId());
        model.addAttribute("name", location.getName());
        model.addAttribute("mainlandName", location.getMainland().getDisplayName());
        return "locationUpdate";
    }

    @RequestMapping("/{id}/delete.form")
    public ModelAndView deleteLocation(@PathVariable("id") Integer id) {
        locationDao.delete(locationDao.findById(id));
        return new ModelAndView("redirect:/jsp/entities/location/list.form", "locations", locationDao.returnAll());
    }
}
