package ru.khtu.lease.statemachine.data.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;

@Getter
@RequiredArgsConstructor
public class StateTransitionSubActionAttributeDto {

    private final Long id;
    private final String fieldName;
    private final String constValue;
    private final Long idStateTransition;
    private final Long idStateTransitionSubaction;

}
