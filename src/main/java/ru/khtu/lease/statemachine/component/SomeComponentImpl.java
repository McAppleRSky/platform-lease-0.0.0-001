package ru.khtu.lease.statemachine.component;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.khtu.lease.common.component.CreatorComponent;
import ru.khtu.lease.common.component.RetrieverComponent;
import ru.khtu.lease.common.data.model.WorkObjectModel;
import ru.khtu.lease.common.util.builder.calalog.people.wopeople.WoPeopleBuilder;
import ru.khtu.lease.statemachine.data.dto.action.ActionRequestDto;
import ru.khtu.lease.statemachine.data.enums.Action;
import ru.khtu.lease.statemachine.data.enums.ProcessedStatus;
import ru.khtu.lease.statemachine.data.enums.State;

@Component
@RequiredArgsConstructor
public class SomeComponentImpl implements SomeComponent {

    private final CreatorComponent woPeopleCreatorComponent;
    //    private final WorkObjectCreatorComponent woCreator;
    private final RetrieverComponent woPeopleRetrieverComponent;
    private final ActionComponent woPeopleActionComponent;

    @Override
    public void createPeople() {
//        this.woCreator.create(WorkObject.W_PEOPLE)
        this.woPeopleCreatorComponent.createModel()
                .temp()
                .modify(
                        new WoPeopleBuilder()
                                .setWoIdTX("")
                                .setWoNameTX("leaseUser")
                                .setWoUserNameTX("leaseUser")
                                .setWoHomePageLI("wo-lease - portal")
                                .setWoRecordStateSY(State.NULL.getString())
                                .setWoPreviousStateSY(State.NULL.getString())
                                .build())
                .transit(Action.WO_CREATE, State.WO_DRAFT);
    }

    @Override
    public void activatePeopleRequest(Long id) throws JsonProcessingException {
        WorkObjectModel workObjectModel = this.woPeopleRetrieverComponent.retrievedModel()
                .retrieveRecordById(id);
        this.woPeopleActionComponent.actionRequest(workObjectModel, Action.WO_ACTIVATE, State.WO_ACTIVE);
    }

    @Override
    public ProcessedStatus activatePeopleProcessing(ActionRequestDto actionRequestDto) {
        return this.woPeopleActionComponent.actionProcessing(actionRequestDto);
    }

}
