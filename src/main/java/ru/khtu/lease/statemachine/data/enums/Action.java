package ru.khtu.lease.statemachine.data.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.NotImplementedException;

import java.util.HashMap;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public enum Action {

    CREATE(new String("Create"), new String("Create")),
    OPEN(new String("Open"), new String("Open")),
    ASSOC(new String("Associate"), new String("Associate")),
    DE_ASSOC(new String("DeAssociate"), new String("DeAssociate")),
    WO_CREATE(new String("Create"), new String("woCreate")),
    WO_ACTIVATE(new String("Activate"), new String("woActivate")),
    WO_RETIRE(new String("Retire"), new String("woRetire")),
    WO_DELETE(new String("Delete"), new String("woDelete")),
    ;

    private final String title, string;

    private static final Map<String, Action> map = new HashMap<>();

    static {
        for (Action enumItem : Action.values()) {
            map.put(enumItem.getString(), enumItem);
        }
    }

    public static Action get(String string) {
        for (String stringKey : map.keySet()) {
            if (stringKey.equalsIgnoreCase(string)) {
                return map.get(stringKey);
            }
        }
        throw new NotImplementedException("NotImplementedException for string : " + string);
    }

}
