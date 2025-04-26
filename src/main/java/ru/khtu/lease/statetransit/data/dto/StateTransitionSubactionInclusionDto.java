package ru.khtu.lease.statetransit.data.dto;

import lombok.Data;

@Data
public class StateTransitionSubactionInclusionDto {

    private String actionName;

    private Boolean inclusion;

    private Boolean exclusion;

}
