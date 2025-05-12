package ru.khtu.lease.common.data.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ru.khtu.lease.statemachine.data.dto.StateTransitionDto;
import ru.khtu.lease.statemachine.data.dto.WorkObjectDto;

@Getter
@RequiredArgsConstructor
public class StateMachineSubActionDto {

    private final WorkObjectDto workObjectDto;
    private final StateTransitionDto StateTransitionDto;

}
