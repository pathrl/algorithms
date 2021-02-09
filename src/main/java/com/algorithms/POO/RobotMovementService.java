package com.algorithms.POO;

import java.util.List;

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
