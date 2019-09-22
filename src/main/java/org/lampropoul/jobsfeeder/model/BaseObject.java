package org.lampropoul.jobsfeeder.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.time.Instant;

@Data
@Document(collection = "base")
public class BaseObject implements Persistable<Long> {

    @Transient
    public static final String SEQUENCE_NAME = "base_sequence";

    @Id
    protected Long id;

    @CreatedDate
    private Instant createdDate;

    @LastModifiedDate
    private Instant lastModifiedDate;

    @Override
    public boolean isNew() {
        return (this.createdDate == null);
    }
}
