package org.lampropoul.jobsfeeder.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "jobs")
public class Job extends BaseObject {
    private String title;
    private List<JobDescription> jobDescriptionList;
    private List<Requirement> requirementList;
    private List<Benefit> benefitList;
}
