package ru.khtu.lease.statetransit.component;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.khtu.lease.statetransit.data.dto.StateTransitionSubactionFullDto;
import ru.khtu.lease.statetransit.mapper.StateTransitSubactionAttributeMapperDto;
import ru.khtu.lease.statetransit.mapper.StateTransitSubactionInclusionMapperDto;
import ru.khtu.lease.statetransit.repository.StateTransitionSubactionAttributeRepository;
import ru.khtu.lease.statetransit.repository.StateTransitionSubactionInclusionRepository;

@RequiredArgsConstructor
@Component
public class StateTransitSubactionInclusionAttributeComponentImpl implements StateTransitSubactionInclusionAttributeComponent {

    private final StateTransitionSubactionInclusionRepository stateTransitionSubactionInclusionRepository;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private final StateTransitSubactionInclusionMapperDto stateTransitSubactionInclusionMapper;
    private final StateTransitionSubactionAttributeRepository stateTransitionSubactionAttributeRepository;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private final StateTransitSubactionAttributeMapperDto stateTransitSubactionAttributeMapper;

    @Override
    public void getByStateTransitionsSubactionAndPut(StateTransitionSubactionFullDto stateTransitionSubaction) {
        stateTransitionSubaction.setStateTransitionSubactionInclusionDto(
                stateTransitSubactionInclusionMapper.toDtos(
                        stateTransitionSubactionInclusionRepository.findByStateTransitionIdAndStateTransitionSubactionId(
                                stateTransitionSubaction.getIdStateTransit(),
                                stateTransitionSubaction.getId() ) ) );
        stateTransitionSubaction.setStateTransitionSubactionAttributeDto(
                stateTransitSubactionAttributeMapper.toDtos(
                        stateTransitionSubactionAttributeRepository.findByStateTransitionIdAndStateTransitionSubactionId(
                                stateTransitionSubaction.getIdStateTransit(),
                                stateTransitionSubaction.getId() ) ) );
    }

}
