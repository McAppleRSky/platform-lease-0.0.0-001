package ru.khtu.lease.common.data.dto.catalog.organization.organization;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class OrganizationDto {

    private final Long specId;
    private final String woIdTX;
    private final String woNameTX;
    private final String woRecordStateSY;
    private final String woPreviousStateSY;
    private final String woStatusCL;
    private final String woPreviousStatusCL;
    private final String woFormNameSY;
    private final String woFullNameTX;
    private final String woShortNameTX;
    private final String woInnTX;
    private final String woOkpoTX;
    private final String woOgrnTX;
    private final String woKppTX;
    private final String woCommentTX;
    private final String woDescriptionTX;

}
