package org.lampropoul.jobsfeeder.web;

import org.lampropoul.jobsfeeder.helpers.FeederHelper;
import org.lampropoul.jobsfeeder.model.Company;
import org.lampropoul.jobsfeeder.repositories.CompanyRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/companies")
public class CompaniesController {

    private CompanyRepository companyRepository;
    private FeederHelper<CompanyRepository, Company> feederHelper;

    public CompaniesController(CompanyRepository companyRepository, FeederHelper<CompanyRepository, Company> feederHelper) {
        this.companyRepository = companyRepository;
        this.feederHelper = feederHelper;
    }

    @GetMapping("/name/{name}")
    public List<Company> getNyName(@PathVariable(value = "name") String name) {
        return companyRepository.findAllByName(name);
    }

    @GetMapping("/{id}")
    public Optional<Company> get(@PathVariable(value = "id") Long id) {
        return companyRepository.findById(id);
    }

    @PostMapping
    public ResponseEntity<Company> create(@RequestBody Company company) {
        // TODO: Create location?
        return feederHelper.saveAndGenerateResponse(companyRepository, company);
    }
}
