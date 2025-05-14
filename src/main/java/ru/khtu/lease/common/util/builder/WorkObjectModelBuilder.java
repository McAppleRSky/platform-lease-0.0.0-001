package ru.khtu.lease.common.util.builder;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.NotImplementedException;
import ru.khtu.lease.common.data.enums.WorkObject;
import ru.khtu.lease.common.data.model.WorkObjectModel;

@Getter @Setter
@Accessors(chain = true)
@RequiredArgsConstructor
public class WorkObjectModelBuilder {

    private final WorkObject type;

    public WorkObjectModel build() {
        WorkObjectModel workObjectModelResult = null;
        if (this.type != null) {
            workObjectModelResult = new WorkObjectModel(type);
            workObjectModelResult.putMapperDto();
            return workObjectModelResult;
        } else {
            throw new NotImplementedException("WorkObject type not setted");
        }
    }

}
