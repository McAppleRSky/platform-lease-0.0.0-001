package ru.khtu.lease.common.component.catalog.people.wopeople;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.khtu.lease.common.component.RetrieverComponent;
import ru.khtu.lease.common.component.model.WorkObjectModelRetrieverComponent;
import ru.khtu.lease.common.data.enums.WorkObject;
import ru.khtu.lease.common.data.model.WorkObjectModel;
import ru.khtu.lease.common.util.mapstruct.catalog.people.wopeople.WoPeopleMapperDto;

@RequiredArgsConstructor
@Component
public class WoPeopleRetrieverComponentImpl implements RetrieverComponent {

    private final WorkObjectModelRetrieverComponent workObjectModelRetriever;
    private final WoPeopleMapperDto mapperDto;

    @Override
    public WorkObjectModel retrievedModel() {
        return this.workObjectModelRetriever
                .retrieveFor(WorkObject.WO_PEOPLE)
                .put(mapperDto)
                ;
    }

}
