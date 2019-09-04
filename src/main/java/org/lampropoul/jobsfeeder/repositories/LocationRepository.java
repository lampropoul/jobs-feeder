package org.lampropoul.jobsfeeder.repositories;

import org.lampropoul.jobsfeeder.model.Location;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocationRepository extends MongoRepository<Long, Location> {
}
