package ru.khtu.lease.common.data.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.NotImplementedException;
import ru.khtu.lease.common.data.dto.catalog.classification.woclassification.WoClassificationDto;
import ru.khtu.lease.common.data.dto.catalog.people.wopeople.WoPeopleDto;
import ru.khtu.lease.common.data.dto.catalog.space.wospace.WoSpaceDto;
import ru.khtu.lease.common.data.entity.catalog.classification.woclassification.WoClassificationEntity;
import ru.khtu.lease.common.data.entity.catalog.people.wopeople.WoPeopleEntity;
import ru.khtu.lease.common.data.entity.catalog.space.wospace.WoSpaceEntity;
import ru.khtu.lease.common.util.mapper.mapstruct.MapperDto;
import ru.khtu.lease.common.util.mapstruct.catalog.people.wopeople.WoPeopleMapperDtoImpl;
import ru.khtu.lease.statetransit.data.enums.Catalog;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public enum WorkObject {

    CLASSIFICATION(
            new String("Classification"),
            new String("Classification"),
            WoClassificationEntity.class,
            WoClassificationDto.class, null),
    WO_SPACE(
            new String("Space"),
            new String("woSpace"),
            WoSpaceEntity.class,
            WoSpaceDto.class, null),
    WO_PEOPLE(
            new String("People"),
            new String("woPeople"),
            WoPeopleEntity.class,
            WoPeopleDto.class, new WoPeopleMapperDtoImpl()) ;

    private final String title, string;
    private final Class<?> entityClass, dtoClass;
    private final MapperDto mapperDto;

/*
    public MapperDto getMapper() {
        return this.mapperDto;
    }
*/

//    private static BeanFactory beanFactory;

    /*public MapperDto getMapper() {
        WoPeopleMapperDtoImpl bean;
        if (beanFactory == null) {
            throw new IllegalStateException("beanFactory == null");
        }
        switch (this) {
            case WO_PEOPLE:
//                BeanFactory beanFactory1 = beanFactory;
                bean = beanFactory.getBean(WoPeopleMapperDtoImpl.class);
                System.out.println();
        }
        throw new NotImplementedException();
    }*/

    private static final Map<String, WorkObject> mapStrNameWorkObject = new HashMap<>();

    static {
        for (WorkObject enumItem : WorkObject.values()) {
            mapStrNameWorkObject.put(enumItem.getString(), enumItem);
        }
    }
    public static WorkObject get(String string) {
        for (String stringKey : mapStrNameWorkObject.keySet()) {
            if (stringKey.equalsIgnoreCase(string)) {
                return mapStrNameWorkObject.get(stringKey);
            }
        }
        throw new NotImplementedException("NotImplementedException for string : " + string);
    }

    public static final Map<Catalog, EnumSet<WorkObject>> mapCatalogWorkObjectSet = new LinkedHashMap<>();

    private static final Map<String, WorkObject> mapStringWorkObject = new LinkedHashMap<>();

    static {
        for (WorkObject enumItem : WorkObject.values()) {
            mapStringWorkObject.put(enumItem.getString(), enumItem);
        }
        mapCatalogWorkObjectSet.put(
                Catalog.CLASSIFICATION,
                EnumSet.of(
                        WorkObject.CLASSIFICATION ) );
        mapCatalogWorkObjectSet.put(
                Catalog.LOCATION,
                EnumSet.of(
                        WorkObject.WO_SPACE ) );
        mapCatalogWorkObjectSet.put(
                Catalog.PEOPLE,
                EnumSet.of(
                        WorkObject.WO_PEOPLE ) );
    }
}
