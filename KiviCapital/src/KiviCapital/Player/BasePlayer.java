package KiviCapital.Player;

import KiviCapital.Game.PlayerMove;

/**
 * Base Player class.
 */
public abstract class BasePlayer implements Player{

    private final String name;
    private PlayerMove playerMove;
    private int winCount;
    private int drawCount;
    private int loseCount;

    public BasePlayer(final String name) {
        this.name = name;
        this.winCount = 0;
        this.drawCount = 0;
        this.loseCount = 0;
    }

    public String getPlayerName() {
        return this.name;
    }

    public PlayerMove getPlayerMove() {
        return this.playerMove;
    }

    public int getWinCount() {
        return this.winCount;
    }

    public int getDrawCount() {
        return this.drawCount;
    }

    public int getLoseCount() {
        return this.loseCount;
    }

    public int getNoOfGames() {
        return this.winCount + this.drawCount + this.loseCount;
    }

    public void printPlayerStatistics() {
        System.out.printf("Player: %s, WON: %d, DRAWN: %d, LOST: %d, TOTAL: %d \n", this.getPlayerName(),
                this.getWinCount(), this.getDrawCount(), this.getLoseCount(), this.getNoOfGames());
    }

    public void setPlayerMove (PlayerMove playerMove) {
        this.playerMove = playerMove;
    }

    public int increaseWinCount(int count) {
        this.winCount = this.winCount + count;
        return this.winCount;
    }

    public int increaseLoseCount(int count) {
        this.loseCount = this.loseCount + count;
        return this.loseCount;
    }

    public int increaseDrawCount(int count) {
        this.drawCount = this.drawCount + count;
        return this.drawCount;
    }
}
