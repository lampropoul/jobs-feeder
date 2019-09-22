package org.lampropoul.jobsfeeder.repositories;

import org.lampropoul.jobsfeeder.model.Company;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CompanyRepository extends MongoRepository<Company, Long> {

    List<Company> findAllByName(String name);
}
