package com.tvajjala.toggles.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/toggles")
public class ToggleApiController {


    @GetMapping("/")
    public void updateToggle() {

    }


}
