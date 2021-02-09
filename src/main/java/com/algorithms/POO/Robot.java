package com.algorithms.POO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Robot {

    private int x;
    private int y;

    public Robot() {
        this.x = 0;
        this.y = 0;
    }

    public void move(int x, int y, int repetition) {
        this.x += repetition * x;
        this.y += repetition * y;
    }
}

/*public class Movement {
    public String direction;
    public int repetition;

    public Movement() {

    }
}

public class MovementMapper {

    private Map<Movement, int[]> map = new HashMap<>();

    public int[] map(Movement movement) {
        return map.get(movement);
    }
}


public class RobotMovementService {

    private MovementMapper movementMapper;

    public RobotMovementService(MovementMapper movementMapper) {
        this.movementMapper = movementMapper;
    }

    public void moveRobot(List<Movement> movements, Robot robot) {

        for (Movement movement: movements) {
            int[] position = movementMapper.map(movement);

            robot.move(position[0], position[1], movement.repetition);

        }
    }
}

public class Main {
    private final RobotMovementService service;

    public Main(RobotMovementService service) {
        this.service = service;
    }


    public void main() {
        Robot robot = new Robot();
        List<Movement> movements = new ArrayList<>();
        service.moveRobot(movements, robot);

        System.out.println(robot.getX(), robot.getY());
    }
}*/
