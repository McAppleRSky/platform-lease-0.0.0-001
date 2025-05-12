package ru.khtu.lease.statemachine.util.entity;

import javax.persistence.Column;

public interface EntityStateAble {

    String getWoRecordStateSY();
    void setWoRecordStateSY(String state);
    void setWoPreviousStateSY(String state);

}
