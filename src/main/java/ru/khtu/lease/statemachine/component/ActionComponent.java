package ru.khtu.lease.statemachine.component;

import com.fasterxml.jackson.core.JsonProcessingException;
import ru.khtu.lease.common.data.model.WorkObjectModel;
import ru.khtu.lease.statemachine.data.dto.action.ActionRequestDto;
import ru.khtu.lease.statemachine.data.enums.Action;
import ru.khtu.lease.statemachine.data.enums.ProcessedStatus;
import ru.khtu.lease.statemachine.data.enums.State;

public interface ActionComponent {

    void actionRequest(WorkObjectModel workObjectModel, Action action, State state) throws JsonProcessingException;

    ProcessedStatus actionProcessing(ActionRequestDto actionRequestDto);

}
