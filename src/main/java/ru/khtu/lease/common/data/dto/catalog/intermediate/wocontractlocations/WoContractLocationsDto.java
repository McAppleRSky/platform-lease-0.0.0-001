package ru.khtu.lease.common.data.dto.catalog.intermediate.wocontractlocations;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Getter
@RequiredArgsConstructor
public class WoContractLocationsDto {

    private final Long specId;
    private final String woIdTX;
    private final String woNameTX;
    private final String woRecordStateSY;
    private final String woPreviousStateSY;
    private final String woStatusCL;
    private final String woPreviousStatusCL;
    private final String woFormNameSY;
    private final Date woBeginDA;
    private final Date woEndDA;
    private final String woAddressTX;
    private final String woCommentTX;
    private final String woDescriptionTX;

}
