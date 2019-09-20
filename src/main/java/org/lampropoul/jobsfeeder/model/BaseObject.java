package org.lampropoul.jobsfeeder.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

@Data
@Document(collection = "base")
public class BaseObject {

    @Transient
    public static final String SEQUENCE_NAME = "base_sequence";

    @Id
    protected long id;

    @CreatedDate
    protected Date createdAt;

    @LastModifiedDate
    protected Date updatedAt;
}
