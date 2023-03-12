package KiviCapital;

import KiviCapital.Game.GameMaster;
import KiviCapital.Player.BasePlayer;
import KiviCapital.Player.HumanPlayer;
import KiviCapital.Player.RobotPlayer;
import KiviCapital.Utils.InputReader;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int robotPlayerCount = 0;
        int humanPlayerCount = 0;
        List<BasePlayer> robotPlayers = new ArrayList<>();
        List<BasePlayer> humanPlayers = new ArrayList<>();

        System.out.println("Welcome to the game!");
        System.out.println("Enter no. of Robot and Human Players. Eg: 3 5 and Enter");
        robotPlayerCount = InputReader.readNextInt();
        humanPlayerCount = InputReader.readNextInt();
        InputReader.readNextLine(); // Ignore Enter;

        // Initial checks.
        if (robotPlayerCount < 0 || humanPlayerCount < 0) {
            System.out.println("Player count should be positive. Exiting");
            System.exit(1);
        } else if (robotPlayerCount + humanPlayerCount <= 1) {
            System.out.println("Total player count should be greater than 1. Exiting");
            System.exit(1);
        }

        // Taking names of players.
        for (int i = 1; i <= robotPlayerCount; i++) {
            System.out.printf("Enter Robot Player number %d's name and press Enter: ", i);
            String name = InputReader.readNextLine();
            BasePlayer player = new RobotPlayer(name);
            robotPlayers.add(player);
        }

        for (int i = 1; i <= humanPlayerCount; i++) {
            System.out.printf("Enter Human Player number %d's name and press Enter: ", i);
            String name = InputReader.readNextLine();
            BasePlayer player = new HumanPlayer(name);
            humanPlayers.add(player);
        }

        // Starting game.
        GameMaster gameMaster = new GameMaster(robotPlayers, humanPlayers);
        gameMaster.startGame();
    }
}