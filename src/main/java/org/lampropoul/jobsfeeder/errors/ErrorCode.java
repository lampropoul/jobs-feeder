package org.lampropoul.jobsfeeder.errors;

public enum ErrorCode {
    ERROR_EXISTS("1", "FeederModel already exists. Check the id you provided.");

    ErrorCode(String code, String description) {

    }
}
