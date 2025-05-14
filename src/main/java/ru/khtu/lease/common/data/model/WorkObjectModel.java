package ru.khtu.lease.common.data.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.NotImplementedException;
import ru.khtu.lease.common.componentService.StateMachineService;
import ru.khtu.lease.common.data.dto.WoModelDto;
import ru.khtu.lease.common.componentService.RetrieverService;
import ru.khtu.lease.common.data.enums.WorkObject;
import ru.khtu.lease.common.util.dto.SpecIdAble;
import ru.khtu.lease.common.util.helper.ModelDtoHelper;
import ru.khtu.lease.common.util.mapper.mapstruct.MapperDto;
import ru.khtu.lease.common.util.mapstruct.catalog.people.wopeople.WoPeopleMapperDto;
import ru.khtu.lease.statemachine.data.enums.Action;
import ru.khtu.lease.statemachine.data.enums.ProcessedStatus;
import ru.khtu.lease.statemachine.data.enums.State;
import ru.khtu.lease.statemachine.util.entity.EntityCreateAble;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter @Setter
@RequiredArgsConstructor
public class WorkObjectModel {

    private final WorkObject type;
    private boolean temp;
    private boolean inMemOnly;
    private Object workObjectTemp;
    private List<WoModelDto> workObject;
    private StateMachineService _stateMachineService;
    private RetrieverService _retrieverService;
    private MapperDto _mapperDto;
    private ProcessedStatus processedStatus;

    public WorkObjectModel put(StateMachineService stateMachineService) {
        this._stateMachineService = stateMachineService;
        return this;
    }

    public WorkObjectModel put(RetrieverService retrieverService) {
        this._retrieverService = retrieverService;
        return this;
    }

    public WorkObjectModel put(WoPeopleMapperDto mapperDto) {
        this._mapperDto = mapperDto;
        return this;
    }

    public WorkObjectModel putMapperDto() {
        if (this.type == null) {
            throw new NotImplementedException("WorkObject type is null");
        } else {
            this._mapperDto = this.type.getMapperDto();
        }
        return this;
    }

    public WorkObjectModel temp() {
        this.temp = true;
        return this;
    }

    public WorkObjectModel modify(Object dto) {
        if (temp) {
            workObjectTemp = dto;
        }
        return this;
    }

    public WorkObjectModel transit(Action action, State state) {
        this._stateMachineService.transit(this, action, state);
        return this;
    }

    public boolean hasSpecId() {
        SpecIdAble specIdAble = (SpecIdAble)this.workObjectTemp;
        return this.temp && specIdAble.getSpecId() != null && specIdAble.getSpecId() > 0L;
    }

    public boolean hasSpecIds() {
        List<SpecIdAble> SpecIdAbles = new ArrayList();
        if (!this.temp && this.workObject != null && !this.workObject.isEmpty()) {
            for (WoModelDto modelDto : this.workObject) {
                SpecIdAble specIdAble = (SpecIdAble)modelDto.getDto();
                if (specIdAble.getSpecId() != null && specIdAble.getSpecId() > 0L) {
                    SpecIdAbles.add(specIdAble);
                }
            }
        }
        return !SpecIdAbles.isEmpty();
    }

    public List getWorkObjects() {
        if (this.temp) {
            return Collections.singletonList(this.workObjectTemp);
        } else {
            return this.workObject;
        }
    }

    public List getTargetWorkObjectDto() {
        if (temp) {
            return Collections.singletonList(/*(SpecIdAble)*/this.workObjectTemp);
        } else {
            List result = new ArrayList();
            for (WoModelDto modelDto : this.workObject) {
                result.add(modelDto.getDto());
            }
            return result;
        }
    }

    public Object getEntity() {
        if (temp) {
            return this._mapperDto.toEntity(this.workObjectTemp);
        } else {
            throw new NotImplementedException(new String("Not impl"));
        }
    }

    public EntityCreateAble getEntityCreateAble() {
        if (this.temp) {
            return (EntityCreateAble) this._mapperDto.toEntity(this.workObjectTemp);
        } else {
            throw new NotImplementedException();
        }
    }

    public WorkObjectModel mapEntityToTemp(EntityCreateAble entity) {
        this.workObjectTemp = this._mapperDto.toDto(entity);
        return this;
    }

    public WorkObjectModel tempToPermanent() {
        this.workObject = Collections.singletonList(new WoModelDto(this.workObjectTemp));
        return this;
    }

    public WorkObjectModel retrieveRecordById(@NonNull Long id) {
        this.workObject = Collections.singletonList(
                new WoModelDto(
                        this._mapperDto.toDto(this._retrieverService.retrieveRecordById(this.type, id)) ) );
        return this;
    }

    public WorkObjectModel retrieveRecordByIds(long[] ids) {
        List entities = new ArrayList();
        for (long id : ids) {
            entities.add(this._retrieverService.retrieveRecordById(this.type, id));
        }
        this.workObject = ModelDtoHelper.dtosToModels(this._mapperDto.toDtos(entities));
        return this;
    }
}
