package org.lampropoul.jobsfeeder.model;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Requirement extends BaseObject {
    private String description;
}
