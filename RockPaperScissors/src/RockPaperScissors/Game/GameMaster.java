package RockPaperScissors.Game;

import RockPaperScissors.Player.BasePlayer;
import RockPaperScissors.Utils.InputReader;
import java.util.*;

/**
 * Master class that oversees the whole game.
 */
public class GameMaster {
    private final List<BasePlayer> totalPlayers;

    public GameMaster(final List<BasePlayer> robotPlayers, final List<BasePlayer> humanPlayers) {
        this.totalPlayers = new ArrayList<>();
        totalPlayers.addAll(robotPlayers);
        totalPlayers.addAll(humanPlayers);
        if (totalPlayers.size() <= 1) {
            System.out.println("total players is <= 1. Exiting");
            System.exit(1);
        }
    }

    public void startGame() {
        while (true) {
            System.out.println("Starting new Match!");

            this.conductMatch();

            System.out.println("\n Type 'y' to continue the game. Type 'n' to complete the game.");
            String output = InputReader.readNextLine();
            if (!output.equals("y")) {
                break;
            }
        }

        // Print total game statistics.
        System.out.println("\n Total Game Statistics:");
        for (BasePlayer player : totalPlayers) {
            player.printPlayerStatistics();
        }
        System.out.println("\n Thanks for Playing!!!");
    }

    /**
     * Conducts a single match.
     * Total distinct player moves will be greater than 0 since no. of players are strictly >0.
     * if in a match, there are >2 or 1 total distinct player moves, then it is a draw b/w all of them.
     * if in a match, there are exactly 2 total distinct player moves, then it is a definite win and lose situation.
     * Eg for 3 people:
     * [Rock, Rock, Rock] -> Draw
     * [Rock, Paper, Scissors] -> Draw (Since there is no clear winner.
     * [Rock, Paper, Paper] -> Win for first person and lose for 2nd and 3rd i.e. total distinct player moves = 2
     */
    private void conductMatch() {
        // Loop until there's no clear group of winners.
        Map<PlayerMove, List<BasePlayer>> playerMoveMap = new HashMap<>();

        // Choose moves and fill playerMoveMap.
        this.chooseMoves(totalPlayers, playerMoveMap);

        // Evaluate and see if there is a winner.
        if (playerMoveMap.size() == 2) {
            // Clear Win-Lose situation.
            List<BasePlayer> winners = new ArrayList<>();
            List<PlayerMove> playerMoves = playerMoveMap.keySet().stream().toList();
            Map<PlayerMove, MatchOutcome> evaluation = PlayerMove.evaluateMoves(playerMoves.get(0), playerMoves.get(1));

            System.out.println("Evaluation: " + evaluation.toString());

            for (PlayerMove playerMove : evaluation.keySet()) {
                updatePlayerStatistics(playerMoveMap.get(playerMove), evaluation.get(playerMove));
                if (evaluation.get(playerMove) == MatchOutcome.WIN) { winners = playerMoveMap.get(playerMove); }
            }
            System.out.printf("Match is Won by players: %s \n\n", GameMaster.combinePlayerNames(winners));
        } else {
            // Unclear i.e. Draw situation.
            updatePlayerStatistics(totalPlayers, MatchOutcome.DRAW);
            System.out.println("Match is draw. Updating all player's statistics.");
        }
    }

    /**
     * Method to choose moves for each player in the given list of players.
     * @param playerList - Player List.
     * @param playerMoveMap - Map of PlayerMove -> List of Players who played that move.
     */
    private void chooseMoves(final List<BasePlayer> playerList, final Map<PlayerMove, List<BasePlayer>> playerMoveMap) {
        for (BasePlayer player: playerList) {
            PlayerMove move = player.chooseMove();
            List<BasePlayer> players = playerMoveMap.getOrDefault(move, new ArrayList<BasePlayer>());
            players.add(player);
            playerMoveMap.put(move, players);
        }
    }

    /**
     * Update player statistics for each player.
     * @param playerList - List of players.
     * @param matchOutcome - Common Match outcome for all the list of players
     */
    private void updatePlayerStatistics(final List<BasePlayer> playerList, MatchOutcome matchOutcome) {
        switch (matchOutcome) {
            case WIN:
                for (BasePlayer player : playerList) player.increaseWinCount(1);
                break;
            case DRAW:
                for (BasePlayer player : playerList) player.increaseDrawCount(1);
                break;
            case LOSE:
                for (BasePlayer player : playerList) player.increaseLoseCount(1);
                break;
            default:
                break;
        }
    }

    private static String combinePlayerNames(List<BasePlayer> players) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < players.size(); i++) {
            sb.append(players.get(i).getPlayerName());
            if (i < players.size() - 1) {
                sb.append(", ");
            }
        }

        return sb.toString();
    }
}
