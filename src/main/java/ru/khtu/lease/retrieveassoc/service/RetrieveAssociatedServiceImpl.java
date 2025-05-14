package ru.khtu.lease.retrieveassoc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.khtu.lease.common.data.model.WorkObjectModel;
import ru.khtu.lease.common.util.dto.SpecIdAble;
import ru.khtu.lease.retrieveassoc.componentSh.repository.AssignmentRepository;
import ru.khtu.lease.retrieveassoc.data.entity.AssignmentEntity;
import ru.khtu.lease.retrieveassoc.util.helper.SpecIdAbleHelper;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RetrieveAssociatedServiceImpl implements RetrieveAssociatedService {

    private final AssignmentRepository assignmentRepository;

    @Transactional
    @Override
    public WorkObjectModel retrieveAssociated(WorkObjectModel wo, String association) {
        List<AssignmentEntity> woAssoc = null, woAssocAdded = new ArrayList<>();
        for (SpecIdAble specIdAble : SpecIdAbleHelper.specIdAble(wo.getWorkObjects())) {
            woAssoc = this.assignmentRepository.retrieveAssociated(specIdAble.getSpecId(), association);
            if (woAssoc!= null && !woAssoc.isEmpty()) {
                woAssocAdded.addAll(woAssoc);
            }
        }

        return null;
    }

}
