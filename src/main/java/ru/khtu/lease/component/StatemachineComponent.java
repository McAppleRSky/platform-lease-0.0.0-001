package ru.khtu.lease.component;

import ru.khtu.lease.data.dto.StateDto;
import ru.khtu.lease.data.enums.WorkObject;
import ru.khtu.lease.data.dto.StateTransitionFullDto;
import ru.khtu.lease.mapper.StateMapperDto;

import java.util.List;
import java.util.Map;

public interface StatemachineComponent {

    Map.Entry<List<StateDto>, List<StateTransitionFullDto>> getStateTransition(WorkObject workObject);

    StateMapperDto getStateMapper();

}
