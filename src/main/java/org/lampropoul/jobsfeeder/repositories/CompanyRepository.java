package org.lampropoul.jobsfeeder.repositories;

import org.lampropoul.jobsfeeder.model.Company;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompanyRepository extends MongoRepository<Company, Long> {
}
