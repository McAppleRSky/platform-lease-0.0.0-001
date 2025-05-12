package ru.khtu.lease.statemachine.data.exception;

public class ActionNotCompleteException extends RuntimeException {

    public ActionNotCompleteException(String message) {
        super(message);
    }

}
