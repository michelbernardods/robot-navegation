package com.navegation.robot.service;

import com.navegation.robot.model.Robo;
import org.springframework.stereotype.Service;

@Service
public class RoboServiceImpl implements RoboService {
    private static final int MAX_X = 5;
    private static final int MAX_Y = 5;

    @Override
    public Robo sendCommands(String commands) {
        Robo robo = new Robo(0, 0, 'N');

        for (char command : commands.toCharArray()) {
            if (command == 'L') {
                rotateLeft(robo);
            } else if (command == 'R') {
                rotateRight(robo);
            } else if (command == 'M') {
                moveForward(robo);
            }
        }

        return robo;
    }

    private void rotateLeft(Robo robo) {
        switch (robo.getDirection()) {
            case 'N':
                robo.setDirection('W');
                break;
            case 'W':
                robo.setDirection('S');
                break;
            case 'S':
                robo.setDirection('E');
                break;
            case 'E':
                robo.setDirection('N');
                break;
        }
    }

    private void rotateRight(Robo robo) {
        switch (robo.getDirection()) {
            case 'N':
                robo.setDirection('E');
                break;
            case 'E':
                robo.setDirection('S');
                break;
            case 'S':
                robo.setDirection('W');
                break;
            case 'W':
                robo.setDirection('N');
                break;
        }
    }

    private void moveForward(Robo robo) {
        int newX = robo.getX();
        int newY = robo.getY();

        switch (robo.getDirection()) {
            case 'N':
                newY++;
                break;
            case 'E':
                newX++;
                break;
            case 'S':
                newY--;
                break;
            case 'W':
                newX--;
                break;
        }

        robo.setX(newX);
        robo.setY(newY);
    }
}