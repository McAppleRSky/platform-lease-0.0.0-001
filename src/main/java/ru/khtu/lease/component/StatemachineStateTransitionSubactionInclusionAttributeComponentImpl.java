package ru.khtu.lease.component;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.khtu.lease.data.dto.StateTransitionSubactionFullDto;
import ru.khtu.lease.mapper.StateTransitSubactionAttributeMapperDto;
import ru.khtu.lease.mapper.StateTransitSubactionInclusionMapperDto;
import ru.khtu.lease.repository.StateTransitionSubactionAttributeRepository;
import ru.khtu.lease.repository.StateTransitionSubactionInclusionRepository;

@RequiredArgsConstructor
@Component
public class StatemachineStateTransitionSubactionInclusionAttributeComponentImpl implements StatemachineStateTransitionSubactionInclusionAttributeComponent {

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
