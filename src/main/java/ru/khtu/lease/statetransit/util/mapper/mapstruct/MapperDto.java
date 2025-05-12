package ru.khtu.lease.statetransit.util.mapper.mapstruct;

import java.util.List;

public interface MapperDto<E, D> {

    D toMinDto(E entity);

    E toEntity(D dto);


    List<D> toDtos(List<E> entities);

    List<E> toEntities(List<D> dtos);

}
