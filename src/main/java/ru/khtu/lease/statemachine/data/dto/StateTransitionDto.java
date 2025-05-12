package ru.khtu.lease.statemachine.data.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter
@RequiredArgsConstructor
public class StateTransitionDto {

    private final Long id;

    private final String woName;

    private final String actionName;

    private final String actionLabel;

    private final String currentState;

    private final String nextState;

    private final String customUrl;

    private final String className;

    private final String methodName;

    private final Boolean defaultDisplay;

    private final Boolean readOnly;

    private final Boolean closeWindow;

    private final Boolean secondaryAction;

    private StateTransitionSubActionDto stateTransitionSubaction;

}
