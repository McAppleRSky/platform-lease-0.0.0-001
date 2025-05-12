package ru.khtu.lease.statemachine.data.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ru.khtu.lease.common.data.enums.WorkObject;

@Getter
@RequiredArgsConstructor
public class WorkObjectDto {

    private final WorkObject type;
    private final Long id;

}
