package ru.khtu.lease.common.util.mapstruct.catalog.organization.organization;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.khtu.lease.common.data.dto.catalog.organization.organization.OrganizationDto;
import ru.khtu.lease.common.data.entity.catalog.organization.organization.OrganizationEntity;
import ru.khtu.lease.common.util.mapstruct.MapperDto;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrganizationMapperDto extends MapperDto<OrganizationDto, OrganizationEntity> {

    OrganizationDto toDto(OrganizationEntity entity);

    OrganizationEntity toEntity(OrganizationDto dto);

    List<OrganizationDto> toDtos(List<OrganizationEntity> entities);

    List<OrganizationEntity> toEntities(List<OrganizationDto> dtos);

}
