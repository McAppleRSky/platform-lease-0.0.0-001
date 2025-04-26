package ru.khtu.lease.statetransit.repository;

import org.springframework.data.repository.Repository;
import ru.khtu.lease.statetransit.data.entity.StateTransitionSubactionEntity;

public interface StateTransitionSubactionRepository extends Repository<StateTransitionSubactionEntity, Long> {

    StateTransitionSubactionEntity findById(Long id);

}
