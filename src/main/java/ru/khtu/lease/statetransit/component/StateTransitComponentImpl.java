package ru.khtu.lease.statetransit.component;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.khtu.lease.common.componentSh.repository.StateRepository;
import ru.khtu.lease.common.data.dto.StateDto;
import ru.khtu.lease.common.data.enums.WorkObject;
import ru.khtu.lease.statetransit.data.dto.StateTransitionFullDto;
import ru.khtu.lease.statetransit.mapper.StateMapperDto;
import ru.khtu.lease.statetransit.mapper.helper.StateTransitionMapperHelper;
import ru.khtu.lease.statetransit.repository.StateTransitionRepository;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Getter
@RequiredArgsConstructor
@Component
public class StateTransitComponentImpl implements StateTransitComponent {

    private final StateRepository stateRepository;
    @Qualifier("statetransit")
    private final StateMapperDto stateMapper;
    private final StateTransitionRepository stateTransitionRepository;
    private final StateTransitSubactionComponent stateTransitSubactionComponent;

    public Map.Entry<List<StateDto>, List<StateTransitionFullDto>> getStateTransition(WorkObject workObject) {
        List<StateDto> state = stateMapper.toDtos(
                stateRepository.findByWoName(workObject.getString()) );
        List<StateTransitionFullDto> transition = StateTransitionMapperHelper.toFullDtos(
                stateTransitionRepository.findByWoName(workObject.getString()) );
        stateTransitSubactionComponent.getByStateTransitionsAndPutSubaction(transition);
        return Collections.singletonMap(state, transition).entrySet().iterator().next();
    }

}
