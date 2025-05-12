package ru.khtu.lease.common.repository;

import ru.khtu.lease.statemachine.util.entity.EntityCreateAble;
import ru.khtu.lease.statemachine.util.entity.EntityStateAble;

public interface WorkObjectRepository {

    Object retrieveRecordById(Class<?> entityClass, long id);

    EntityCreateAble save(EntityCreateAble entity);

    EntityStateAble save(EntityStateAble entity);

}
