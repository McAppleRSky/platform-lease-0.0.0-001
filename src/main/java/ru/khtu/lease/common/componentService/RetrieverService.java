package ru.khtu.lease.common.componentService;

import ru.khtu.lease.common.data.enums.WorkObject;

public interface RetrieverService {

    Object retrieveRecordById(WorkObject workObject, long id);

}
