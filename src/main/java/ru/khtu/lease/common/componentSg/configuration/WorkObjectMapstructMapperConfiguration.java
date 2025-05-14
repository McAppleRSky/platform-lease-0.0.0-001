package ru.khtu.lease.common.componentSg.configuration;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.context.annotation.Bean;
import ru.khtu.lease.common.data.enums.WorkObject;
import ru.khtu.lease.common.util.mapstruct.MapperDto;
import ru.khtu.lease.common.util.mapstruct.catalog.people.wopeople.WoPeopleMapperDto;

import java.util.HashMap;
import java.util.Map;

//@RequiredArgsConstructor
//@Configuration
public class WorkObjectMapstructMapperConfiguration {

    private Map<WorkObject, MapperDto> workObjectToMapper;

    @Bean//(name = "WorkObjectToProcessResolver")
    public Map<WorkObject, MapperDto> getWorkObjectToProcessResolver() {
        if (workObjectToMapper != null) {
            return this.workObjectToMapper;
        } else {
            throw new NotImplementedException();
        }
    }

//    @Autowired
    private void setMapstructWoPeopleMapperDto(WoPeopleMapperDto mapperDto) {
        this.setMapstructMapper(WorkObject.WO_PEOPLE, mapperDto);
    }

    private void setMapstructMapper(WorkObject workObjectKey, MapperDto mapperDto) {
        if (this.workObjectToMapper == null) {
            this.workObjectToMapper = new HashMap<>();
        }
        this.workObjectToMapper.put(workObjectKey, mapperDto);
    }

}
