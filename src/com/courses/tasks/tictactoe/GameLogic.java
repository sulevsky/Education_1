package com.courses.tasks.tictactoe;

/**
 * Created by VSulevskiy on 19.07.2015.
 */
public class GameLogic {
    public int[] data = new int[9];
    //default
    public AiGameStrategy aiGameStrategy = new RandomAiGameStrategy();

    public boolean makeTurn(int position){
        if(data[position]==0){
            data[position] = 1;
            System.out.println("MAde a move");
            return true;
        }
        return false;
    }
    public int aIMakeTurn(){
        int pos = aiGameStrategy.aiMakeTurn(data);
        data[pos] = 2;
        return pos;
    }

    public void setAiGameStrategy(AiGameStrategy gameStrategy){
        this.aiGameStrategy = gameStrategy;
    }

    public boolean checkPlayerWin() {//TODO optimize
        if (data[0]== 1 && data[1]== 1 &&data[2]== 1) return true;
        if (data[3]== 1 && data[4]== 1 &&data[5]== 1) return true;
        if (data[6]== 1 && data[7]== 1 &&data[8]== 1) return true;
        if (data[0]== 1 && data[3]== 1 &&data[6]== 1) return true;
        if (data[1]== 1 && data[4]== 1 &&data[7]== 1) return true;
        if (data[2]== 1 && data[5]== 1 &&data[8]== 1) return true;
        if (data[0]== 1 && data[4]== 1 &&data[8]== 1) return true;
        if (data[2]== 1 && data[4]== 1 &&data[6]== 1) return true;
        else return false;
    }

    public boolean checkAiWin() {//TODO optimize
        if (data[0]== 2 && data[1]== 2 &&data[2]== 2) return true;
        if (data[3]== 2 && data[4]== 2 &&data[5]== 2) return true;
        if (data[6]== 2 && data[7]== 2 &&data[8]== 2) return true;
        if (data[0]== 2 && data[3]== 2 &&data[6]== 2) return true;
        if (data[1]== 2 && data[4]== 2 &&data[7]== 2) return true;
        if (data[2]== 2 && data[5]== 2 &&data[8]== 2) return true;
        if (data[0]== 2 && data[4]== 2 &&data[8]== 2) return true;
        if (data[2]== 2 && data[4]== 2 &&data[6]== 2) return true;
        else return false;
    }

}
