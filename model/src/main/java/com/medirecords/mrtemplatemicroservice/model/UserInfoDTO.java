package com.medirecords.mrtemplatemicroservice.model;

import lombok.Data;

@Data
public class UserInfoDTO {
    private String userName;
    private String userId;
    private String tenantId;
    private String tenantName;
}
