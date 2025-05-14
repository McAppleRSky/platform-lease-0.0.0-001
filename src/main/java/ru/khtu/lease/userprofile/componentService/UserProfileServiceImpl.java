package ru.khtu.lease.userprofile.componentService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import ru.khtu.lease.common.data.dto.catalog.people.wopeople.WoPeopleDto;
import ru.khtu.lease.userprofile.componentSh.repository.UserProfileRepository;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository userProfileRepository;

    @Override
    public Pair<Long, Long> getProfileAndRoleCount(WoPeopleDto woPeopleDto) {
        return Pair.of(
                this.userProfileRepository.countProfileEnabledByUsename(woPeopleDto.getWoUserNameTX()),
                this.userProfileRepository.countRolesByUsename(woPeopleDto.getWoUserNameTX())
        );
    }

    @Override
    public void addProfile(WoPeopleDto woPeopleDto) {
        this.userProfileRepository.insertProfile(woPeopleDto.getWoUserNameTX(), woPeopleDto.getWoUserPassTX());
        this.userProfileRepository.insertRoleUser(woPeopleDto.getWoUserNameTX());
    }

// @Query(value = "SELECT COUNT(1) FROM user_profile p WHERE p.enabled > 0 and p.username = :name", nativeQuery = true)
// @Query(value = "SELECT * FROM Users u WHERE u.status = :status and u.name = :name",nativeQuery = true)
// User findUserByStatusAndNameNamedParamsNative(@1Param("status") Integer status, @Param("name") String name);

}
