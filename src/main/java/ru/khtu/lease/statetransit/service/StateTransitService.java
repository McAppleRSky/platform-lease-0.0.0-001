package ru.khtu.lease.statetransit.service;

import ru.khtu.lease.common.data.enums.WorkObject;

import java.util.Map;

public interface StateTransitService {

    Map<String, Object> getStateTransition(WorkObject workObject);

}
