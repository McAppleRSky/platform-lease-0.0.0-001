package ru.khtu.lease.statemachine.component.catalog.people.wopeople;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.khtu.lease.common.co.controller.RestConstant;
import ru.khtu.lease.common.data.enums.WorkObject;
import ru.khtu.lease.common.data.model.WorkObjectModel;
import ru.khtu.lease.common.util.dto.SpecIdAble;
import ru.khtu.lease.common.util.mapstruct.catalog.people.wopeople.WoPeopleMapperDto;
import ru.khtu.lease.statemachine.component.ActionComponent;
import ru.khtu.lease.statemachine.component.WorkObjectModelActionComponent;
import ru.khtu.lease.statemachine.data.dto.action.ActionRequestDto;
import ru.khtu.lease.statemachine.data.enums.Action;
import ru.khtu.lease.statemachine.data.enums.ProcessedStatus;
import ru.khtu.lease.statemachine.data.enums.State;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Component
public class WoPeopleActionComponentImpl implements ActionComponent, RestConstant {

    private final RestTemplateBuilder restTemplateBuilder;
    private final ObjectMapper objectMapper;
    private final WorkObjectModelActionComponent WorkObjectModelActionComponent;
    private final WoPeopleMapperDto mapperDto;

    @Override
    public void actionRequest(WorkObjectModel workObjectModel, Action action, State state) throws JsonProcessingException {
        final RestTemplate restTemplate = this.restTemplateBuilder.build();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map map = new LinkedHashMap<>();
        map.put(KEY_WO_NAME, workObjectModel.getType().getString());
        map.put(KEY_ACTION, action.getString());
        map.put(KEY_STATE, state.getString());
        map.put(KEY_ID, idToList(workObjectModel));
        String body = this.objectMapper.writeValueAsString(map);
        HttpEntity<String> requestEntity = new HttpEntity(body, headers);
        final String PROT = new String("http://"),
                HOST = new String("localhost"),
                PORT = new String("8080"),
                PATH = new String("/api/0.0.1/open/action"),
                URL_TEMPL = new String("%s%s:%s%s"),
                URL = String.format(URL_TEMPL, PROT, HOST, PORT, PATH);
        ResponseEntity<String> responseEntity = restTemplate.
                exchange(URL, HttpMethod.POST, requestEntity, String.class);
        if (responseEntity.getStatusCode().equals(HttpStatus.OK)) {
            workObjectModel.setProcessedStatus(ProcessedStatus.SUCCESS);
        }
    }

    private List idToList(WorkObjectModel workObjectModel) {
        List result = new ArrayList();
        for (Object dto : workObjectModel.getTargetWorkObjectDto() /*.getWorkObjectSpecable()*/) {
            SpecIdAble specIdAble = (SpecIdAble)dto;
            if (specIdAble.getSpecId() != null && specIdAble.getSpecId() > 0L) {
                result.add(specIdAble.getSpecId());
            }
        }
        if (result.isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    @Override
    public ProcessedStatus actionProcessing(ActionRequestDto actionRequestDto) {
        return this.WorkObjectModelActionComponent
                .actionFor(WorkObject.WO_PEOPLE)
                .put(this.mapperDto)
                .retrieveRecordByIds(actionRequestDto.getIds())
                .transit(actionRequestDto.getAction(), actionRequestDto.getState())
                .getProcessedStatus();
    }

}
