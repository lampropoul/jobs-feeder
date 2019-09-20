package org.lampropoul.jobsfeeder.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "job_descriptions")
public class JobDescription {
    private String description;
}
