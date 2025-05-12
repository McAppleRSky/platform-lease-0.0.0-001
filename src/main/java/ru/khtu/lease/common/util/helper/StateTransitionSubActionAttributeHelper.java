package ru.khtu.lease.common.util.helper;

import lombok.NonNull;
import ru.khtu.lease.statemachine.data.dto.StateTransitionSubActionAttributeDto;
import ru.khtu.lease.statetransit.data.entity.StateTransitionSubactionAttributeEntity;

import java.util.ArrayList;
import java.util.List;

public class StateTransitionSubActionAttributeHelper {

    public static StateTransitionSubActionAttributeDto toDto(StateTransitionSubactionAttributeEntity attributeEntity ) {
        return new StateTransitionSubActionAttributeDto(
                attributeEntity.getId(),
                attributeEntity.getFieldName(),
                attributeEntity.getConstValue(),
                attributeEntity.getIdStateTransition(),
                attributeEntity.getIdStateTransitionSubaction()
        );
    }

        public static List<StateTransitionSubActionAttributeDto> toDtos(
            @NonNull List<StateTransitionSubactionAttributeEntity> attributeEntities ) {
        List<StateTransitionSubActionAttributeDto> result = new ArrayList<>();
        for (StateTransitionSubactionAttributeEntity attributeEntity : attributeEntities) {
            result.add(toDto(attributeEntity));
        }
        return result;
    }

}
