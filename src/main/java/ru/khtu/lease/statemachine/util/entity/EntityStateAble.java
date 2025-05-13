package ru.khtu.lease.statemachine.util.entity;

public interface EntityStateAble {

    String getWoRecordStateSY();
    void setWoRecordStateSY(String state);
    void setWoPreviousStateSY(String state);

}
