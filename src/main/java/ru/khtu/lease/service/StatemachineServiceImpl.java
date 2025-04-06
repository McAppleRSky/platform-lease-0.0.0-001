package ru.khtu.lease.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.khtu.lease.component.StatemachineComponent;
import ru.khtu.lease.data.enums.WorkObject;
import ru.khtu.lease.mapper.helper.StateTransitionMapperHelperDto;
import ru.khtu.lease.mapper.helper.StateTransitionSubactionMapperHelperDto;
import ru.khtu.lease.service.json.StateTransitionResponseJsonBuilderImpl;

import java.util.Map;

@RequiredArgsConstructor
@Service
public class StatemachineServiceImpl implements StatemachineService {

    private final StatemachineComponent statemachineComponent;
    private final StateTransitionMapperHelperDto stateTransitionMapperHelperDto;
    private final StateTransitionSubactionMapperHelperDto stateTransitionSubactionMapperHelperDto;
//    private final StateTransitSubactionInclusionMapperDto stateTransitSubactionInclusionMapperDto;
//    private final StateTransitSubactionAttributeMapperDto stateTransitSubactionAttributeMapperDto;

    @Override
    public Map<String, Object> getStateTransition(WorkObject workObject) {
        return new StateTransitionResponseJsonBuilderImpl(workObject, this.statemachineComponent)
                .setState()
                .setTransition(stateTransitionMapperHelperDto)
                .setSubaction(stateTransitionSubactionMapperHelperDto)
                .setInclusion()
                .setAttribute()
                .setModuleForm()
                .build();
    }

}
