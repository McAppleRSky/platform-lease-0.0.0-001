package ru.khtu.lease.common.component.model;

import ru.khtu.lease.common.data.enums.WorkObject;
import ru.khtu.lease.common.data.model.WorkObjectModel;

public interface WorkObjectModelCreatorComponent {

    WorkObjectModel create(WorkObject workObject);

}
