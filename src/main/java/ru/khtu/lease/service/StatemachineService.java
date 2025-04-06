package ru.khtu.lease.service;

import ru.khtu.lease.data.enums.WorkObject;

import java.util.Map;

public interface StatemachineService {

    Map<String, Object> getStateTransition(WorkObject workObject);

}
