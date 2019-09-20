package org.lampropoul.jobsfeeder.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "benefits")
@EqualsAndHashCode(callSuper = false)
public class Benefit extends BaseObject {
    private String description;
}
