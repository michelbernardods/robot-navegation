package com.navegation.robot.controller;

import com.navegation.robot.model.Robo;
import com.navegation.robot.service.RoboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rest")
public class RoboController {
    private final RoboService roboService;

    @Autowired
    public RoboController(RoboService roverService) {
        this.roboService = roverService;
    }

    @PostMapping("/mars")
    public Robo sendCommands(@RequestBody String commands) {
        return roboService.sendCommands(commands);
    }

    @PostMapping("/mars/{commands}")
    public Robo sendCommand(@PathVariable(value = "commands") String commands) {
        return roboService.sendCommands(commands);
    }
}