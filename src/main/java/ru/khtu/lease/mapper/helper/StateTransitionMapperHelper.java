package ru.khtu.lease.mapper.helper;

import ru.khtu.lease.data.entity.StateTransitionEntity;
import ru.khtu.lease.data.dto.StateTransitionFullDto;

import java.util.ArrayList;
import java.util.List;

public class StateTransitionMapperHelper// extends MapperDto<StateTransitionEntity, StateTransitionHelper>
{

    public static List<StateTransitionFullDto> toFullDto(List<StateTransitionEntity> entities) {
        List<StateTransitionFullDto> result = new ArrayList<>();
        for (StateTransitionEntity entity : entities) {
            result.add(
                    new StateTransitionFullDto(
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
                            entity.getSecondaryAction() ) );
        }
        return result;
    }

}
