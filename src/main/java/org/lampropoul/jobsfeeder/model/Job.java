package org.lampropoul.jobsfeeder.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "jobs")
@EqualsAndHashCode(callSuper = false)
public class Job extends BaseObject {
    private String title;
    private Company company;
    private Location location;
    @JsonProperty("jobDescriptions")
    private List<JobDescription> jobDescriptionList;
    @JsonProperty("requirements")
    private List<Requirement> requirementList;
    @JsonProperty("benefits")
    private List<Benefit> benefitList;
}
