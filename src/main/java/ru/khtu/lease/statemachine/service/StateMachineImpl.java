package ru.khtu.lease.statemachine.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import ru.khtu.lease.common.repository.StateRepository;
import ru.khtu.lease.common.data.entity.StateEntity;
import ru.khtu.lease.statetransit.data.enums.WorkObject;
import ru.khtu.lease.statetransit.mapper.StateMapperDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StateMachineImpl implements StateMachine {

    private final StateRepository stateRepository;
    private final StateMapperDto stateMapper;

    public void action(Pair<WorkObject, List<Stateble>> record, Action action) {
        List<StateEntity> byWoName = stateRepository.findByWoName(record.getFirst().getString());
    }

}
