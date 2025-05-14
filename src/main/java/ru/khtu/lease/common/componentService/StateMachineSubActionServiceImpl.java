package ru.khtu.lease.common.componentService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.khtu.lease.statetransit.data.entity.StateTransitionSubactionAttributeEntity;
import ru.khtu.lease.statetransit.data.entity.StateTransitionSubactionEntity;
import ru.khtu.lease.statetransit.data.entity.StateTransitionSubactionInclusionEntity;
import ru.khtu.lease.statetransit.repository.StateTransitionSubactionAttributeRepository;
import ru.khtu.lease.statetransit.repository.StateTransitionSubactionInclusionRepository;
import ru.khtu.lease.statetransit.repository.StateTransitionSubactionRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StateMachineSubActionServiceImpl implements StateMachineSubActionService {

    private final StateTransitionSubactionRepository stateTransitionSubactionRepository;
    private final StateTransitionSubactionInclusionRepository stateTransitionSubactionInclusionRepository;
    private final StateTransitionSubactionAttributeRepository stateTransitionSubactionAttributeRepository;

    @Override
    public StateTransitionSubactionEntity findSubAction(Long id) {
        return stateTransitionSubactionRepository.findById(id);
    }

    @Override
    public List<StateTransitionSubactionInclusionEntity> findInclusion(Long transitId, Long subActionId) {
        return stateTransitionSubactionInclusionRepository
                .findByStateTransitionIdAndStateTransitionSubactionId(transitId, subActionId);
    }

    @Override
    public List<StateTransitionSubactionAttributeEntity> findAttribute(Long transitId, Long subActionId) {
        return stateTransitionSubactionAttributeRepository
                .findByStateTransitionIdAndStateTransitionSubactionId(transitId, subActionId);
    }

}
