package com.navegation.robot.controller;

import com.navegation.robot.model.Robo;
import com.navegation.robot.service.RoboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rest")
public class RoboController {
    private final RoboService roboService;

    @Autowired
    public RoboController(RoboService roverService) {
        this.roboService = roverService;
    }

    @PostMapping("/mars/{commands}")
    public ResponseEntity<Object> sendCommand(@PathVariable(value = "commands") String commands) {
        commands = commands.toUpperCase();

        if (!isValidCommands(commands)) {
            return ResponseEntity.badRequest().body("Invalid Command");
        }
        Robo robo = roboService.sendCommands(commands);

        if (isValidPosition(robo.getX(), robo.getY())) {
            return ResponseEntity.ok(robo);

        }

        return ResponseEntity.badRequest().body("Invalid Position");
    }

    private boolean isValidCommands(String commands) {
        return commands.matches("^[LRM]+$");
    }

    private boolean isValidPosition(int x, int y) {
        return x >= 0 && x <= 5 && y >= 0 && y <= 5;
    }
}