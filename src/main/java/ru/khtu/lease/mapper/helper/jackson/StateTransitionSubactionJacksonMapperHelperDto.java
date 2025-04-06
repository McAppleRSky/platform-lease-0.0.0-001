package ru.khtu.lease.mapper.helper.jackson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.khtu.lease.data.dto.StateTransitionFullDto;
import ru.khtu.lease.data.dto.StateTransitionSubactionFullDto;
import ru.khtu.lease.mapper.helper.StateTransitionSubactionMapperHelperDto;

import java.util.*;

public class StateTransitionSubactionJacksonMapperHelperDto {

    private final ObjectMapper jacksonObjectMapper;
    private final StateTransitionSubactionMapperHelperDto stateTransitionSubactionMapperHelperDto;

    public StateTransitionSubactionJacksonMapperHelperDto(
            StateTransitionSubactionMapperHelperDto stateTransitionSubactionMapperHelperDto ) {
        this.jacksonObjectMapper = new ObjectMapper();
        this.stateTransitionSubactionMapperHelperDto = stateTransitionSubactionMapperHelperDto;
    }

    public Map<StateTransitionSubactionFullDto, Map<String, Object>> mapHelperToStringObject(
                    List<StateTransitionFullDto> helpers ) {
        Map<StateTransitionSubactionFullDto, Map<String, Object>> result = null;
        if (helpers != null && !helpers.isEmpty()) {
            Map<StateTransitionSubactionFullDto, Map<String, Object>> resultMap = new LinkedHashMap<>();
            for (StateTransitionFullDto helper : helpers) {
                if (helper.getStateTransitionSubaction() != null) {
                    Map<String, Object> mapStringObject = this.jacksonObjectMapper.convertValue(
                            stateTransitionSubactionMapperHelperDto.toMinDto(helper.getStateTransitionSubaction()),
                            new TypeReference<Map<String, Object>>() {} );
                    resultMap.put(helper.getStateTransitionSubaction(), mapStringObject);
                }
            }
            result = resultMap;
        }
        return result;
    }

}
