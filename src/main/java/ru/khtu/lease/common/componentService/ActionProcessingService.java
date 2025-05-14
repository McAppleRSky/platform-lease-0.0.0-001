package ru.khtu.lease.common.componentService;

import ru.khtu.lease.common.data.enums.WorkObject;

public interface ActionProcessingService {

    void staticExecute(WorkObject type, Long specid, String processName);

}
