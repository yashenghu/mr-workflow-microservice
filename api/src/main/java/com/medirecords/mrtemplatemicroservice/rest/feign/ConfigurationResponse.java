package com.medirecords.mrtemplatemicroservice.rest.feign;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ConfigurationResponse {

    @NotNull
    private String configGroupName;

    @NotNull
    private String configName;

    @NotNull
    private String configLabel;

    @NotNull
    private String configValue;

}
