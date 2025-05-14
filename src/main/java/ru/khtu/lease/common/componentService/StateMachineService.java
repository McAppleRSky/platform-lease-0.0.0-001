package ru.khtu.lease.common.componentService;

import ru.khtu.lease.common.data.model.WorkObjectModel;
import ru.khtu.lease.statemachine.data.enums.Action;
import ru.khtu.lease.statemachine.data.enums.State;

public interface StateMachineService {

    void transit(WorkObjectModel workObjectModel, Action action, State state);

}
