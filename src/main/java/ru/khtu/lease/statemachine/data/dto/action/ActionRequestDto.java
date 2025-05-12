package ru.khtu.lease.statemachine.data.dto.action;

import lombok.Getter;
import ru.khtu.lease.common.data.enums.WorkObject;
import ru.khtu.lease.statemachine.data.enums.Action;
import ru.khtu.lease.statemachine.data.enums.State;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ActionRequestDto {

    private final WorkObject workObject;
    private final Action action;
    private final State state;
    private final long[] ids;

    public ActionRequestDto(String woName, String action, String state, Long[] ids) {
        this.workObject = WorkObject.get(woName);
        this.action = Action.get(action);
        this.state = State.get(state);
        List<Long> filtered = new ArrayList<>();
        for (Long id : ids) {
            if (id != null && id > 0L) {
                filtered.add(id);
            }
        }
        this.ids = new long[filtered.size()];
        for (int i = 0; i < filtered.size(); i++) {
            this.ids[i] = filtered.get(i);
        }
    }

}
