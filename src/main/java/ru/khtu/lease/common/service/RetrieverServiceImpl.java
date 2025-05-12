package ru.khtu.lease.common.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.khtu.lease.common.data.enums.WorkObject;
import ru.khtu.lease.common.repository.WorkObjectRepository;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class RetrieverServiceImpl implements RetrieverService {

    private final WorkObjectRepository retrieverRepository;

    @Transactional
    @Override
    public Object retrieveRecordById(WorkObject workObject, long id) {
        return retrieverRepository.retrieveRecordById(workObject.getEntityClass(), id);
    }

}
