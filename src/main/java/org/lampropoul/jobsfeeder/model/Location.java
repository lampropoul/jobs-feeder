package org.lampropoul.jobsfeeder.model;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Location extends BaseObject {
    private String country;
    private String region;
    private String city;
    private String municipality;
    private String postalCode;
}
