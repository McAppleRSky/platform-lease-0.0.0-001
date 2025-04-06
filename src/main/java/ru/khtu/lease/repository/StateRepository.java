package ru.khtu.lease.repository;

import org.springframework.data.repository.Repository;
import ru.khtu.lease.data.entity.StateEntity;

import java.util.List;

public interface StateRepository extends Repository<StateEntity, Long> {

    List<StateEntity> findByWoName(String woName);

}
