package com.algorithms.POO;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private final RobotMovementService service;

    public Main(RobotMovementService service) {
        this.service = service;
    }


    public void main() {
        Robot robot = new Robot();
        List<Movement> movements = new ArrayList<>();
        service.moveRobot(movements, robot);

        System.out.println(robot.getX() +", "+ robot.getY());
    }
}
