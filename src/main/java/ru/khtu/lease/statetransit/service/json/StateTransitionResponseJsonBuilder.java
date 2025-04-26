package ru.khtu.lease.statetransit.service.json;

import ru.khtu.lease.statetransit.mapper.helper.StateTransitionMapperHelperDto;
import ru.khtu.lease.statetransit.mapper.helper.StateTransitionSubactionMapperHelperDto;

import java.util.Map;

public interface StateTransitionResponseJsonBuilder {

    StateTransitionResponseJsonBuilder setState();

    StateTransitionResponseJsonBuilder setTransition(
            StateTransitionMapperHelperDto stateTransitionMapperHelperDto );

    StateTransitionResponseJsonBuilder setSubaction(
            StateTransitionSubactionMapperHelperDto stateTransitionSubactionMapperHelperDto );

    StateTransitionResponseJsonBuilder setInclusion();

    StateTransitionResponseJsonBuilder setAttribute();

    StateTransitionResponseJsonBuilder setModuleForm();

    Map<String, Object> build();

}
