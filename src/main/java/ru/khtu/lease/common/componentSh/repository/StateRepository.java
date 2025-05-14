package ru.khtu.lease.common.componentSh.repository;

import org.springframework.data.repository.Repository;
import ru.khtu.lease.common.data.entity.StateEntity;

import java.util.List;

public interface StateRepository extends Repository<StateEntity, Long> {

    List<StateEntity> findByWoName(String woName);

}