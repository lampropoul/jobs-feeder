package org.lampropoul.jobsfeeder.model;

import lombok.Data;

@Data
public class Company extends BaseObject {
    private String name;
    private Location location;
    private String description;
    private short numOfJobs;
}
