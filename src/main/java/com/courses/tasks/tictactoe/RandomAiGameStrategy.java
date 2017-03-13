package com.courses.tasks.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomAiGameStrategy implements AiGameStrategy {

    @Override
    public int aiMakeTurn(int[] field) {
        List freePlaces = new ArrayList();
        for (int i = 0; i < field.length; i++) {
            if (field[i] == 0) {
                freePlaces.add(i);
            }
        }
        int toPlace = new Random().nextInt(freePlaces.size());
        return (Integer) freePlaces.get(toPlace);
    }
}
