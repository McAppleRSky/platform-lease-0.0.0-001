package ru.khtu.lease.statetransit.mapper.helper;

import org.mapstruct.Mapper;
import ru.khtu.lease.statetransit.data.dto.StateTransitionSubactionFullDto;
import ru.khtu.lease.statetransit.data.dto.StateTransitionSubactionMinDto;
import ru.khtu.lease.statetransit.mapper.MapperDto;

@Mapper(componentModel = "spring")
public interface StateTransitionSubactionMapperHelperDto extends MapperDto<StateTransitionSubactionFullDto, StateTransitionSubactionMinDto> {

    @Override
    StateTransitionSubactionMinDto toMinDto(StateTransitionSubactionFullDto helper);

}
