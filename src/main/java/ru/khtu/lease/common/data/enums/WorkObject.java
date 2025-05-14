package ru.khtu.lease.common.data.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.NotImplementedException;
import ru.khtu.lease.common.data.dto.catalog.classification.classification.ClassificationDto;
import ru.khtu.lease.common.data.dto.catalog.contract.wocontract.WoContractDto;
import ru.khtu.lease.common.data.dto.catalog.intermediate.wocontractlocations.WoContractLocationsDto;
import ru.khtu.lease.common.data.dto.catalog.intermediate.wocontracttenant.WoContractTenantDto;
import ru.khtu.lease.common.data.dto.catalog.organization.organization.OrganizationDto;
import ru.khtu.lease.common.data.dto.catalog.people.wopeople.WoPeopleDto;
import ru.khtu.lease.common.data.dto.catalog.setup.woportalsettings.WoPortalSettingsDto;
import ru.khtu.lease.common.data.dto.catalog.space.wospace.WoSpaceDto;
import ru.khtu.lease.common.data.entity.catalog.classification.classification.ClassificationEntity;
import ru.khtu.lease.common.data.entity.catalog.contract.wocontract.WoContractEntity;
import ru.khtu.lease.common.data.entity.catalog.intermediate.wocontractlocations.WoContractLocationsEntity;
import ru.khtu.lease.common.data.entity.catalog.intermediate.wocontracttenant.WoContractTenantEntity;
import ru.khtu.lease.common.data.entity.catalog.organization.organization.OrganizationEntity;
import ru.khtu.lease.common.data.entity.catalog.people.wopeople.WoPeopleEntity;
import ru.khtu.lease.common.data.entity.catalog.setup.woportalsettings.WoPortalSettingsEntity;
import ru.khtu.lease.common.data.entity.catalog.space.wospace.WoSpaceEntity;
import ru.khtu.lease.common.util.mapstruct.MapperDto;
import ru.khtu.lease.common.util.mapstruct.catalog.contract.wocontract.WoContractMapperDtoImpl;
import ru.khtu.lease.common.util.mapstruct.catalog.intermediate.wocontractlocations.WoContractLocationsMapperDtoImpl;
import ru.khtu.lease.common.util.mapstruct.catalog.intermediate.wocontracttenant.WoContractTenantMapperDtoImpl;
import ru.khtu.lease.common.util.mapstruct.catalog.organization.organization.OrganizationMapperDtoImpl;
import ru.khtu.lease.common.util.mapstruct.catalog.people.wopeople.WoPeopleMapperDtoImpl;
import ru.khtu.lease.common.util.mapstruct.catalog.classification.classification.ClassificationMapperDtoImpl;
import ru.khtu.lease.common.util.mapstruct.catalog.setup.woportalsettings.WoPortalSettingsMapperDtoImpl;
import ru.khtu.lease.common.util.mapstruct.catalog.space.wospace.WoSpaceMapperDtoImpl;
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
            ClassificationEntity.class,
            ClassificationDto.class, new ClassificationMapperDtoImpl()),
    WO_SPACE(
            new String("Space"),
            new String("woSpace"),
            WoSpaceEntity.class,
            WoSpaceDto.class, new WoSpaceMapperDtoImpl()),
    ORGANIZATION(
            new String("Organization"),
            new String("Organization"),
            OrganizationEntity.class,
            OrganizationDto.class, new OrganizationMapperDtoImpl()),
    WO_CONTRACT(
            new String("Contract"),
            new String("woContract"),
            WoContractEntity.class,
            WoContractDto.class, new WoContractMapperDtoImpl()),
    WO_PEOPLE(
            new String("People"),
            new String("woPeople"),
            WoPeopleEntity.class,
            WoPeopleDto.class, new WoPeopleMapperDtoImpl()),
    WO_PORTAL_SETTINGS(
            new String("Portal Settings"),
            new String("WoPortalSettings"),
            WoPortalSettingsEntity.class,
            WoPortalSettingsDto.class, new WoPortalSettingsMapperDtoImpl()),
    WO_CONTRACT_LOCATIONS(
            new String("Contract Locations"),
            new String("woContractLocations"),
            WoContractLocationsEntity.class,
            WoContractLocationsDto.class, new WoContractLocationsMapperDtoImpl()),
    WO_CONTRACT_TENANT(
            new String("Contract Tenant"),
            new String("woContractTenant"),
            WoContractTenantEntity.class,
            WoContractTenantDto.class, new WoContractTenantMapperDtoImpl()) ;

    private final String title, string;
    private final Class<?> entityClass, dtoClass;
    private final MapperDto mapperDto;

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
                Catalog.ORGANIZATION,
                EnumSet.of(
                        WorkObject.ORGANIZATION ) );
        mapCatalogWorkObjectSet.put(
                Catalog.CONTRACT,
                EnumSet.of(
                        WorkObject.WO_CONTRACT ) );
        mapCatalogWorkObjectSet.put(
                Catalog.PEOPLE,
                EnumSet.of(
                        WorkObject.WO_PEOPLE ) );
        mapCatalogWorkObjectSet.put(
                Catalog.SETUP,
                EnumSet.of(
                        WorkObject.WO_PORTAL_SETTINGS ) );
        mapCatalogWorkObjectSet.put(
                Catalog.INTERMEDIATE,
                EnumSet.of(
                        WorkObject.WO_CONTRACT_LOCATIONS,
                        WorkObject.WO_CONTRACT_TENANT ) );
    }

}
