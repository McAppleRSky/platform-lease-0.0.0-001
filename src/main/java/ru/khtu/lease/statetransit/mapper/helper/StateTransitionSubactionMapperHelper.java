package ru.khtu.lease.statetransit.mapper.helper;

import ru.khtu.lease.statetransit.data.dto.StateTransitionSubactionFullDto;
import ru.khtu.lease.statetransit.data.entity.StateTransitionSubactionEntity;

public class StateTransitionSubactionMapperHelper {

    public static StateTransitionSubactionFullDto toFullDto(StateTransitionSubactionEntity entity) {
        return entity == null ? null : new StateTransitionSubactionFullDto(
                entity.getId(),
                entity.getActionName(),
                entity.getProcessName(),
                entity.getIdStateTransit() );
    }

}
