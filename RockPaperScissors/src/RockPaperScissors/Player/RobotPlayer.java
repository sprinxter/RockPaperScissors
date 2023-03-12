package RockPaperScissors.Player;

import RockPaperScissors.Game.PlayerMove;

public class RobotPlayer extends BasePlayer {

    public RobotPlayer(final String name) {
        super(name);
    }

    @Override
    public PlayerMove chooseMove() {

        System.out.printf("\n Choosing robot player: %s's move randomly... \n", this.getPlayerName());
        PlayerMove playerMove = PlayerMove.generateRandomMove();
        this.setPlayerMove(playerMove);
        System.out.printf("%s chose %s \n", this.getPlayerName(), this.getPlayerMove());

        return this.getPlayerMove();
    }
}
