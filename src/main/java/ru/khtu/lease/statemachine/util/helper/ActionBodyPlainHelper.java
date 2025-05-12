package ru.khtu.lease.statemachine.util.helper;

import ru.khtu.lease.statemachine.data.dto.action.ActionRequestDto;
import ru.khtu.lease.statemachine.data.plain.response.ActionBodyPlain;

public class ActionBodyPlainHelper {

    public static ActionRequestDto toDto(ActionBodyPlain actionBodyPlain) {
        return new ActionRequestDto(actionBodyPlain.getWoName(), actionBodyPlain.getAction(), actionBodyPlain.getState(), actionBodyPlain.getId());
    }

}
