package ru.khtu.lease.common.data.entity.catalog.organization.organization;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity @Table(name="w_organization")
public class OrganizationEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "spec_id")
    private Long specId;

    //length=700
    @Column(name="woIdTX", length=20, nullable=false)
    private String woIdTX;

    @Column(name="woNameTX", length=330, nullable=false)
    private String woNameTX;

    @Column(name="woRecordStateSY", length=100, nullable=false)
    private String woRecordStateSY;

    @Column(name="woPreviousStateSY", length=100, nullable=false)
    private String woPreviousStateSY;

    @Column(name="woStatusCL", length=150)
    private String woStatusCL;

    @Column(name="woPreviousStatusCL", length=150)
    private String woPreviousStatusCL;

    @Column(name="woFormNameSY", length=150, nullable=false)
    private String woFormNameSY;

    @Column(name="woFullNameTX", length=150)
    private String woFullNameTX;

    @Column(name="woShortNameTX", length=50)
    private String woShortNameTX;

    @Column(name="woInnTX", length=11)
    private String woInnTX;

    @Column(name="woOkpoTX", length=9)
    private String woOkpoTX;

    @Column(name="woOgrnTX", length=14)
    private String woOgrnTX;

    @Column(name="woKppTX", length=10)
    private String woKppTX;

    @Column(name="woCommentTX", length=400)
    private String woCommentTX;

    @Column(name="woDescriptionTX", length=1000)
    private String woDescriptionTX;

}
