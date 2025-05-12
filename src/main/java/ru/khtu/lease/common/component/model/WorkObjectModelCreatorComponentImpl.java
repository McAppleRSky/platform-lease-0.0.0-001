package ru.khtu.lease.common.component.model;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Component;
import ru.khtu.lease.common.data.model.WorkObjectModel;
import ru.khtu.lease.common.service.StateMachineService;
import ru.khtu.lease.common.data.enums.WorkObject;

@Component
@RequiredArgsConstructor
public class WorkObjectModelCreatorComponentImpl implements WorkObjectModelCreatorComponent {

    private final StateMachineService stateMachineService;

    @Override
    public WorkObjectModel create(WorkObject workObject) {
        WorkObjectModel result = new WorkObjectModel(workObject)
                .put(this.stateMachineService);
        switch (workObject) {
            case WO_PEOPLE:
                return result;
        }
        throw new NotImplementedException("Not created for WO " + workObject.getString());
    }

}
