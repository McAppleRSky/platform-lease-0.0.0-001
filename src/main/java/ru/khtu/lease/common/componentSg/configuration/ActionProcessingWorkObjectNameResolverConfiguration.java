package ru.khtu.lease.common.componentSg.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.khtu.lease.common.componentSi.workProcess.catalog.people.wopeople.WoPeopleSynchronousWhenCreate;
import ru.khtu.lease.common.data.enums.WorkObject;
import ru.khtu.lease.common.data.enums.WorkProcess;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Configuration
public class ActionProcessingWorkObjectNameResolverConfiguration {

    @Bean//(name = "WorkObjectToProcessResolver")
    public Map<WorkObject, Map<WorkProcess, Class<?>>> getWorkObjectToProcessResolver() {
        Map<WorkProcess, Class<?>> woPeopleProcessResolver = new HashMap<>();
        Map<WorkObject, Map<WorkProcess, Class<?>>> workObjectToProcessResolverResult = new HashMap<>();
        workObjectToProcessResolverResult.put(WorkObject.WO_PEOPLE, woPeopleProcessResolver);
        woPeopleProcessResolver.put(WorkProcess.get(new String("woPeople - Synchronous - when Create")), WoPeopleSynchronousWhenCreate.class);
        return workObjectToProcessResolverResult;
    }

}
