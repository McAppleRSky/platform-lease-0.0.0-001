package ru.khtu.lease.common.data.dto.catalog.people.wopeople;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ru.khtu.lease.common.util.dto.SpecIdAble;
import ru.khtu.lease.common.util.dto.StateAble;

@Getter
@RequiredArgsConstructor
public class WoPeopleDto implements SpecIdAble, StateAble {

    private final Long specId;
    private final String woIdTX;
    private final String woNameTX;
    private final String woUserNameTX;
    private final String woPositionNameTX;
    private final String woFirstNameTX;
    private final String woFamilyNameTX;
    private final String woSurnameTX;
    private final String woMenuLI;
    private final String woHomePageLI;
    private final String woOrgNameTX;
    private final String woEmailTX;
    private final String woRecordStateSY;
    private final String woPreviousStateSY;
    private final String woStatusCL;
    private final String woPreviousStatusCL;

}
