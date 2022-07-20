package com.medirecords.mrtemplatemicroservice.client;

import com.medirecords.mrtemplatemicroservice.model.UserInfoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient("mr-template-microservice")
public interface MrTemplateMicroserviceClient {
    @GetMapping("v1/api/hello")
    String hello(@RequestParam(value = "name", required = false, defaultValue = "stranger") String name);

    @GetMapping("v1/api/helloUserInfo")
    ResponseEntity<UserInfoDTO> helloUserInfo(@RequestParam(value = "name", required = false, defaultValue = "stranger") String name);
}
