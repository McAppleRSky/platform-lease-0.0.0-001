package ru.khtu.lease.statemachine.util.helper;

import lombok.NonNull;
import ru.khtu.lease.statemachine.data.dto.StateTransitionSubActionDto;
import ru.khtu.lease.statetransit.data.entity.StateTransitionSubactionEntity;

public class StateTransitionSubactionHelper {

    public static StateTransitionSubActionDto toDto(@NonNull StateTransitionSubactionEntity entity) {
        return new StateTransitionSubActionDto(
                entity.getId(),
                entity.getActionName(),
                entity.getProcessName(),
                entity.getIdStateTransit() );
    }

}
