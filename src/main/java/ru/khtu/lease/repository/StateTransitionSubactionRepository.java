package ru.khtu.lease.repository;

import org.springframework.data.repository.Repository;
import ru.khtu.lease.data.entity.StateTransitionSubactionEntity;

import java.util.List;

public interface StateTransitionSubactionRepository extends Repository<StateTransitionSubactionEntity, Long> {

    StateTransitionSubactionEntity findById(Long id);

}
