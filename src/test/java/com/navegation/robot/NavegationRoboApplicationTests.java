package com.navegation.robot;

import com.navegation.robot.model.Robo;
import com.navegation.robot.service.RoboService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class NavegationRoboApplicationTests {

    @Autowired
    private RoboService roboService;

    @Test
    public void testSendCommands_MML() {
        Robo robo = roboService.sendCommands("MML");
        assertEquals(0, robo.getX());
        assertEquals(2, robo.getY());
        assertEquals('W', robo.getDirection());
    }

    @Test
    public void testSendCommands_MRMRMLM() {
        Robo robo = roboService.sendCommands("MRMRMLM");
        assertEquals(2, robo.getX());
        assertEquals(0, robo.getY());
        assertEquals('E', robo.getDirection());
    }

}
