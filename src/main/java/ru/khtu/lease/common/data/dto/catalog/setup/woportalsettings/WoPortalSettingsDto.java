package ru.khtu.lease.common.data.dto.catalog.setup.woportalsettings;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Getter
@RequiredArgsConstructor
public class WoPortalSettingsDto {

    private final Long specId;
    private final String woIdTX;
    private final String woNameTX;
    private final String woRecordStateSY;
    private final String woPreviousStateSY;
    private final String woStatusCL;
    private final String woPreviousStatusCL;
    private final String woFormNameSY;

}
