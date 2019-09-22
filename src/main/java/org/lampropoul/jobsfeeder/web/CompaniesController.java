package org.lampropoul.jobsfeeder.web;

import org.lampropoul.jobsfeeder.helpers.ControllersHelper;
import org.lampropoul.jobsfeeder.helpers.Response;
import org.lampropoul.jobsfeeder.model.Company;
import org.lampropoul.jobsfeeder.repositories.CompanyRepository;
import org.lampropoul.jobsfeeder.services.SequenceGeneratorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CompaniesController {

    private CompanyRepository companyRepository;
    private SequenceGeneratorService sequenceGeneratorService;

    public CompaniesController(CompanyRepository companyRepository, SequenceGeneratorService sequenceGeneratorService) {
        this.companyRepository = companyRepository;
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
    public Response<Company> create(@RequestBody Company company) {
        // TODO: Create location
        return new ControllersHelper<CompanyRepository, Company>().saveAndGenerateResponse(companyRepository, company, sequenceGeneratorService);
    }
}
