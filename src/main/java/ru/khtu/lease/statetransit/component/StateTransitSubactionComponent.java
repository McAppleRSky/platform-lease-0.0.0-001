package ru.khtu.lease.statetransit.component;

import ru.khtu.lease.statetransit.data.dto.StateTransitionFullDto;

import java.util.List;

public interface StateTransitSubactionComponent {

    void getByStateTransitionsAndPutSubaction(List<StateTransitionFullDto> stateTransitions);

}
