package ru.khtu.lease.data.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

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
