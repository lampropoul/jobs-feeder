package org.lampropoul.jobsfeeder.helpers;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.lampropoul.jobsfeeder.model.BaseObject;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T extends BaseObject> {
    private T object;
    private String error;
}
