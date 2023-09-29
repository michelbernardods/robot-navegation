package com.navegation.robot;

import com.navegation.robot.controller.RoboController;
import com.navegation.robot.model.Robo;
import com.navegation.robot.service.RoboService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class NavegationRoboApplicationTests {

    @Autowired
    private RoboService roboService;
    @Autowired
    private RoboController roboController;

    @Test
    public void testSendCommands_MML() {
        String command = "MML";

        Robo robo = roboService.sendCommands(command);
        ResponseEntity<Object> responseEntity = roboController.sendCommand(command);

        assertEquals(0, robo.getX());
        assertEquals(2, robo.getY());
        assertEquals('W', robo.getDirection());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void testSendCommands_MRMRMLM() {
        String command = "MMRMMRMM";

        Robo robo = roboService.sendCommands(command);
        ResponseEntity<Object> responseEntity = roboController.sendCommand(command);

        assertEquals(2, robo.getX());
        assertEquals(0, robo.getY());
        assertEquals('S', robo.getDirection());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

    }

    @Test
    void testSendCommands_AAA() {
        String command = "AAA";
        ResponseEntity<Object> responseEntity = roboController.sendCommand(command);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("Invalid Command", responseEntity.getBody());

    }
    @Test
    void testSendCommands_MMMMMMMMMMMM() {
        String command = "MMMMMMMMMMMMMMMMMMMMMMMM";
        Robo robo = roboService.sendCommands(command);
        ResponseEntity<Object> responseEntity = roboController.sendCommand(command);

        assertEquals(0, robo.getX());
        assertEquals(24, robo.getY());
        assertEquals('N', robo.getDirection());
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("Invalid Position", responseEntity.getBody());
    }

}
