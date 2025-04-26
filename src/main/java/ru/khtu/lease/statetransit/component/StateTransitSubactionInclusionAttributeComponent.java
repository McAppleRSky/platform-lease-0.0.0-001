package ru.khtu.lease.statetransit.component;

import ru.khtu.lease.statetransit.data.dto.StateTransitionSubactionFullDto;

public interface StateTransitSubactionInclusionAttributeComponent {

    void getByStateTransitionsSubactionAndPut(StateTransitionSubactionFullDto stateTransitionSubaction);

}
