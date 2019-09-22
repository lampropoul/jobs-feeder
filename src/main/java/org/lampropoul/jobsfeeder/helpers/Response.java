package org.lampropoul.jobsfeeder.helpers;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.lampropoul.jobsfeeder.errors.ErrorCode;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {
    private T object;
    private ErrorCode errorCode;
}
