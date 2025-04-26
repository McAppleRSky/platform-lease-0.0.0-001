package ru.khtu.lease.statetransit.service.json;

import ru.khtu.lease.statetransit.component.StateTransitComponent;
import ru.khtu.lease.statetransit.data.enums.ResponseKey;
import ru.khtu.lease.statetransit.data.enums.WorkObject;
import ru.khtu.lease.common.data.dto.StateDto;
import ru.khtu.lease.statetransit.data.dto.StateTransitionFullDto;
import ru.khtu.lease.statetransit.data.dto.StateTransitionSubactionFullDto;
import ru.khtu.lease.statetransit.mapper.AttributeMapper;
import ru.khtu.lease.statetransit.mapper.InclusionMapper;
import ru.khtu.lease.statetransit.mapper.ModuleFormMapper;
import ru.khtu.lease.statetransit.mapper.StateMapperDto;
import ru.khtu.lease.statetransit.mapper.helper.jackson.StateTransitionJacksonMapperHelperDto;
import ru.khtu.lease.statetransit.mapper.helper.StateTransitionMapperHelperDto;
import ru.khtu.lease.statetransit.mapper.helper.jackson.StateTransitionSubactionJacksonMapperHelperDto;
import ru.khtu.lease.statetransit.mapper.helper.StateTransitionSubactionMapperHelperDto;

import java.util.*;

