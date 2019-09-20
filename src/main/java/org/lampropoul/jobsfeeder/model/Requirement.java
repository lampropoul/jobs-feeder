package org.lampropoul.jobsfeeder.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "requirements")
@EqualsAndHashCode(callSuper = false)
public class Requirement extends BaseObject {
    private String description;
}
