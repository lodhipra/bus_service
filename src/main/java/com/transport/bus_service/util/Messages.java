package com.transport.bus_service.util;

public enum Messages {

    MISSING_REQUIRED_FIELD("Missing required field. Please check documentation for required fields"),
    RECORD_ALREADY_EXISTS("Record already exists"),
    INTERNAL_SERVER_ERROR("Internal server error"),
    NO_RECORD_FOUND("Record with provided id is not found"),
    AUTHENTICATION_FAILED("Authentication failed"),
    UPDATE_RECORD_SUCCESSFUL("Update record Successful"),
    COULD_NOT_UPDATE_RECORD("Could not update record"),
    COULD_NOT_DELETE_RECORD("Could not delete record"),
    EMAIL_ADDRESS_NOT_VERIFIED("Email address could not be verified"),
    REGISTRATION_ERROR("Error in Registration , Please Try Again or Call for Support"),
    REGISTRATION_SUCCESSFUL("You have successfully REgisterd need to Pay Registration Fee to successfully confirm Registration.");
    

    private String message;

    Messages(String messages) {
        this.message = messages;
    }

    public String getMessage() {
        return message;
    }

}
