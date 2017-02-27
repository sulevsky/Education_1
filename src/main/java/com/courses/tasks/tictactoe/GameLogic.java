package com.courses.tasks.tictactoe;

/**
 * Created by VSulevskiy on 19.07.2015.
 */
public class GameLogic {
    //default
    public AiGameStrategy aiGameStrategy;

    public boolean makeTurn(int position){
        return true;
    }
    public int aIMakeTurn(){
        return 0;
    }

    public void setAiGameStrategy(AiGameStrategy gameStrategy){
    }

    public boolean checkPlayerWin() {
        return true;
    }

    public boolean checkAiWin() {
        return true;
    }

}
