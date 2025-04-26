package ru.khtu.lease.statemachine.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.NotImplementedException;
import ru.khtu.lease.statetransit.data.enums.WorkObject;

import java.util.HashMap;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public enum Action {

    CREATE(
            new String("wCreate"),
            new String("Создать")
    )
    ,DELETE(
            new String("wDelete"),
            new String("Удалить")
    )
    ;

    private final String title, string;

    private static final Map<String, WorkObject> map = new HashMap<>();

    static {
        for (WorkObject enumItem : WorkObject.values()) {
            map.put(enumItem.getString(), enumItem);
        }
    }

    public static WorkObject get(String string) {
        for (String stringKey : map.keySet()) {
            if (stringKey.equals(string)) {
                return map.get(stringKey);
            }
        }
        throw new NotImplementedException("NotImplementedException for string : " + string);
    }

}
