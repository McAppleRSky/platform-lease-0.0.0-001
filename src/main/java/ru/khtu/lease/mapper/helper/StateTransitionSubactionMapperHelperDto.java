package ru.khtu.lease.mapper.helper;

import org.mapstruct.Mapper;
import ru.khtu.lease.data.dto.StateTransitionSubactionFullDto;
import ru.khtu.lease.data.dto.StateTransitionSubactionMinDto;
import ru.khtu.lease.mapper.MapperDto;

@Mapper(componentModel = "spring")
public interface StateTransitionSubactionMapperHelperDto extends MapperDto<StateTransitionSubactionFullDto, StateTransitionSubactionMinDto> {

    @Override
    StateTransitionSubactionMinDto toMinDto(StateTransitionSubactionFullDto helper);

}