public class StateTransitionResponseJsonBuilderImpl
        extends StateTransitionResponseJsonBuilderAbstract implements StateTransitionResponseJsonBuilder {

    private final StateTransitComponent stateTransitComponent;
    private final StateMapperDto stateMapper;
    private final List<StateDto> stateData;
    private final List<StateTransitionFullDto> tarnsitionData;
    private Map<StateTransitionFullDto, Map<String, Object>> mapStateTransitionHelperToStringObject;
    private Map<StateTransitionSubactionFullDto, Map<String, Object>> mapStateTransitionSubactionHelperToStringObject;

    public StateTransitionResponseJsonBuilderImpl(WorkObject workObject, StateTransitComponent stateTransitComponent) {
        super(workObject);
        this.stateTransitComponent = stateTransitComponent;
        this.stateMapper = this.stateTransitComponent.getStateMapper();
        Map.Entry<
                List<StateDto>,
                List<StateTransitionFullDto> > data = this.stateTransitComponent.getStateTransition(workObject);
        this.stateData = data.getKey();
        this.tarnsitionData = data.getValue();
    }

    @Override
    public StateTransitionResponseJsonBuilder setState() {
        super.stateTransition.add(
                Collections.singletonMap(ResponseKey.STATES.getString(), this.stateMapper.toStrings(this.stateData) ) );
        return this;
    }

    @Override
    public StateTransitionResponseJsonBuilder setTransition(StateTransitionMapperHelperDto stateTransitionMapperHelperDto) {
        Map.Entry<
                ArrayList<Map<String, Object>>,
                Map<StateTransitionFullDto, Map<String, Object>> > entryMapList
                = new StateTransitionJacksonMapperHelperDto(
                        stateTransitionMapperHelperDto ).mapHelperToStringObject(this.tarnsitionData);
        if (entryMapList != null) {
            super.stateTransition.add(
                    Collections.singletonMap(ResponseKey.TRANSIT.getString(), entryMapList.getKey()) );
            this.mapStateTransitionHelperToStringObject = entryMapList.getValue();
        }
        return this;
    }

    @Override
    public StateTransitionResponseJsonBuilder setSubaction(
            StateTransitionSubactionMapperHelperDto stateTransitionSubactionMapperHelperDto ) {
        this.mapStateTransitionSubactionHelperToStringObject
                = new StateTransitionSubactionJacksonMapperHelperDto(
                        stateTransitionSubactionMapperHelperDto ).mapHelperToStringObject(this.tarnsitionData);
        if (this.mapStateTransitionSubactionHelperToStringObject != null) {
            for (StateTransitionFullDto stateTransitionHelper : this.tarnsitionData) {
                if (stateTransitionHelper.getStateTransitionSubaction() != null
                        && this.mapStateTransitionHelperToStringObject != null) {
                    this.mapStateTransitionHelperToStringObject.get(stateTransitionHelper)
                            .put(
                                    ResponseKey.SUBACTION.getString(),
                                    Collections.singletonList(
                                            this.mapStateTransitionSubactionHelperToStringObject
                                                    .get(stateTransitionHelper.getStateTransitionSubaction())) );
                } else {
                    this.mapStateTransitionHelperToStringObject.get(stateTransitionHelper)
                            .put(ResponseKey.SUBACTION.getString(), new ArrayList<>(0));
                }
            }
        }
        return this;
    }

    @Override
    public StateTransitionResponseJsonBuilder setInclusion(/*StateTransitSubactionInclusionMapperDto stateTransitSubactionInclusionMapperDto*/) {
        for (StateTransitionFullDto stateTransitionHelper : this.tarnsitionData) {
            if ( stateTransitionHelper.getStateTransitionSubaction() != null
                    && stateTransitionHelper.getStateTransitionSubaction().getStateTransitionSubactionInclusionDto() != null
                    && !stateTransitionHelper.getStateTransitionSubaction().getStateTransitionSubactionInclusionDto().isEmpty() ) {
                StateTransitionSubactionFullDto stateTransitionSubaction = stateTransitionHelper.getStateTransitionSubaction();
                Map<String, Object> stringObjectMap = this.mapStateTransitionSubactionHelperToStringObject.get(stateTransitionSubaction);
                stringObjectMap.put(
                        ResponseKey.INCLUSION.getString(),
                        InclusionMapper.mapListToListMap(stateTransitionSubaction.getStateTransitionSubactionInclusionDto()) );
//                throw new NotImplementedException("Inclusion not implemented");
            }
        }
        return this;
    }

    @Override
    public StateTransitionResponseJsonBuilder setAttribute(/*StateTransitSubactionAttributeMapperDto stateTransitSubactionAttributeMapperDto*/) {
        for (StateTransitionFullDto stateTransitionHelper : this.tarnsitionData) {
            if ( stateTransitionHelper.getStateTransitionSubaction() != null
                    && stateTransitionHelper.getStateTransitionSubaction().getStateTransitionSubactionAttributeDto() != null
                    && !stateTransitionHelper.getStateTransitionSubaction().getStateTransitionSubactionAttributeDto().isEmpty() ) {
                StateTransitionSubactionFullDto stateTransitionSubaction = stateTransitionHelper.getStateTransitionSubaction();
                Map<String, Object> stringObjectMap = this.mapStateTransitionSubactionHelperToStringObject.get(stateTransitionSubaction);
                stringObjectMap.put(
                        ResponseKey.ATTRIBUTE.getString(),
                        AttributeMapper.mapListToListMap(stateTransitionSubaction.getStateTransitionSubactionAttributeDto()) );
//                throw new NotImplementedException("Attribute not implemented");
            }
        }
        return this;
    }

    @Override
    public StateTransitionResponseJsonBuilder setModuleForm() {
        for (StateTransitionFullDto stateTransitionHelper : this.tarnsitionData) {
            if ( stateTransitionHelper.getStateTransitionSubaction() != null
                    && stateTransitionHelper.getStateTransitionSubaction().getStateTransitionSubactionModuleFormDto() != null
                    && !stateTransitionHelper.getStateTransitionSubaction().getStateTransitionSubactionModuleFormDto().isEmpty() ) {
                StateTransitionSubactionFullDto stateTransitionSubaction = stateTransitionHelper.getStateTransitionSubaction();
                Map<String, Object> stringObjectMap = this.mapStateTransitionSubactionHelperToStringObject.get(stateTransitionSubaction);
                stringObjectMap.put(
                        ResponseKey.MODULE_FORM.getString(),
                        ModuleFormMapper.mapListToListMap(stateTransitionSubaction.getStateTransitionSubactionModuleFormDto()) );
            }
        }
        return this;
    }

    @Override
    public Map<String, Object> build() {
        return super.mapResult;
    }

}
