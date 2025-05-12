package ru.khtu.lease.common.data.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter
@RequiredArgsConstructor
public class WoModelDto {

    private final Object dto;
    private Object entity;
    private Boolean selected;

}
