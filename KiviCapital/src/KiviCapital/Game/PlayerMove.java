package KiviCapital.Game;

import KiviCapital.Player.Player;

import java.util.*;

public enum PlayerMove {
    ROCK,
    PAPER,
    SCISSORS;

    private static final List<PlayerMove> VALUES = List.of(PlayerMove.values());
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    /**
     * MOVE_MECHANICS contain what move beats which set of moves.
     * Warning: Make sure there is no conflict in the below map i.e. two moves should not be able to beat each other.
     * Eg: Rock beats Scissors and Scissors beats Rock -> This is wrong.
     */
    private static final Map<PlayerMove, Set<PlayerMove>> MOVE_MECHANICS = Map.of(
            PlayerMove.ROCK, Set.of(PlayerMove.SCISSORS),
            PlayerMove.SCISSORS, Set.of(PlayerMove.PAPER),
            PlayerMove.PAPER, Set.of(PlayerMove.ROCK)
    );

    /**
     * Method to generate random player move.
     * @return PlayerMove.
     */
    public static PlayerMove generateRandomMove()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

    /**
     * Method to print all available player moves.
     * @return String - Eg: ROCK, PAPER, SCISSORS
     */
    public static String getMoves() {
        return Arrays.toString(VALUES.toArray());
    }

    /**
     * @return - Returns a Map of PlayerMove - MatchOutcome.
     */
    public static Map<PlayerMove, MatchOutcome> evaluateMoves(PlayerMove moveOne, PlayerMove moveTwo) {
        Map<PlayerMove, MatchOutcome> returnValue = new HashMap<>();
        if (moveOne.equals(moveTwo)) {
            returnValue = Map.of(
                    moveOne, MatchOutcome.DRAW,
                    moveTwo, MatchOutcome.DRAW
            );
        } else if (MOVE_MECHANICS.get(moveOne).contains(moveTwo)) {
            returnValue = Map.of(
                    moveOne, MatchOutcome.WIN,
                    moveTwo, MatchOutcome.LOSE
            );
        } else {
            returnValue = Map.of(
                    moveOne, MatchOutcome.LOSE,
                    moveTwo, MatchOutcome.WIN
            );
        }

        return returnValue;
    }
}
