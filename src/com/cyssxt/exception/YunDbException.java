package com.cyssxt.exception;

import com.cyssxt.constant.ErrorMessage;

public class YunDbException extends Exception {

    ErrorMessage errorMessage;
    public YunDbException(ErrorMessage errorMessage) {
        super(errorMessage.name());
        this.errorMessage = errorMessage;
    }
}
