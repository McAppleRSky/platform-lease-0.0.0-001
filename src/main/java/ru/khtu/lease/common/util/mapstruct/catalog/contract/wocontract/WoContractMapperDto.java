package ru.khtu.lease.common.util.mapstruct.catalog.contract.wocontract;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.khtu.lease.common.data.dto.catalog.contract.wocontract.WoContractDto;
import ru.khtu.lease.common.data.entity.catalog.contract.wocontract.WoContractEntity;
import ru.khtu.lease.common.util.mapstruct.MapperDto;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface WoContractMapperDto extends MapperDto<WoContractDto, WoContractEntity> {

    WoContractDto toDto(WoContractEntity entity);

    WoContractEntity toEntity(WoContractDto dto);

    List<WoContractDto> toDtos(List<WoContractEntity> entities);

    List<WoContractEntity> toEntities(List<WoContractDto> dtos);

}
