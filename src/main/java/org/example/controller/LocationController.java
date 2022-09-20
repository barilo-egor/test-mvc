package org.example.controller;

import org.example.dao.LocationDao;
import org.example.entities.Location;
import org.example.enums.DateFormatter;
import org.example.enums.Mainland;
import org.example.enums.ModelMapper;
import org.example.service.JspMappingService;
import org.example.service.LocationService;
import org.example.vo.LocationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;

@Controller
@RequestMapping("/jsp/entities/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @Autowired
    private LocationDao locationDao;

    @Autowired
    private JspMappingService jspMappingService;

    @RequestMapping("/list.form")
    public ModelAndView list() {

        return new ModelAndView("location/locations", "locations", locationDao.returnAll());
    }

    @RequestMapping("/add.form")
    public ModelAndView add() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("locationForm", new LocationForm());
        modelAndView.addObject("mainlands", Mainland.values());
        modelAndView.setViewName("location/locationAdd");
        return modelAndView;
    }

    @RequestMapping(value = "/save.form", method = RequestMethod.POST)
    public String save(@ModelAttribute("locationForm") LocationForm locationForm, ModelMap model) throws ParseException {
        Location location;
        if (locationForm.getId() != null) location = locationService.updateLocationFromForm(locationForm, DateFormatter.DATE_FORMATTER_JSP);
        else location = locationService.saveLocationFromForm(locationForm, DateFormatter.DATE_FORMATTER_JSP);
        jspMappingService.mapObject(location, ModelMapper.LOCATION, model);
        return "location/locationSave";
    }

    @RequestMapping(value = "/{id}/edit.form")
    public ModelAndView edit(@PathVariable("id") Integer id) throws ParseException {
        LocationForm locationForm = locationService.locationConvert(locationDao.findById(id), DateFormatter.DATE_FORMATTER_JSP);
        return new ModelAndView("location/locationEdit", "locationForm",
                locationForm);
    }

    @RequestMapping("/{id}/delete.form")
    public ModelAndView delete(@PathVariable("id") Integer id) {
        locationDao.delete(locationDao.findById(id));
        return new ModelAndView("redirect:/jsp/entities/location/list.form", "locations",
                locationDao.returnAll());
    }
}
