package ru.khtu.lease.common.componentService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.khtu.lease.common.componentSh.repository.WorkObjectRepository;
import ru.khtu.lease.common.data.enums.WorkObject;

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
