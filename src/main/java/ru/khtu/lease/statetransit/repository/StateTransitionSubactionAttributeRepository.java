package ru.khtu.lease.statetransit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.khtu.lease.statetransit.data.entity.StateTransitionSubactionAttributeEntity;

import java.util.List;

public interface StateTransitionSubactionAttributeRepository extends JpaRepository<StateTransitionSubactionAttributeEntity, Long> {

    @Query("SELECT a FROM StateTransitionSubactionAttributeEntity a " +
            "WHERE a.idStateTransition = ?1 AND a.idStateTransitionSubaction = ?2")
    List<StateTransitionSubactionAttributeEntity> findByStateTransitionIdAndStateTransitionSubactionId(Long stateTransitionId, Long stateTransitionSubactionId);

}
