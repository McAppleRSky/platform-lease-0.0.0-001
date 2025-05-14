package ru.khtu.lease.userprofile.componentSh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.khtu.lease.common.data.entity.catalog.people.wopeople.WoPeopleEntity;

//@Repository
@Repository
public interface UserProfileRepository extends JpaRepository<WoPeopleEntity, Long> {

//    Pair<Boolean, Boolean> hasProfileAndRole(String woUserNameTX);
    @Query(nativeQuery = true, value = "" +
            "SELECT COUNT(*) FROM user_profile p " +
            " WHERE p.enabled > 0 AND p.username = ?1")
    long countProfileEnabledByUsename(String username);

    @Query(nativeQuery = true, value = "" +
            "SELECT COUNT(*) FROM authority_role p WHERE p.username = ?1")
    long countRolesByUsename(String woUserNameTX);


    @Query(nativeQuery = true, value = "" +
            "INSERT INTO user_profile (username, password, enabled) " +
            "     VALUES (?1, ?2, 1)")
    void insertProfile(String woUserNameTX, String woUserPassTX);

    @Query(nativeQuery = true, value = "" +
            "INSERT INTO user_profile (username, role) " +
            "     VALUES (?1, 'ROLE_USER')")
    void insertRoleUser(String woUserNameTX);

}
