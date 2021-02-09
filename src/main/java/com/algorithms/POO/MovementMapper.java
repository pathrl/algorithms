package com.algorithms.POO;

import java.util.HashMap;
import java.util.Map;

public class MovementMapper {
    private Map<Movement, int[]> map = new HashMap<>();

    public int[] map(Movement movement) {
        return map.get(movement);
    }
}
