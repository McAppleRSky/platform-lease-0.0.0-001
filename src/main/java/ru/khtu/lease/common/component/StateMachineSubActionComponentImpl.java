package ru.khtu.lease.common.component;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.khtu.lease.common.data.dto.StateMachineSubActionDto;
import ru.khtu.lease.common.data.enums.WorkObject;
import ru.khtu.lease.common.service.StateMachineSubActionService;
import ru.khtu.lease.common.util.helper.StateTransitionSubActionAttributeHelper;
import ru.khtu.lease.statemachine.data.dto.StateTransitionDto;
import ru.khtu.lease.statemachine.data.dto.StateTransitionSubActionInclusionDto;
import ru.khtu.lease.statemachine.data.exception.ActionNotCompleteException;
import ru.khtu.lease.statemachine.util.helper.StateTransitionSubactionHelper;
import ru.khtu.lease.statetransit.data.entity.StateTransitionSubactionAttributeEntity;
import ru.khtu.lease.statetransit.data.entity.StateTransitionSubactionEntity;
import ru.khtu.lease.statetransit.data.entity.StateTransitionSubactionInclusionEntity;
import ru.khtu.lease.statemachine.util.helper.StateTransitionSubActionInclusionHelper;

import java.util.List;

@RequiredArgsConstructor
@Component
public class StateMachineSubActionComponentImpl implements StateMachineSubActionComponent {

    private final StateMachineSubActionService stateMachineSubActionService;

    @Override
    public void method(List<StateMachineSubActionDto> stateMachineSubActionDtos) throws ActionNotCompleteException {
        for (StateMachineSubActionDto stateMachineSubActionDto : stateMachineSubActionDtos) {
            WorkObject woType = stateMachineSubActionDto.getWorkObjectDto().getType();
            Long specId = stateMachineSubActionDto.getWorkObjectDto().getId(),
                    transitId = null, subActionId = null;
            StateTransitionDto stateTransition = stateMachineSubActionDto.getStateTransitionDto();
            transitId = stateTransition.getId();
            StateTransitionSubactionEntity stateTransitionSubactionEntity = this.stateMachineSubActionService
                    .findSubAction(transitId);
            if (stateTransitionSubactionEntity != null) {
                stateTransition.setStateTransitionSubaction(
                        StateTransitionSubactionHelper.toDto(stateTransitionSubactionEntity) );
                if (stateTransitionSubactionEntity.getId() != null) {
                    subActionId = stateTransitionSubactionEntity.getId();
                }
            }
            if (subActionId != null) {
                List<StateTransitionSubactionInclusionEntity> inclusionEntities = this.stateMachineSubActionService
                        .findInclusion(transitId, subActionId);
                if (inclusionEntities != null && !inclusionEntities.isEmpty()) {
                    stateTransition.getStateTransitionSubaction().setStateTransitionSubActionInclusion(
                            StateTransitionSubActionInclusionHelper.toDtos(inclusionEntities) );
                }
                List<StateTransitionSubactionAttributeEntity> attributeEntities = this.stateMachineSubActionService
                        .findAttribute(transitId, subActionId);
                if (attributeEntities != null && !attributeEntities.isEmpty()) {
                    stateTransition.getStateTransitionSubaction().setStateTransitionSubActionAttribute(
                            StateTransitionSubActionAttributeHelper.toDtos(attributeEntities) );
                }
            }
        }
        System.out.println();
    }

}
