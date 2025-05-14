package ru.khtu.lease.common.util.mapstruct.catalog.people.wopeople;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.khtu.lease.common.data.dto.catalog.people.wopeople.WoPeopleDto;
import ru.khtu.lease.common.data.entity.catalog.people.wopeople.WoPeopleEntity;
import ru.khtu.lease.common.util.mapper.mapstruct.MapperDto;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface WoPeopleMapperDto extends MapperDto<WoPeopleDto, WoPeopleEntity> {

    /*@Mapping(source = "specId", target = "specId")
    @Mapping(source = "woIdTX", target = "woIdTX")
    @Mapping(source = "WNameTX", target = "wNameTX")
    @Mapping(source = "WUserNameTX", target = "wUserNameTX")
    @Mapping(source = "WPositionNameTX", target = "wPositionNameTX")
    @Mapping(source = "WFirstNameTX", target = "wFirstNameTX")
    @Mapping(source = "WFamilyNameTX", target = "wFamilyNameTX")
    @Mapping(source = "WSurnameTX", target = "wSurnameTX")
    @Mapping(source = "WMenuLI", target = "wMenuLI")
    @Mapping(source = "WHomePageLI", target = "wHomePageLI")
    @Mapping(source = "WOrgNameTX", target = "wOrgNameTX")
    @Mapping(source = "WEmailTX", target = "wEmailTX")
    @Mapping(source = "WRecordStateSY", target = "wRecordStateSY")
    @Mapping(source = "WPreviousStateSY", target = "wPreviousStateSY")
    @Mapping(source = "WStatusCL", target = "wStatusCL")
    @Mapping(source = "WPreviousStatusCL", target = "wPreviousStatusCL")*/
    WoPeopleDto toDto(WoPeopleEntity entity);

    WoPeopleEntity toEntity(WoPeopleDto dto);

    List<WoPeopleDto> toDtos(List<WoPeopleEntity> entities);

    List<WoPeopleEntity> toEntities(List<WoPeopleDto> dtos);

}
