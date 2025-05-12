package ru.khtu.lease.statemachine.util.entity;

public interface EntityCreateAble {

    Long getSpecId();
    void setSpecId(Long id);
    String getWoIdTX();
    void setWoIdTX(String id);
    void setWoRecordStateSY(String string);
//    String getWoRecordStateSY();
    void setWoPreviousStateSY(String string);
//    String getWoPreviousStateSY();

}
