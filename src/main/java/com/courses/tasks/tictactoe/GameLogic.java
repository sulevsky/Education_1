package com.courses.tasks.tictactoe;

/**
 * Created by VSulevskiy on 19.07.2015.
 */
public class GameLogic {
    public static final int PLACED_BY_GAMER = 1;
    public static final int PLACED_BY_AI = -1;
    //default
    public AiGameStrategy aiGameStrategy;

    private final int[] field = new int[9];

    public boolean makeTurn(int position) {
        if (field[position] != 0) {
            return false;
        }
        field[position] = PLACED_BY_GAMER;
        return true;
    }

    public int aIMakeTurn() {
        int aiPosition = aiGameStrategy.aiMakeTurn(field);
        field[aiPosition] = PLACED_BY_AI;
        return aiPosition;
    }

    public void setAiGameStrategy(AiGameStrategy gameStrategy) {
        this.aiGameStrategy = gameStrategy;
    }


    public boolean checkPlayerWin() {
        return checkWin(PLACED_BY_GAMER);
    }

    public boolean checkAiWin() {
        return checkWin(PLACED_BY_AI);
    }

    private boolean checkWin(int placedBy) {
        boolean top = field[0] == placedBy && field[1] == placedBy && field[2] == placedBy;
        boolean middle = field[3] == placedBy && field[4] == placedBy && field[5] == placedBy;
        boolean bottom = field[6] == placedBy && field[7] == placedBy && field[8] == placedBy;

        boolean left = field[0] == placedBy && field[3] == placedBy && field[6] == placedBy;
        boolean center = field[1] == placedBy && field[4] == placedBy && field[7] == placedBy;
        boolean right = field[2] == placedBy && field[5] == placedBy && field[8] == placedBy;

        boolean diagonal = field[0] == placedBy && field[4] == placedBy && field[8] == placedBy;
        boolean backDiagonal = field[2] == placedBy && field[4] == placedBy && field[6] == placedBy;

        boolean isWin = top || middle || bottom || left || center || right || diagonal || backDiagonal;
        return isWin;


    }

}
