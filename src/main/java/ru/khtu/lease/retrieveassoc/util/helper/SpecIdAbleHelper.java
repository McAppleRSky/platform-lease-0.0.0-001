package ru.khtu.lease.retrieveassoc.util.helper;

import org.jetbrains.annotations.NotNull;
import ru.khtu.lease.common.util.dto.SpecIdAble;

import java.util.ArrayList;
import java.util.List;

public class SpecIdAbleHelper {

    public static List<SpecIdAble> specIdAble(@NotNull List wo) {
        ArrayList<SpecIdAble> specIdAblesResult = new ArrayList<>();
        for (Object o : wo) {
            specIdAblesResult.add((SpecIdAble)o);
        }
        return specIdAblesResult;
    }

}
