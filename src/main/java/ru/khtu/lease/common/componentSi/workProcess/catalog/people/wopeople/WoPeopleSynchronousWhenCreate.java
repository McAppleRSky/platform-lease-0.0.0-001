package ru.khtu.lease.common.componentSi.workProcess.catalog.people.wopeople;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.khtu.lease.common.componentSi.workProcess.WorkProcessExecuteAbleComponent;
import ru.khtu.lease.common.data.model.WorkObjectModel;

@Component("woPeople - Synchronous - when Create")
@Scope("prototype")
public class WoPeopleSynchronousWhenCreate implements WorkProcessExecuteAbleComponent {

    @Override
    public void execute(WorkObjectModel wo) {
        System.out.println();
    }

}
