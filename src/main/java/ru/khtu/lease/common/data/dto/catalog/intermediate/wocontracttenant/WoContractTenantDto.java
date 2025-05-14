package ru.khtu.lease.common.data.dto.catalog.intermediate.wocontracttenant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import java.util.Date;

@Getter
@RequiredArgsConstructor
public class WoContractTenantDto {

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
    private final String woShortNameTX;
    private final String woInnTX;
    private final String woCommentTX;
    private final String woDescriptionTX;

}
