package ru.khtu.lease.common.component.catalog.people.wopeople;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.khtu.lease.common.component.CreatorComponent;
import ru.khtu.lease.common.component.model.WorkObjectModelCreatorComponent;
import ru.khtu.lease.common.data.model.WorkObjectModel;
import ru.khtu.lease.common.util.mapper.mapstruct.catalog.people.wopeople.WoPeopleMapperDto;
import ru.khtu.lease.common.data.enums.WorkObject;

@RequiredArgsConstructor
@Component
public class WoPeopleCreatorComponentImpl implements CreatorComponent {

    private final WorkObjectModelCreatorComponent workObjectModelCreatorComponent;
    private final WoPeopleMapperDto mapperDto;

    @Override
    public WorkObjectModel createModel() {
        return this.workObjectModelCreatorComponent
                .create(WorkObject.WO_PEOPLE)
                .put(mapperDto);
    }

}
