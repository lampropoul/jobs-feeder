package org.lampropoul.jobsfeeder.web;

import org.lampropoul.jobsfeeder.model.BaseObject;
import org.lampropoul.jobsfeeder.model.Company;
import org.lampropoul.jobsfeeder.model.Location;
import org.lampropoul.jobsfeeder.repositories.CompanyRepository;
import org.lampropoul.jobsfeeder.repositories.LocationRepository;
import org.lampropoul.jobsfeeder.services.SequenceGeneratorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class CompaniesController {

    private CompanyRepository companyRepository;
    private LocationRepository locationRepository;
    private SequenceGeneratorService sequenceGeneratorService;

    public CompaniesController(CompanyRepository companyRepository, LocationRepository locationRepository, SequenceGeneratorService sequenceGeneratorService) {
        this.companyRepository = companyRepository;
        this.locationRepository = locationRepository;
        this.sequenceGeneratorService = sequenceGeneratorService;
    }

    @GetMapping("/companies/name/{name}")
    public List<Company> getNyName(@PathVariable(value = "name") String name) {
        return companyRepository.findAllByName(name);
    }

    @GetMapping("/companies/{id}")
    public Optional<Company> get(@PathVariable(value = "id") Long id) {
        return companyRepository.findById(id);
    }

    @PostMapping("/companies/new")
    public Company create(@RequestBody Company company) {
        company.setId(sequenceGeneratorService.generateSequence(BaseObject.SEQUENCE_NAME));
        Location location = company.getLocation();
        if (location != null) {
            Long locationId = (location.getId() != null) ? location.getId() : 0L;
            if (!locationRepository.existsById(locationId)) {
                location.setId(sequenceGeneratorService.generateSequence(BaseObject.SEQUENCE_NAME));
                locationRepository.save(location);
            }
        }
        return companyRepository.save(company);
    }
}
