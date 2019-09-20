package org.lampropoul.jobsfeeder.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "benefits")
public class Benefit extends BaseObject {
    private String description;
}
