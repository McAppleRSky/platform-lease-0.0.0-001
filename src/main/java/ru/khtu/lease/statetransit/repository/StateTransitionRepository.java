package ru.khtu.lease.statetransit.repository;

import org.springframework.data.repository.Repository;
import ru.khtu.lease.statetransit.data.entity.StateTransitionEntity;

import java.util.List;

public interface StateTransitionRepository extends Repository<StateTransitionEntity, Long> {

    List<StateTransitionEntity> findByWoName(String woName);

}
