package ru.khtu.lease.statemachine.util.helper;

import ru.khtu.lease.common.data.dto.StateMachineSubActionDto;
import ru.khtu.lease.statemachine.data.dto.StateTransitionDto;
import ru.khtu.lease.statemachine.data.dto.WoIdTempDto;
import ru.khtu.lease.statemachine.data.dto.WorkObjectDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StateMachineSubActionDtoHelper {

    public static StateMachineSubActionDto toDto(Map.Entry<WoIdTempDto, StateTransitionDto> idTempToActionEntry) {
        return new StateMachineSubActionDto(
                new WorkObjectDto(idTempToActionEntry.getKey().getType(), idTempToActionEntry.getKey().getId()),
                idTempToActionEntry.getValue() );
    }

    public static List<StateMachineSubActionDto> mapToDto(Map<WoIdTempDto, StateTransitionDto> idTempToAction) {
        List<StateMachineSubActionDto> result = new ArrayList<>();
        for (Map.Entry<WoIdTempDto, StateTransitionDto> idTempToActionEntry : idTempToAction.entrySet()) {
            result.add(toDto(idTempToActionEntry));
        }
        return result;
    }

}
