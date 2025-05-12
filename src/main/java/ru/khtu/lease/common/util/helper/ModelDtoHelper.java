package ru.khtu.lease.common.util.helper;

import lombok.NonNull;
import ru.khtu.lease.common.data.dto.WoModelDto;

import java.util.ArrayList;
import java.util.List;

public class ModelDtoHelper {

    public static List<WoModelDto> dtosToModels(@NonNull List dtos) {
        List<WoModelDto> result = new ArrayList<>();
        for (Object dto : dtos) {
            result.add(new WoModelDto(dto));
        }
        return result;
    }

}
