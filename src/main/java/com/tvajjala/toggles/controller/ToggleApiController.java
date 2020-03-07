package com.tvajjala.toggles.controller;

import com.tvajjala.toggles.model.FeatureToggle;
import com.tvajjala.toggles.service.ToggleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/toggles")
public class ToggleApiController {


    @Autowired
    private ToggleService toggleService;


    private static final Logger LOGGER = LoggerFactory.getLogger(ToggleApiController.class);


    @Cacheable("toggles")
    @GetMapping("/{name}")
    public ResponseEntity<FeatureToggle> getToggle(@PathVariable("name") final String name) {

        LOGGER.info("Returning toggle with name {} ", name);

        return ok(toggleService.getToggle("IDV", name));

    }


    @CacheEvict(allEntries = true, cacheNames = "toggles")
    @PutMapping("/{name}")
    public ResponseEntity update(@PathVariable("name") final String name, @RequestBody final FeatureToggle featureToggle) {

        LOGGER.info("Updating toggle with name {} ", name);

        toggleService.updateToggle("IDV", name, featureToggle);

        return ResponseEntity.accepted().build();

    }


}
