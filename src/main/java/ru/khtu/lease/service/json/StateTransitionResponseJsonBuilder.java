package ru.khtu.lease.service.json;

import ru.khtu.lease.data.enums.ResponseKey;
import ru.khtu.lease.mapper.StateTransitSubactionAttributeMapperDto;
import ru.khtu.lease.mapper.StateTransitSubactionInclusionMapperDto;
import ru.khtu.lease.mapper.helper.StateTransitionMapperHelperDto;
import ru.khtu.lease.mapper.helper.StateTransitionSubactionMapperHelperDto;

import java.util.List;
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
