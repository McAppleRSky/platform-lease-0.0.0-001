package ru.khtu.lease.statetransit.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.khtu.lease.common.data.enums.WorkObject;
import ru.khtu.lease.statetransit.component.StateTransitComponent;
import ru.khtu.lease.statetransit.mapper.helper.StateTransitionMapperHelperDto;
import ru.khtu.lease.statetransit.mapper.helper.StateTransitionSubactionMapperHelperDto;
import ru.khtu.lease.statetransit.service.json.StateTransitionResponseJsonBuilderImpl;

import java.util.Map;

@RequiredArgsConstructor
@Service
public class StateTransitServiceImpl implements StateTransitService {

    private final StateTransitComponent stateTransitComponent;
    private final StateTransitionMapperHelperDto stateTransitionMapperHelperDto;
    private final StateTransitionSubactionMapperHelperDto stateTransitionSubactionMapperHelperDto;

    @Override
    public Map<String, Object> getStateTransition(WorkObject workObject) {
        return new StateTransitionResponseJsonBuilderImpl(workObject, this.stateTransitComponent)
                .setState()
                .setTransition(stateTransitionMapperHelperDto)
                .setSubaction(stateTransitionSubactionMapperHelperDto)
                .setInclusion()
                .setAttribute()
                .setModuleForm()
                .build();
    }

}
