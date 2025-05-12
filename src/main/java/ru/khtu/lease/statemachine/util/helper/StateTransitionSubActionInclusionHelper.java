package ru.khtu.lease.statemachine.util.helper;

import lombok.NonNull;
import ru.khtu.lease.statemachine.data.dto.StateTransitionSubActionInclusionDto;
import ru.khtu.lease.statetransit.data.entity.StateTransitionSubactionInclusionEntity;

import java.util.ArrayList;
import java.util.List;

public class StateTransitionSubActionInclusionHelper {

    public static StateTransitionSubActionInclusionDto toDto(StateTransitionSubactionInclusionEntity entity) {
        return new StateTransitionSubActionInclusionDto(
                entity.getId(),
                entity.getActionName(),
                entity.getInclusion(),
                entity.getExclusion(),
                entity.getIdStateTransition(),
                entity.getIdStateTransitionSubaction() );
    }

    public static List<StateTransitionSubActionInclusionDto> toDtos(
            @NonNull List<StateTransitionSubactionInclusionEntity> entities ) {
        List<StateTransitionSubActionInclusionDto> result = new ArrayList<>();
        for (StateTransitionSubactionInclusionEntity entity : entities) {
            result.add(toDto(entity));
        }
        return result;
    }

}
