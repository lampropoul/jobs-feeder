package org.lampropoul.jobsfeeder.web;

import org.lampropoul.jobsfeeder.helpers.ControllersHelper;
import org.lampropoul.jobsfeeder.helpers.Response;
import org.lampropoul.jobsfeeder.model.Location;
import org.lampropoul.jobsfeeder.repositories.LocationRepository;
import org.lampropoul.jobsfeeder.services.SequenceGeneratorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationsController {

    private LocationRepository locationRepository;
    private SequenceGeneratorService sequenceGeneratorService;

    public LocationsController(LocationRepository locationRepository, SequenceGeneratorService sequenceGeneratorService) {
        this.locationRepository = locationRepository;
        this.sequenceGeneratorService = sequenceGeneratorService;
    }

    @PostMapping("/locations/new")
    public Response<Location> create(@RequestBody Location location) {
        return new ControllersHelper<LocationRepository, Location>().generateResponseOnCreate(locationRepository, location, sequenceGeneratorService);
    }
}
