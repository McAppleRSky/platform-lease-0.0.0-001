package ru.khtu.lease.statemachine.data.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;

@Getter
@RequiredArgsConstructor
public class StateTransitionSubActionModuleFormDto {

    private final Long id;
    private final String module;
    private final String form;
    private final Long idStateTransition;
    private final Long idStateTransitionSubaction;

}
