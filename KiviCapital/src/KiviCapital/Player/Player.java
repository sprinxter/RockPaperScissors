package KiviCapital.Player;

import KiviCapital.Game.PlayerMove;

/**
 * Interface for Player type.
 */
public interface Player {

    /**
     * Method for player to choose a move in the Game.
     * @return PlayerMove Enum.
     */
    PlayerMove chooseMove();
}
