package org.lampropoul.jobsfeeder.repositories;

import org.lampropoul.jobsfeeder.model.Job;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobRepository extends MongoRepository<Job, Long> {
}
