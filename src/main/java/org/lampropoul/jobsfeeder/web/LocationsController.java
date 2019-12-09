package org.lampropoul.jobsfeeder.web;

import org.lampropoul.jobsfeeder.helpers.FeederHelper;
import org.lampropoul.jobsfeeder.model.Location;
import org.lampropoul.jobsfeeder.repositories.LocationRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationsController {

    private LocationRepository locationRepository;
    private FeederHelper<LocationRepository, Location> feederHelper;

    public LocationsController(LocationRepository locationRepository, FeederHelper<LocationRepository, Location> feederHelper) {
        this.locationRepository = locationRepository;
        this.feederHelper = feederHelper;
    }

    @PostMapping("/locations/new")
    public ResponseEntity<Location> create(@RequestBody Location location) {
        return feederHelper.saveAndGenerateResponse(locationRepository, location);
    }
}
