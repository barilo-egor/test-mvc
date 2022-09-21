package org.example.service;


import org.example.dao.LocationDao;
import org.example.entities.Location;
import org.example.enums.DateFormatter;
import org.example.util.DateUtil;
import org.example.vo.LocationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationService {

    @Autowired
    private LocationDao locationDao;

    public Location saveLocationFromForm(LocationForm locationForm, DateFormatter dateFormatter) throws ParseException {

        return locationDao.findById(locationDao.save(convertToLocation(locationForm, dateFormatter)).getId());
    }

    public Location updateLocationFromForm(LocationForm locationForm, DateFormatter dateFormatter) throws ParseException {
        Location location = convertToLocation(locationForm, dateFormatter);
        locationDao.update(location);
        return locationDao.findById(location.getId());
    }

    public Location convertToLocation(LocationForm locationForm, DateFormatter dateFormatter) throws ParseException {
        Location location = new Location();
        location.setId(locationForm.getId());
        location.setName(locationForm.getName());
        location.setMainland(locationForm.getMainland());
        location.setIntroductionDate(DateUtil.convertStringToDate(locationForm.getIntroductionDate(), dateFormatter));
        return location;
    }

    public LocationForm convertToLocationForm(Location location, DateFormatter dateFormatter) throws ParseException {
        LocationForm locationForm = new LocationForm();
        locationForm.setId(location.getId());
        locationForm.setName(location.getName());
        locationForm.setMainland(location.getMainland());
        locationForm.setIntroductionDate(DateUtil.convertDateToString(location.getIntroductionDate(), dateFormatter));
        return locationForm;
    }

    public List<LocationForm> convertToLocationForms(List<Location> locations, DateFormatter dateFormatter) {
        return locationDao.returnAll().stream().map(location -> {
            try {
                return convertToLocationForm(location, dateFormatter);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(Collectors.toList());
    }
}
