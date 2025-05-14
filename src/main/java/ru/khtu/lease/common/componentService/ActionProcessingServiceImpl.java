package ru.khtu.lease.common.componentService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.stereotype.Service;
import ru.khtu.lease.common.componentSi.workProcess.WorkProcessExecuteAbleComponent;
import ru.khtu.lease.common.data.enums.WorkObject;
import ru.khtu.lease.common.data.enums.WorkProcess;
import ru.khtu.lease.common.data.model.WorkObjectModel;
import ru.khtu.lease.common.util.builder.WorkObjectModelBuilder;
import ru.khtu.lease.statemachine.data.exception.ActionNotCompleteException;

import java.util.Map;

@RequiredArgsConstructor
@Service
public class ActionProcessingServiceImpl implements ActionProcessingService {

    private final BeanFactory benFactory;
    private final RetrieverService retrieverService;

    //    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private Map<WorkObject, Map<WorkProcess, Class<?>>> getWorkObjectToProcessResolver() {
        final String getWorkObjectToProcessResolver = new String("getWorkObjectToProcessResolver");
        if (!this.benFactory.containsBean(getWorkObjectToProcessResolver)) {
            throw new IllegalArgumentException(new String("Problem ") + getWorkObjectToProcessResolver);
        }
        return  (Map<WorkObject, Map<WorkProcess, Class<?>>>) this.benFactory.getBean(getWorkObjectToProcessResolver);
    }

    @Override
    public void staticExecute(WorkObject type, Long specid, String processName) {
        Map<WorkObject, Map<WorkProcess, Class<?>>> workObjectToProcessResolver = getWorkObjectToProcessResolver();
        Map<WorkProcess, Class<?>> workProcessClassMap = workObjectToProcessResolver.get(type);
        Class<?> aClass = workProcessClassMap.get(WorkProcess.get(processName));
        WorkProcessExecuteAbleComponent woExecuteAble = (WorkProcessExecuteAbleComponent) benFactory.getBean(aClass);
        if (woExecuteAble == null) {
            throw new ActionNotCompleteException(new String("Problem ") + processName);
        }
//        WorkObjectModel workObjectModel = ;
          woExecuteAble.execute(
                  new WorkObjectModelBuilder(type).build()
                          .putMapperDto()
                          .put(retrieverService)
                          .retrieveRecordById(specid) );
        System.out.println();
    }


}
