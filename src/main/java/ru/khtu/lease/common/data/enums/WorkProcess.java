package ru.khtu.lease.common.data.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.NotImplementedException;

import java.util.HashMap;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public enum WorkProcess {

    WO_PEOPLE_SYNCHRONOUS_WHEN_CREATE(
            new String("woPeople - Synchronous - when Create") );

    private final String string;

    private static final Map<String, WorkProcess> mapStrNameWorkProcess = new HashMap<>();

    static {
        for (WorkProcess enumItem : WorkProcess.values()) {
            mapStrNameWorkProcess.put(enumItem.getString(), enumItem);
        }
    }

    public static WorkProcess get(String string) {
        for (String stringKey : mapStrNameWorkProcess.keySet()) {
            if (stringKey.equalsIgnoreCase(string)) {
                return mapStrNameWorkProcess.get(stringKey);
            }
        }
        throw new NotImplementedException("NotImplementedException for string : " + string);
    }

}
