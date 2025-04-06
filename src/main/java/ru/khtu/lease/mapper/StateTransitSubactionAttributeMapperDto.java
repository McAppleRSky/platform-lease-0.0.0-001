package ru.khtu.lease.mapper;

import org.mapstruct.Mapper;
import ru.khtu.lease.data.dto.StateTransitionSubactionAttributeDto;
import ru.khtu.lease.data.entity.StateTransitionSubactionAttributeEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StateTransitSubactionAttributeMapperDto extends MapperDto<StateTransitionSubactionAttributeEntity, StateTransitionSubactionAttributeDto>{

    StateTransitionSubactionAttributeDto toMinDto(StateTransitionSubactionAttributeEntity entity);

    StateTransitionSubactionAttributeEntity toEntity(StateTransitionSubactionAttributeDto dto);

    List<StateTransitionSubactionAttributeDto> toDtos(List<StateTransitionSubactionAttributeEntity> entities);

    List<StateTransitionSubactionAttributeEntity> toEntities(List<StateTransitionSubactionAttributeDto> dtos);

    /*default String dtoToStr(StateTransitionSubactionAttributeDto dto) {
        return dto.getWoState();
    }*/

//    List<String> toStrings(List<StateTransitionSubactionAttributeDto> dtos);


}
