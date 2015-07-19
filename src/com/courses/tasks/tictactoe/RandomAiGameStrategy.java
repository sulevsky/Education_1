package com.courses.tasks.tictactoe;

/**
 * Created by VSulevskiy on 19.07.2015.
 */
public class RandomAiGameStrategy implements AiGameStrategy {
    @Override
    public int aiMakeTurn(int[] field) {
        while(true){
            int randomPlace = (int)(Math.random()*9);
            if(field[randomPlace]==0){
                return randomPlace;
            }
        }
    }
}
