package ru.khtu.lease.statemachine.util.helper;

import ru.khtu.lease.statemachine.data.dto.StateTransitionDto;
import ru.khtu.lease.statetransit.data.entity.StateTransitionEntity;

import java.util.ArrayList;
import java.util.List;

public class StateTransitionMapperHelper {

    public static StateTransitionDto toDto(StateTransitionEntity entity) {
        return new StateTransitionDto(
                entity.getId(),
                entity.getWoName(),
                entity.getActionName(),
                entity.getActionLabel(),
                entity.getCurrentState(),
                entity.getNextState(),
                entity.getCustomUrl(),
                entity.getClassName(),
                entity.getMethodName(),
                entity.getDefaultDisplay(),
                entity.getReadOnly(),
                entity.getCloseWindow(),
                entity.getSecondaryAction() );
    }

    public static List<StateTransitionDto> toFullDtos(List<StateTransitionEntity> entities) {
        List<StateTransitionDto> result = new ArrayList<>();
        for (StateTransitionEntity entity : entities) {
            result.add( toDto(entity) );
        }
        return result;
    }

}
