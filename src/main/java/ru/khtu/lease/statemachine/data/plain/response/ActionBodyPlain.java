package ru.khtu.lease.statemachine.data.plain.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ActionBodyPlain {

    private String woName, action, state;
    private Long[] id;

}
