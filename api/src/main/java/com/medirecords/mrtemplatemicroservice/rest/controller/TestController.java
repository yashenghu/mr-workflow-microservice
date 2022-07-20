package com.medirecords.mrtemplatemicroservice.rest.controller;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/data/test")
public class TestController {
//    private final ConfigurationRepository configurationRepository;
//    private final SnomeduserRepository    snomeduserRepository;

    private static Logger logger = LoggerFactory.getLogger(TestController.class);

//    @GetMapping("/configuration/{id}")
//    public Configuration findByIdConfiguration(@PathVariable String id) {
//        Optional<Configuration> config = this.configurationRepository.findById(id);
//        return config.orElse(null);
//    }

//    @GetMapping("/snomeduser/all")
//    public List<Snomeduser> findAllSnomeduser() {
//        List<Snomeduser> snomeduser = this.snomeduserRepository.findAll();
//        return snomeduser;
//    }
}
