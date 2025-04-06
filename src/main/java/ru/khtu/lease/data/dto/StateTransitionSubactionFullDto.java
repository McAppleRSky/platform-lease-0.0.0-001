package ru.khtu.lease.data.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@RequiredArgsConstructor
public class StateTransitionSubactionFullDto {

    private final Long id;

    private final String actionName;

    private final String processName;

    private final Long idStateTransit;

    private List<StateTransitionSubactionInclusionDto> stateTransitionSubactionInclusionDto;

    private List<StateTransitionSubactionAttributeDto> stateTransitionSubactionAttributeDto;

    public List<StateTransitionSubactionModuleFormDto> stateTransitionSubactionModuleFormDto;

}
