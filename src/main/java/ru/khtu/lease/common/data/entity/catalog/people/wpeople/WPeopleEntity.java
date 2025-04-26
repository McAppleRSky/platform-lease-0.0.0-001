package ru.khtu.lease.common.data.entity.catalog.people.wpeople;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Getter @Setter
@EqualsAndHashCode
@Entity
@Table(name="w_wpeople")
public class WPeopleEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "spec_id")
    public Long specId;

    //length=700
    @Column(name="wIdTX", length=20, nullable=false)
    private String wIdTX;

    @Column(name="wNameTX", length=330, nullable=false)
    private String wNameTX;

    //length=700
    @Column(name="wUserNameTX", length=100, nullable=false)
    private String wUserNameTX;

    @Column(name="wPositionNameTX", length=150)
    private String wPositionNameTX;

//    @Column(name="wStaffPositionNameTX", length=150) private String wStaffPositionNameTX;

    //length=700
    @Column(name="wFirstNameTX", length=150, nullable=false)
    private String wFirstNameTX;

    //length=700
    @Column(name="wFamilyNameTX", length=150, nullable=false)
    private String wFamilyNameTX;

    @Column(name="wSurnameTX", length=150)
    private String wSurnameTX;

    @Column(name="wMenuLI", length=1000)
    private String wMenuLI;

//    @Column(name="wPortalMenuLI", length=1000) private String wPortalMenuLI;

//    @Column(name="wUserPassTX", length=700) private String wUserPassTX;

    @Column(name="wHomePageLI", length=1000)
    private String wHomePageLI;

    @Column(name="wOrgNameTX", length=1000)
    private String wOrgNameTX;

    @Column(name="wEmailTX", length=50, nullable=false)
    private String wEmailTX;

    @Column(name="wRecordStateSY", length=100, nullable=false)
    private String wRecordStateSY;

    @Column(name="wPreviousStateSY", length=100, nullable=false)
    private String wPreviousStateSY;

    @Column(name="wStatusCL", length=150, nullable=false)
    private String wStatusCL;

    @Column(name="wPreviousStatusCL", length=150, nullable=false)
    private String wPreviousStatusCL;

}
