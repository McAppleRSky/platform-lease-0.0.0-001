package ru.khtu.lease.common.data.dto.catalog.classification.classification;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ClassificationDto {

    private final Long specId;
    private final String woIdTX;
    private final String woNameTX;
    private final String woPathTX;
    private final String woCodeTX;
    private final String woRecordStateSY;
    private final String woPreviousStateSY;
    private final String woStatusCL;
    private final String woPreviousStatusCL;
    private final String woFormNameSY;
    private final String woUserCommentTX;
    private final String woDescriptionTX;

}
