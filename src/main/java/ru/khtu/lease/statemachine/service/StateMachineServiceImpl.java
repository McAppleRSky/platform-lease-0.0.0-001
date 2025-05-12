package ru.khtu.lease.statemachine.service;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Service;
import ru.khtu.lease.common.component.StateMachineSubActionComponent;
import ru.khtu.lease.common.data.dto.WoModelDto;
import ru.khtu.lease.common.data.enums.WorkObject;
import ru.khtu.lease.common.data.model.WorkObjectModel;
import ru.khtu.lease.common.repository.WorkObjectRepository;
import ru.khtu.lease.common.service.StateMachineService;
import ru.khtu.lease.common.util.dto.SpecIdAble;
import ru.khtu.lease.common.util.dto.StateAble;
import ru.khtu.lease.statemachine.data.dto.StateTransitionDto;
import ru.khtu.lease.statemachine.data.dto.WoIdTempDto;
import ru.khtu.lease.statemachine.data.enums.Action;
import ru.khtu.lease.statemachine.data.enums.ProcessedStatus;
import ru.khtu.lease.statemachine.data.enums.State;
import ru.khtu.lease.statemachine.util.entity.EntityCreateAble;
import ru.khtu.lease.statemachine.util.entity.EntityStateAble;
import ru.khtu.lease.statemachine.util.helper.StateMachineSubActionDtoHelper;
import ru.khtu.lease.statemachine.util.helper.StateTransitionMapperHelper;
import ru.khtu.lease.statemachine.util.mapper.mapstruct.MapperDto;
import ru.khtu.lease.statetransit.data.entity.StateTransitionEntity;
import ru.khtu.lease.statetransit.repository.StateTransitionRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StateMachineServiceImpl implements StateMachineService {

    private final StateTransitionRepository stateTransitionRepository;
    private final WorkObjectRepository workObjectRepository;
    private final StateMachineSubActionComponent stateMachineSubActionComponent;

    @Transactional
    @Override
    public void transit(WorkObjectModel workObjectModel, Action action, State state) {
        List<StateTransitionEntity> currentStateNull = null, transitable = null;
        Map<WoIdTempDto, StateTransitionDto> idTempToAction = new HashMap();
        if (workObjectModel.isTemp() && !workObjectModel.hasSpecId()) {
            currentStateNull = currentStateNullCheck(
                    stateTransitionRepository.findByWoName(workObjectModel.getType().getString()) );
            WoIdTempDto woIdTempDto = new WoIdTempDto(workObjectModel.getType());
            if (!currentStateNull.isEmpty()) {
                transitable = transitable( currentStateNull, action, state, woIdTempDto, idTempToAction );
            }
            if (!transitable.isEmpty() && transitable.size() == 1) {
                EntityCreateAble entityCreateAble = workObjectModel.getEntityCreateAble();
                entityCreateAble.setWoRecordStateSY(State.WO_DRAFT.getString());
                entityCreateAble.setWoPreviousStateSY(State.NULL.getString());
                EntityCreateAble savedSpec = this.workObjectRepository.save(entityCreateAble),
                        saved = null;
                if (savedSpec.getSpecId() != null && savedSpec.getSpecId() > 0) {
                    woIdTempDto.setId(savedSpec.getSpecId());
                    workObjectModel.mapEntityToTemp(savedSpec);
                    savedSpec.setWoIdTX(savedSpec.getSpecId().toString());
                    saved = this.workObjectRepository.save(savedSpec);
                    workObjectModel
                            .mapEntityToTemp(saved)
                            .tempToPermanent()
                            .setTemp(false);
                    this.stateMachineSubActionComponent.method(StateMachineSubActionDtoHelper.mapToDto(idTempToAction));
                    return;
                }
            }
        } else {
            if (workObjectModel.hasSpecIds()) {
                List<StateTransitionEntity> byWoName = this.stateTransitionRepository.findByWoName(
                        workObjectModel.getType().getString() );
                boolean checkSuccess = currentStatesCheck(byWoName, workObjectModel.getWorkObject(),
                        action, state, workObjectModel.get_mapperDto(), workObjectModel.getType(), idTempToAction);
                List<WoModelDto> toDo = new ArrayList();
                for (WoModelDto modelDto : workObjectModel.getWorkObject()) {
                    if (modelDto.getEntity() != null) {
                        EntityStateAble entityStateAble = (EntityStateAble) modelDto.getEntity();
                        entityStateAble.setWoPreviousStateSY(entityStateAble.getWoRecordStateSY());
                        entityStateAble.setWoRecordStateSY(state.getString());
                        modelDto.setEntity(this.workObjectRepository.save(entityStateAble));
                        toDo.add(modelDto);
                    }
                }
                setWorkObjectByEntity(workObjectModel.getWorkObject(), toDo, workObjectModel.get_mapperDto());
                if (checkSuccess) {
                    workObjectModel.setProcessedStatus(ProcessedStatus.SUCCESS);
                }
                this.stateMachineSubActionComponent.method(StateMachineSubActionDtoHelper.mapToDto(idTempToAction));
                return;
            }
        }
        throw new NotImplementedException();
    }

    private void setWorkObjectByEntity(List<WoModelDto> workObject, List<WoModelDto> toDo, MapperDto mapperDto) {
        for (WoModelDto modelDto : toDo) {
            WoModelDto newModelDto = new WoModelDto(mapperDto.toDto(modelDto.getEntity()));
            newModelDto.setSelected(true);
            workObject.set( workObject.indexOf(modelDto), newModelDto);
        }
    }


    private List<StateTransitionEntity> currentStateNullCheck(List<StateTransitionEntity> entityExistsStates) {
        List<StateTransitionEntity> result = new ArrayList<>();
        for (StateTransitionEntity existState : entityExistsStates) {
            if (State.NULL.getString().equalsIgnoreCase(existState.getCurrentState())) {
                result.add(existState);
            }
        }
        return result;
    }

    private boolean currentStatesCheck(List<StateTransitionEntity> entityExistsStates, List<WoModelDto> ModelDtos,
                                       Action action, State state, MapperDto mapperDto,
                                       WorkObject type, Map<WoIdTempDto, StateTransitionDto> idTempToAction) {
        boolean result = true;
        for (WoModelDto modelDto : ModelDtos) {
            List<StateTransitionEntity> transitions = getTransitions(entityExistsStates, modelDto);
            List<StateTransitionEntity> transitable = transitable(transitions, action, state,
                    new WoIdTempDto(type, ((SpecIdAble)modelDto.getDto()).getSpecId()), idTempToAction);
            if (!transitable.isEmpty() && transitable.size() == 1) {
                modelDto.setEntity( mapperDto.toEntity(modelDto.getDto()) );
            } else {
                result = false;
            }
        }
        return result;
    }

    private List<StateTransitionEntity> getTransitions(List<StateTransitionEntity> entityExistsStates, WoModelDto modelDto) {
        List<StateTransitionEntity> result = new ArrayList<>();
        StateAble dtoNeedTransitStateAble = (StateAble)modelDto.getDto();
        for (StateTransitionEntity existState : entityExistsStates) {
            if ( dtoNeedTransitStateAble.getWoRecordStateSY() != null && !dtoNeedTransitStateAble.getWoRecordStateSY().isEmpty()
                 && dtoNeedTransitStateAble.getWoRecordStateSY().equalsIgnoreCase(existState.getCurrentState()) ) {
                result.add(existState);
            }
        }
        return result;
    }

    private List<StateTransitionEntity> transitable(List<StateTransitionEntity> entityExistsStates,
                                                    Action needAction, State needState, WoIdTempDto woIdTempDto,
                                                    Map<WoIdTempDto, StateTransitionDto> idTempToAction) {
        List<StateTransitionEntity> result = new ArrayList<>();
        for (StateTransitionEntity existState : entityExistsStates) {
            if ( needState.getString().equalsIgnoreCase(existState.getNextState())
                 && needAction.getString().equalsIgnoreCase(existState.getActionName())) {
                result.add(existState);
                idTempToAction.put(woIdTempDto, StateTransitionMapperHelper.toDto(existState));
            }
        }
        return result;
    }

}
