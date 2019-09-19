package org.lampropoul.jobsfeeder.web;

import org.lampropoul.jobsfeeder.model.Company;
import org.lampropoul.jobsfeeder.repositories.CompanyRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CompaniesController {

    private CompanyRepository companyRepository;

    public CompaniesController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @GetMapping("/companies/{name}")
    public List<Company> getNyName(@PathVariable(value = "name") String name) {
        return companyRepository.findAllByName(name);
    }

    @GetMapping("/company/{id}")
    public Optional<Company> get(@PathVariable(value = "id") Long id) {
        return companyRepository.findById(id);
    }
}
