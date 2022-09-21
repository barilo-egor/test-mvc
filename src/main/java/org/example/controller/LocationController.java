package org.example.controller;

import org.example.dao.LocationDao;
import org.example.enums.DateFormatter;
import org.example.enums.ModelMapper;
import org.example.service.JspMappingService;
import org.example.service.LocationService;
import org.example.vo.LocationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
        return new ModelAndView("location/locations", "locationForms",
                locationService.convertToLocationForms(locationDao.returnAll(), DateFormatter.DATE_FORMATTER_JSP));
    }

    @RequestMapping("/add.form")
    public ModelAndView add() {
        return new ModelAndView("location/locationAdd", "locationForm", new LocationForm());
    }

    @RequestMapping(value = "/save.form", method = RequestMethod.POST)
    public String save(@ModelAttribute("locationForm") LocationForm locationForm, ModelMap model) throws ParseException {
        if (locationForm.getId() != null)
            locationService.updateLocationFromForm(locationForm, DateFormatter.DATE_FORMATTER_JSP);
        else
            locationForm.setId(locationService.saveLocationFromForm(locationForm, DateFormatter.DATE_FORMATTER_JSP).getId());
        jspMappingService.mapObject(locationForm, ModelMapper.LOCATION_FORM, model);
        return "location/locationSave";
    }

    @RequestMapping(value = "/{id}/edit.form")
    public ModelAndView edit(@PathVariable("id") Integer id) throws ParseException {
        LocationForm locationForm = locationService.convertToLocationForm(locationDao.findById(id), DateFormatter.DATE_FORMATTER_JSP);
        return new ModelAndView("location/locationEdit", "locationForm", locationForm);
    }

    @RequestMapping("/{id}/delete.form")
    public ModelAndView delete(@PathVariable("id") Integer id) {
        locationDao.delete(locationDao.findById(id));
        return new ModelAndView("redirect:/jsp/entities/location/list.form", "locations",
                locationDao.returnAll());
    }
}
