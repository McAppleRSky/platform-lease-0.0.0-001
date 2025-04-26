package ru.khtu.lease.statetransit.data.dto;

import lombok.Data;

@Data
public class StateTransitionMinDto {

    //private final Long id;

    private String woName;

    private String actionName;

    private String actionLabel;

    private String currentState;

    private String nextState;

    private String customUrl;

    private String nameOfClass//className
            ;
    private String nameOfMethod//methodName
            ;
    private Boolean defaultDisplay;

    private Boolean isReadOnly//readOnly
            ;
    private Boolean closeWindow;

    private Boolean secondaryAction;

}
