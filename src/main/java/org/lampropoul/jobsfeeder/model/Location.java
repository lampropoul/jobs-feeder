package org.lampropoul.jobsfeeder.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "locations")
@EqualsAndHashCode(callSuper = false)
public class Location extends BaseObject {
    private String country;
    private String region;
    private String city;
    private String municipality;
    private String postalCode;
}
