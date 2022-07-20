package com.medirecords.mrtemplatemicroservice.rest.sample.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "mrClient", url = "http://mrapp.test.medirecords.com")
public interface MrappClient {
    @GetMapping(value = "/secure/api-mrapp/patients/")
    String findAll(Pageable pageable);
}
