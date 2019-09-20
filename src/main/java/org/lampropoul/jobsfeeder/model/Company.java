package org.lampropoul.jobsfeeder.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "companies")
@EqualsAndHashCode(callSuper = false)
public class Company extends BaseObject {
    private String name;
    private Location location;
    private String description;
    private short numOfJobs;
}
