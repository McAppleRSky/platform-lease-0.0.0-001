package ru.khtu.lease.common.data.entity.catalog.people.wopeople;

import lombok.*;
import ru.khtu.lease.statemachine.util.entity.EntityCreateAble;
import ru.khtu.lease.statemachine.util.entity.EntityStateAble;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity @Table(name="w_wopeople")
public class WoPeopleEntity implements EntityCreateAble, EntityStateAble {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "spec_id")
    private Long specId;

    //length=700
    @Column(name="woIdTX", length=20, nullable=false)
    private String woIdTX;

    @Column(name="woNameTX", length=330, nullable=false)
    public String woNameTX;

    //length=700
    @Column(name="woUserNameTX", length=100, nullable=false)
    public String woUserNameTX;

    @Column(name="woPositionNameTX", length=150)
    public String woPositionNameTX;

//    @Column(name="wStaffPositionNameTX", length=150) private String wStaffPositionNameTX;

    //length=700
    @Column(name="woFirstNameTX", length=150)
    public String woFirstNameTX;

    //length=700
    @Column(name="woFamilyNameTX", length=150)
    public String woFamilyNameTX;

    @Column(name="woSurnameTX", length=150)
    public String woSurnameTX;

    @Column(name="woMenuLI", length=1000)
    public String woMenuLI;

//    @Column(name="wPortalMenuLI", length=1000) private String wPortalMenuLI;

    @Column(name="wUserPassTX", length=700)
    private String woUserPassTX;

    @Column(name="woHomePageLI", length=1000)
    public String woHomePageLI;

    @Column(name="woOrgNameTX", length=1000)
    public String woOrgNameTX;

    @Column(name="woEmailTX", length=50)
    public String woEmailTX;

    @Column(name="woRecordStateSY", length=100, nullable=false)
    public String woRecordStateSY;

    @Column(name="woPreviousStateSY", length=100, nullable=false)
    public String woPreviousStateSY;

    @Column(name="woStatusCL", length=150)
    public String woStatusCL;

    @Column(name="woPreviousStatusCL", length=150)
    public String woPreviousStatusCL;

    @Column(name="woFormNameSY", length=150, nullable=false)
    public String woFormNameSY;

}
