package ru.khtu.lease.mapper.helper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.khtu.lease.data.dto.StateTransitionMinDto;
import ru.khtu.lease.data.dto.StateTransitionFullDto;
import ru.khtu.lease.mapper.MapperDto;

@Mapper(componentModel = "spring")
public interface StateTransitionMapperHelperDto extends MapperDto<StateTransitionFullDto, StateTransitionMinDto> {

    @Override
    @Mapping(target = "nameOfClass", source = "helper.className")
    @Mapping(target = "nameOfMethod", source = "helper.methodName")
    @Mapping(target = "isReadOnly", source = "helper.readOnly")
    StateTransitionMinDto toMinDto(StateTransitionFullDto helper);

}
