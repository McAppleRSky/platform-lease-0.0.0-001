package ru.khtu.lease.statemachine.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.khtu.lease.common.data.enums.WorkObject;

@Getter @Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class WoIdTempDto {

    private final WorkObject type;
    private Long id;

}
