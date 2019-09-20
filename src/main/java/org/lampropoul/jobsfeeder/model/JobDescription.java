package org.lampropoul.jobsfeeder.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "job_descriptions")
@EqualsAndHashCode(callSuper = false)
public class JobDescription {
    private String description;
}
