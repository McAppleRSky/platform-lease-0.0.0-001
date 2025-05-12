package ru.khtu.lease.statemachine.component;

import com.fasterxml.jackson.core.JsonProcessingException;
import ru.khtu.lease.statemachine.data.dto.action.ActionRequestDto;
import ru.khtu.lease.statemachine.data.enums.ProcessedStatus;

public interface SomeComponent {

    void createPeople();

    void activatePeopleRequest(Long id) throws JsonProcessingException;

    ProcessedStatus activatePeopleProcessing(ActionRequestDto actionRequestDto);

}
