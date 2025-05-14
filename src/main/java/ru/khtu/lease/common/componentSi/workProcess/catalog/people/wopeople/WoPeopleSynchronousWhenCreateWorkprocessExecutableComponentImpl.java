package ru.khtu.lease.common.componentSi.workProcess.catalog.people.wopeople;

import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;
import ru.khtu.lease.common.componentSi.workProcess.WorkprocessExecutableComponent;
import ru.khtu.lease.common.data.dto.catalog.people.wopeople.WoPeopleDto;
import ru.khtu.lease.common.data.model.WorkObjectModel;
import ru.khtu.lease.userprofile.componentService.UserProfileService;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Component("woPeople - Synchronous - when Create")
//@Scope("prototype")
public class WoPeopleSynchronousWhenCreateWorkprocessExecutableComponentImpl implements WorkprocessExecutableComponent {

//    private final RetrieveAssociatedService retrieveAssociatedService;
    private final UserProfileService userProfileService;

    @Override
    @Transactional
    public void execute(WorkObjectModel wo) {
        Pair<Long, Long> profileAndRoleCount = null;
//        WorkObjectModel woAssoc = this.retrieveAssociatedService.retrieveAssociated(wo,new String("Associated"),WorkObject.);
        if (!wo.getWorkObject().isEmpty()) {
            WoPeopleDto woPeopleDto = (WoPeopleDto) wo.getWorkObject().get(0).getDto();
            profileAndRoleCount = this.userProfileService.getProfileAndRoleCount(woPeopleDto);
            if ( profileAndRoleCount.getFirst() == 0
                 && wo.isTemp() && woPeopleDto.getWoUserPassTX() != null && !woPeopleDto.getWoUserPassTX().isEmpty()) {
                this.userProfileService.addProfile(woPeopleDto);
            }
//            Pair<Long, Long> hasProfileAndRole =
//            long profileCount = this.userProfileService//.hasProfileAndRole(woPeopleDto.getWoUserNameTX());.countProfileEnabledByUsename(woPeopleDto.getWoUserNameTX());
//            long roleCount = this.userProfileService.countRolesByUsename(woPeopleDto.getWoUserNameTX());
            System.out.println();
        }
        System.out.println();
    }

}
