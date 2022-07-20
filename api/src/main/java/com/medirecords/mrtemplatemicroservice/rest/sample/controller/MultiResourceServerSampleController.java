package com.medirecords.mrtemplatemicroservice.rest.sample.controller;

import com.medirecords.userinjection.CurrentUserDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/sample-api")
public class MultiResourceServerSampleController {
    private final CurrentUserDetails currentUser;
    public MultiResourceServerSampleController(CurrentUserDetails currentUser) {
        this.currentUser = currentUser;
    }

    @GetMapping("/api-online-appointment/appointment")
    public ResponseEntity<String> onlineAppointment() {
        String tenantName = this.currentUser.getTenantName();
        String userName = this.currentUser.getUserName();
        String tenantId = this.currentUser.getTenantId();
        String userId = this.currentUser.getUserId();
        return ResponseEntity.ok(String.format("Hello, this is api-online-appointment. "
                        + "Tenant id: %s. User id: %s. Tenant name: %s. User name: %s", tenantId, userId,
                tenantName, userName));
    }

    @GetMapping("/api-mrapp/appointment")
    public ResponseEntity<String> mrappAppointment() {
        String tenantName = this.currentUser.getTenantName();
        String userName = this.currentUser.getUserName();
        String tenantId = this.currentUser.getTenantId();
        String userId = this.currentUser.getUserId();
        return ResponseEntity.ok(String.format("Hello, this is api-mrapp. "
                        + "Tenant id: %s. User id: %s. Tenant name: %s. User name: %s", tenantId, userId,
                tenantName, userName));
    }

    @GetMapping("/api-patient-portal/appointment")
    public ResponseEntity<String> patientPortalAppointment() {
        String tenantName = this.currentUser.getTenantName();
        String userName = this.currentUser.getUserName();
        String tenantId = this.currentUser.getTenantId();
        String userId = this.currentUser.getUserId();
        return ResponseEntity.ok(String.format("Hello, this is api-patient-portal. "
                        + "Tenant id: %s. User id: %s. Tenant name: %s. User name: %s", tenantId, userId,
                tenantName, userName));
    }
}
