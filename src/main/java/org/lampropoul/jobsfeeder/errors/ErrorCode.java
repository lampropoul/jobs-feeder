package org.lampropoul.jobsfeeder.errors;

public enum ErrorCode {
    EXISTS("ERR001", "FeederModel already exists. Check the id you provided."),
    NOT_EXISTS("ERR002", "FeederModel does not exist.");

    private String code;
    private String description;

    ErrorCode(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.code + ": " + this.description;
    }
}
