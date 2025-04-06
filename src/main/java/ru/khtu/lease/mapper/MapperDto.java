package ru.khtu.lease.mapper;

import java.util.List;

public interface MapperDto<E, D> {

    D toMinDto(E entity);

    E toEntity(D dto);


    List<D> toDtos(List<E> entities);

    List<E> toEntities(List<D> dtos);

}
