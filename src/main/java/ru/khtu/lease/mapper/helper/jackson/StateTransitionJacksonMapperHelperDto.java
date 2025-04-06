package ru.khtu.lease.mapper.helper.jackson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.khtu.lease.data.dto.StateTransitionFullDto;
import ru.khtu.lease.mapper.helper.StateTransitionMapperHelperDto;

import java.util.*;

public class StateTransitionJacksonMapperHelperDto {

    private final ObjectMapper jacksonObjectMapper;
    private final StateTransitionMapperHelperDto stateTransitionMapperHelperDto;

    public StateTransitionJacksonMapperHelperDto(StateTransitionMapperHelperDto stateTransitionMapperHelperDto) {
        this.jacksonObjectMapper = new ObjectMapper();
        this.stateTransitionMapperHelperDto = stateTransitionMapperHelperDto;
    }

    public Map.Entry<
            ArrayList<Map<String, Object>>,
            Map<StateTransitionFullDto, Map<String, Object>>> mapHelperToStringObject(
            List<StateTransitionFullDto> helpers) {
        Map.Entry<
                ArrayList<Map<String, Object>>,
                Map<StateTransitionFullDto, Map<String, Object>>> result = null;
        if (helpers != null && !helpers.isEmpty()) {
            Map<StateTransitionFullDto, Map<String, Object>> resultMap = new LinkedHashMap<>();
            ArrayList<Map<String, Object>> resultList = new ArrayList<>();
            for (StateTransitionFullDto helper : helpers) {
                Map<String, Object> mapStringObject = this.jacksonObjectMapper
                        .convertValue(
                                stateTransitionMapperHelperDto.toMinDto(helper),
                                new TypeReference<Map<String, Object>>() {
                                });
                resultList.add(mapStringObject);
                resultMap.put(helper, mapStringObject);
            }
            result = Collections.singletonMap(resultList, resultMap).entrySet().iterator().next();
        }
        return result;
    }

}
