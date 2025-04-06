package ru.khtu.lease.mapper.helper;

import ru.khtu.lease.data.dto.StateTransitionSubactionFullDto;
import ru.khtu.lease.data.entity.StateTransitionSubactionEntity;

public class StateTransitionSubactionMapperHelper {

    public static StateTransitionSubactionFullDto toFullDto(StateTransitionSubactionEntity entity) {
        return entity == null ? null : new StateTransitionSubactionFullDto(
                entity.getId(),
                entity.getActionName(),
                entity.getProcessName(),
                entity.getIdStateTransit() );
    }

}
