package ru.khtu.lease.common.component;

import ru.khtu.lease.common.data.dto.StateMachineSubActionDto;

import java.util.List;

public interface StateMachineSubActionComponent {

    void method(List<StateMachineSubActionDto> stateMachineSubActionDtos);

}
