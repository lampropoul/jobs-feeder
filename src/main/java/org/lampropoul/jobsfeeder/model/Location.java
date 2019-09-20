package org.lampropoul.jobsfeeder.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "locations")
public class Location extends BaseObject {
    private String country;
    private String region;
    private String city;
    private String municipality;
    private String postalCode;
}
