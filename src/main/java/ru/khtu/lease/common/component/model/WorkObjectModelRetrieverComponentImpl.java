package ru.khtu.lease.common.component.model;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Service;
import ru.khtu.lease.common.data.model.WorkObjectModel;
import ru.khtu.lease.common.service.RetrieverService;
import ru.khtu.lease.common.data.enums.WorkObject;

@RequiredArgsConstructor
@Service
public class WorkObjectModelRetrieverComponentImpl implements WorkObjectModelRetrieverComponent {

    private final RetrieverService retrieverService;

    @Override
    public WorkObjectModel retrieveFor(WorkObject workObject) {
        switch (workObject) {
            case WO_PEOPLE:
//                WorkObjectModel result = ;
                return new WorkObjectModel(workObject)
                        .put(this.retrieverService);
        }
        throw new NotImplementedException("Not retrieved for WO " + workObject.getString());
    }

}
