package org.lampropoul.jobsfeeder.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "companies")
@EqualsAndHashCode(callSuper = false)
public class Company extends BaseObject {
    private String name;
    @JsonProperty("locations")
    private List<Location> locationList;
    private String description;
    private Short numOfJobs;
}
