package com.medirecords.mrtemplatemicroservice.rest.feign;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConfigurationRequest {

    @Size(max = 100)
    @JsonProperty("config_name")
    private String configName;

    @NotNull
    @Size(max = 50)
    @JsonProperty("config_type_code")
    private String configurationTypeCode;

    @NotNull
    @Size(max = 36)
    @JsonProperty("tenant_guid")
    private String tenantGuid;

    @NotNull
    @Size(max = 30)
    @JsonProperty("data_type_name")
    private String dataTypeName;

    @Size(max = 30)
    @JsonProperty("config_group_name")
    private String configGroupName;

    // Optional
    @Size(max = 100)
    @JsonProperty("config_value")
    private String configValue;

    @Size(max = 36)
    @JsonProperty("practice_guid")
    private String practiceGuid;

    @Size(max = 36)
    @JsonProperty("user_guid")
    private String userGuid;

    @Size(max = 50)
    @JsonProperty("lookup_name")
    private String lookupName;

    @Size(max = 500)
    @JsonProperty("lookup_source")
    private String lookupSource;

    @Size(max = 500)
    @JsonProperty("config_description")
    private String configDescription;

    @Size(max = 200)
    @JsonProperty("config_label")
    private String configLabel;

    @Size(max = 100)
    @JsonProperty("configurationsubheading")
    private String configurationSubheading;

}
