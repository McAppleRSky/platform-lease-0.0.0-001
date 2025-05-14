package ru.khtu.lease.common.componentService;

import ru.khtu.lease.statetransit.data.entity.StateTransitionSubactionAttributeEntity;
import ru.khtu.lease.statetransit.data.entity.StateTransitionSubactionEntity;
import ru.khtu.lease.statetransit.data.entity.StateTransitionSubactionInclusionEntity;

import java.util.List;

public interface StateMachineSubActionService {

    StateTransitionSubactionEntity findSubAction(Long id);

    List<StateTransitionSubactionInclusionEntity> findInclusion(Long transitId, Long subActionId);

    List<StateTransitionSubactionAttributeEntity> findAttribute(Long transitId, Long subActionId);

}
