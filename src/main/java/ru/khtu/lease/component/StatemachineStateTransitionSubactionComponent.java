package ru.khtu.lease.component;

import ru.khtu.lease.data.dto.StateTransitionFullDto;

import java.util.List;

public interface StatemachineStateTransitionSubactionComponent {

    void getByStateTransitionsAndPutSubaction(List<StateTransitionFullDto> stateTransitions);

}
