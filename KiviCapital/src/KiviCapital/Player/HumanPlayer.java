package KiviCapital.Player;

import KiviCapital.Game.PlayerMove;
import KiviCapital.Utils.InputReader;

public class HumanPlayer extends BasePlayer {

    public HumanPlayer(String name) {
        super(name);
    }

    /**
     * Method for player to choose a move in the Game.
     *
     * @return PlayerMove Enum.
     */
    @Override
    public PlayerMove chooseMove() {

        System.out.printf("\n Input move for player: %s and press Enter \n", this.getPlayerName());
        System.out.printf("Available moves: %s \n", PlayerMove.getMoves());
        while (true) {
            try {
                String playerMoveString = InputReader.readNextLine();
                PlayerMove playerMove = PlayerMove.valueOf(playerMoveString.toUpperCase());
                this.setPlayerMove(playerMove);
                System.out.println("Player move noted.");
                break;
            } catch (Exception e) {
                System.out.println("Re-Enter player move. " +
                        "Please not that it should belong to the above available moves");
            }
        }

        return this.getPlayerMove();
    }
}
