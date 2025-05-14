package ru.khtu.lease.common.util.builder.calalog.people.wopeople;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import ru.khtu.lease.common.data.dto.catalog.people.wopeople.WoPeopleDto;

@Getter @Setter
@Accessors(chain = true)
public class WoPeopleBuilder{

    private Long specId;
    private String woIdTX;
    private String woNameTX;
    private String woUserNameTX;
    private String woPositionNameTX;
    private String woFirstNameTX;
    private String woFamilyNameTX;
    private String woSurnameTX;
    private String woMenuLI;
    private String woHomePageLI;
    private String woOrgNameTX;
    private String woEmailTX;
    private String woRecordStateSY;
    private String woPreviousStateSY;
    private String woStatusCL;
    private String woPreviousStatusCL;

    public WoPeopleDto build() {
        return new WoPeopleDto(
                this.specId,
                this.woIdTX,
                this.woNameTX,
                this.woUserNameTX,
                this.woPositionNameTX,
                this.woFirstNameTX,
                this.woFamilyNameTX,
                this.woSurnameTX,
                this.woMenuLI,
                this.woHomePageLI,
                this.woOrgNameTX,
                this.woEmailTX,
                this.woRecordStateSY,
                this.woPreviousStateSY,
                this.woStatusCL,
                this.woPreviousStatusCL );
    }

}
