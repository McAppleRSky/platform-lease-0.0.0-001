package ru.khtu.lease.component;

import ru.khtu.lease.data.dto.StateTransitionSubactionFullDto;

public interface StatemachineStateTransitionSubactionInclusionAttributeComponent {

    void getByStateTransitionsSubactionAndPut(StateTransitionSubactionFullDto stateTransitionSubaction);

}
