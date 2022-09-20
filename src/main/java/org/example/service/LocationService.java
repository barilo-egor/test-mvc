package org.example.service;


import org.example.dao.LocationDao;
import org.example.entities.Location;
import org.example.enums.DateFormatter;
import org.example.vo.LocationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;

@Service
public class LocationService {

    @Autowired
    private LocationDao locationDao;

    public Date convertStringToDate(String date, DateFormatter dateFormatter) throws ParseException {
        return dateFormatter.getSimpleDateFormat().parse(date);

    }

    public String convertDateToString(Date date, DateFormatter dateFormatter) throws ParseException {
        return dateFormatter.getSimpleDateFormat().format(date);

    }

    public Location saveLocationFromForm(LocationForm locationForm, DateFormatter dateFormatter) throws ParseException {

        return locationDao.findById(locationDao.save(locationConvert(locationForm, dateFormatter)).getId());
    }

    public Location updateLocationFromForm(LocationForm locationForm, DateFormatter dateFormatter) throws ParseException {
        Location location = locationConvert(locationForm, dateFormatter);
        locationDao.update(location);
        return locationDao.findById(location.getId());
    }

    public Location locationConvert(LocationForm locationForm, DateFormatter dateFormatter) throws ParseException {
        if (locationForm.getId() != null) {
            return new Location(
                    locationForm.getId(),
                    locationForm.getName(),
                    locationForm.getMainland(),
                    convertStringToDate(locationForm.getIntroductionDate(), dateFormatter));
        } else {
            return new Location(
                    locationForm.getName(),
                    locationForm.getMainland(),
                    convertStringToDate(locationForm.getIntroductionDate(), dateFormatter));
        }
    }

    public LocationForm locationConvert(Location location, DateFormatter dateFormatter) throws ParseException {
        return new LocationForm(
                location.getId(),
                location.getName(),
                location.getMainland(),
                convertDateToString(location.getIntroductionDate(), dateFormatter));
    }
}
