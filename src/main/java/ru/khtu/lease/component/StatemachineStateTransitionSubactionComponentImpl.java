package ru.khtu.lease.component;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.khtu.lease.data.dto.StateTransitionFullDto;
import ru.khtu.lease.mapper.helper.StateTransitionSubactionMapperHelper;
import ru.khtu.lease.repository.StateTransitionSubactionRepository;

import java.util.List;

@RequiredArgsConstructor
@Component
public class StatemachineStateTransitionSubactionComponentImpl implements StatemachineStateTransitionSubactionComponent {

    private final StateTransitionSubactionRepository stateTransitionSubactionRepository;
    private final StatemachineStateTransitionSubactionInclusionAttributeComponent statemachineStateTransitionSubactionInclusionAttributeComponent;

    @Override
    public void getByStateTransitionsAndPutSubaction(List<StateTransitionFullDto> stateTransitions) {
        for (StateTransitionFullDto stateTransition : stateTransitions) {
            stateTransition.setStateTransitionSubaction(
                    StateTransitionSubactionMapperHelper.toFullDto(
                            stateTransitionSubactionRepository.findById(stateTransition.getId() ) ) );
            if (stateTransition.getStateTransitionSubaction() != null) {
                statemachineStateTransitionSubactionInclusionAttributeComponent.getByStateTransitionsSubactionAndPut(
                        stateTransition.getStateTransitionSubaction() );
            }
        }
    }

}
