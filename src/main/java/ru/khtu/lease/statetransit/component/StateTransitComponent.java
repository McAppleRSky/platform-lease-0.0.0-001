package ru.khtu.lease.statetransit.component;

import ru.khtu.lease.common.data.dto.StateDto;
import ru.khtu.lease.common.data.enums.WorkObject;
import ru.khtu.lease.statetransit.data.dto.StateTransitionFullDto;
import ru.khtu.lease.statetransit.mapper.StateMapperDto;

import java.util.List;
import java.util.Map;

public interface StateTransitComponent {

    Map.Entry<List<StateDto>, List<StateTransitionFullDto>> getStateTransition(WorkObject workObject);

    StateMapperDto getStateMapper();

}
