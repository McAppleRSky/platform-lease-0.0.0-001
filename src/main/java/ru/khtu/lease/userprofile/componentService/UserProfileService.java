package ru.khtu.lease.userprofile.componentService;

import org.springframework.data.util.Pair;
import ru.khtu.lease.common.data.dto.catalog.people.wopeople.WoPeopleDto;

public interface UserProfileService {

    Pair<Long, Long> getProfileAndRoleCount(WoPeopleDto woPeopleDto);

    void addProfile(WoPeopleDto woPeopleDto);

}
