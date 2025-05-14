package ru.khtu.lease.common.componentSh.repository;

import org.springframework.stereotype.Repository;
import ru.khtu.lease.statemachine.util.entity.EntityCreateAble;
import ru.khtu.lease.statemachine.util.entity.EntityStateAble;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class WorkObjectRepositoryImpl implements WorkObjectRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Object retrieveRecordById(Class<?> entityClass, long id) {
//        Object entityResult = entityManager.getReference(entityClass, id);
//        entityManager.refresh(entityResult/*, LockModeType.PESSIMISTIC_WRITE*/);
        return entityManager.find(entityClass, id);
    }

    @Override
    public EntityCreateAble save(EntityCreateAble entity) {
        EntityCreateAble result = entity;
        if (entity.getSpecId() == null) {
            result = this.entityManager.merge(entity);
        } else {
            entityManager.persist(entity);
        }
        return result;
    }

    @Override
    public EntityStateAble save(EntityStateAble entity) {
        return entityManager.merge(entity);
    }

}
