package org.lampropoul.jobsfeeder.model;

import lombok.Data;

import javax.persistence.Entity;
import java.util.List;

@Data
@Entity
public class Job extends BaseObject {
    private String title;
    private List<JobDescription> jobDescriptionList;
    private List<Requirement> requirementList;
    private List<Benefit> benefitList;
}
