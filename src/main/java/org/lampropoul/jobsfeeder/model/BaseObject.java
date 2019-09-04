package org.lampropoul.jobsfeeder.model;

import lombok.Data;

import java.util.Date;

@Data
public class BaseObject {
    protected Long id;
    protected Date createdAt;
    protected Date updatedAt;
}
