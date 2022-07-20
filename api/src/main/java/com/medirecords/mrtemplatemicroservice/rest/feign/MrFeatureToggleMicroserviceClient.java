package com.medirecords.mrtemplatemicroservice.rest.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient("mr-feature-toggle-microservice")
public interface MrFeatureToggleMicroserviceClient {
    @PutMapping("/v1/featuretoggle/toggle")
    ConfigurationResponse toggleFeatureToggle(@RequestBody ConfigurationRequest request);

    @GetMapping("/v1/featuretoggle/check/{type_code}/{config_name}/tenant/{tenant_guid}")
    Boolean checkTenantConfiguration(
            @PathVariable("type_code") String typeCode,
            @PathVariable("config_name") String configName,
            @PathVariable("tenant_guid") String tenantGuid);

    @GetMapping("/v1/featuretoggle/check/{type_code}/{config_name}/tenant/{tenant_guid}/practice/{practice_guid}")
    Boolean checkPracticeConfigurationExistsAndEnabled(
            @PathVariable("type_code") String typeCode,
            @PathVariable("config_name") String configName,
            @PathVariable("tenant_guid") String tenantGuid,
            @PathVariable("practice_guid") String practiceGuid);

    @GetMapping("/v1/featuretoggle/check/{type_code}/{config_name}/tenant/{tenant_guid}/practice/{practice_guid}/user/{user_guid}")
    Boolean checkUserConfigurationExistsAndEnabled(
            @PathVariable("type_code") String typeCode,
            @PathVariable("config_name") String configName,
            @PathVariable("tenant_guid") String tenantGuid,
            @PathVariable("practice_guid") String practiceGuid,
            @PathVariable("user_guid") String userGuid);
}
