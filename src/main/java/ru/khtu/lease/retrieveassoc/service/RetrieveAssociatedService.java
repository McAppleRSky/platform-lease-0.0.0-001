package ru.khtu.lease.retrieveassoc.service;

import ru.khtu.lease.common.data.model.WorkObjectModel;

public interface RetrieveAssociatedService {

    WorkObjectModel retrieveAssociated(WorkObjectModel wo, String association);

}
