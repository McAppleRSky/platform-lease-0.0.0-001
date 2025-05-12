package ru.khtu.lease.statemachine.component;

import ru.khtu.lease.common.data.enums.WorkObject;
import ru.khtu.lease.common.data.model.WorkObjectModel;

public interface WorkObjectModelActionComponent {

    WorkObjectModel actionFor(WorkObject workObject);

}
