package ru.khtu.lease.data.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class StateTransitionSubactionModuleFormDto {

    private String module;

    private Boolean form;

}
