package ru.khtu.lease.statemachine.data.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.NotImplementedException;

import java.util.HashMap;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public enum State {

    NULL(new String("Null"), new String("null")),
    WO_DRAFT(new String("Draft"), new String("woDraft")),
    WO_ACTIVE(new String("Active"), new String("woActive")),
    WO_RETIRED(new String("Retired"), new String("woRetired")),
    ;

    private final String title, string;

    private static final Map<String, State> map = new HashMap<>();

    static {
        for (State enumItem : State.values()) {
            map.put(enumItem.getString(), enumItem);
        }
    }

    public static State get(String string) {
        for (String stringKey : map.keySet()) {
            if (stringKey.equalsIgnoreCase(string)) {
                return map.get(stringKey);
            }
        }
        throw new NotImplementedException("NotImplementedException for string : " + string);
    }

}
