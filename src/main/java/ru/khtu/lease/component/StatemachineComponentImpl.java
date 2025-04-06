package ru.khtu.lease.component;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.khtu.lease.data.dto.StateDto;
import ru.khtu.lease.data.enums.WorkObject;
import ru.khtu.lease.data.dto.StateTransitionFullDto;
import ru.khtu.lease.mapper.StateMapperDto;
import ru.khtu.lease.mapper.helper.StateTransitionMapperHelper;
import ru.khtu.lease.repository.StateRepository;
import ru.khtu.lease.repository.StateTransitionRepository;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Getter
@Component
public class StatemachineComponentImpl implements StatemachineComponent {

    private final StateRepository stateRepository;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private final StateMapperDto stateMapper;
    private final StateTransitionRepository stateTransitionRepository;
    private final StatemachineStateTransitionSubactionComponent statemachineStateTransitionSubactionComponent;

    public Map.Entry<List<StateDto>, List<StateTransitionFullDto>> getStateTransition(WorkObject workObject) {
        List<StateDto> state = stateMapper.toDtos(
                stateRepository.findByWoName(workObject.getString()) );
        List<StateTransitionFullDto> transition = StateTransitionMapperHelper.toFullDto(
                stateTransitionRepository.findByWoName(workObject.getString()) );
        statemachineStateTransitionSubactionComponent.getByStateTransitionsAndPutSubaction(transition);
        return Collections.singletonMap(state, transition).entrySet().iterator().next();
    }

}
