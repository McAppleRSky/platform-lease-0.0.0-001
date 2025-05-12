package ru.khtu.lease.common.component.model;

import ru.khtu.lease.common.data.model.WorkObjectModel;
import ru.khtu.lease.common.data.enums.WorkObject;

public interface WorkObjectModelCreatorComponent {

    WorkObjectModel create(WorkObject workObject);

}
