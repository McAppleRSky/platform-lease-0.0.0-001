package ru.khtu.lease.statemachine.component;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Component;
import ru.khtu.lease.common.componentService.StateMachineService;
import ru.khtu.lease.common.data.enums.WorkObject;
import ru.khtu.lease.common.data.model.WorkObjectModel;
import ru.khtu.lease.common.componentService.RetrieverService;

@RequiredArgsConstructor
@Component
public class WorkObjectModelActionComponentImpl implements WorkObjectModelActionComponent {

    private final RetrieverService retrieverService;
    private final StateMachineService stateMachineService;

    @Override
    public WorkObjectModel actionFor(WorkObject workObject) {
        switch (workObject) {
            case WO_PEOPLE:
                return new WorkObjectModel(workObject)
                        .put(this.retrieverService)
                        .put(this.stateMachineService);
        }
        throw new NotImplementedException("Not service for WO " + workObject.getString());
    }
}
