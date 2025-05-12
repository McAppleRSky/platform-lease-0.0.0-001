package ru.khtu.lease.statemachine.data.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;

@Getter
@RequiredArgsConstructor
public class StateTransitionSubActionInclusionDto {

    private final Long id;
    private final String actionName;
    private final Boolean inclusion;
    private final Boolean exclusion;
    private final Long idStateTransition;
    private final Long idStateTransitionSubaction;

}
