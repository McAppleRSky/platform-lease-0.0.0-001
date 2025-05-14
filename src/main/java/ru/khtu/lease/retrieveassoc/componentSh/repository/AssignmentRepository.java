package ru.khtu.lease.retrieveassoc.componentSh.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import ru.khtu.lease.common.data.model.WorkObjectModel;
import ru.khtu.lease.retrieveassoc.data.entity.AssignmentEntity;

import java.util.List;

public interface AssignmentRepository extends Repository<AssignmentEntity, Long> {

    @Query("" +
            "SELECT a FROM AssignmentEntity a " +
            "WHERE a.specId = ?1 AND a.woName = ?2")
    List<AssignmentEntity> retrieveAssociated(long id, String association);

}
