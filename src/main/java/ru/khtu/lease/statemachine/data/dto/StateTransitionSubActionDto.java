package ru.khtu.lease.statemachine.data.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@RequiredArgsConstructor
public class StateTransitionSubActionDto {

    private final Long id;
    private final String actionName;
    private final String processName;
    private final Long idStateTransit;
    private List<StateTransitionSubActionInclusionDto> stateTransitionSubActionInclusion;
    private List<StateTransitionSubActionAttributeDto> stateTransitionSubActionAttribute;
    private List<StateTransitionSubActionModuleFormDto> stateTransitionSubActionModuleForm;

}
