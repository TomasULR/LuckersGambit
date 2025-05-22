package assets;

import model.GameResult;
import model.Player;

import java.util.*;
public class PlayerStats {

    public static void printStats(Player player) {

        List<GameResult> history = player.getHistory();
        if (!(history.isEmpty())){
            System.out.println("=== Player Statistics ===");
            System.out.println("Hráč: " + player.getNickName());
            System.out.println("Současný stav: " + player.getBalance());
            System.out.println("Total Games Played: " + history.size());
            System.out.println("Počet vyhraných her: " + countWins(history));
            System.out.println("Prohry: " + countLosses(history));
            System.out.println("Zisk/ztráta " + totalWinnings(history));
            System.out.println("Win rate " + getWinRate(history));
        }
        else {
            System.out.println("Historie je zatím prázdná...");
        }

    }

    public static long countWins(List<GameResult> history) {
        return history.stream().filter(GameResult::isWin).count();
    }

    public static long countLosses(List<GameResult> history) {
        int lossConut = 0;
        for (GameResult g: history) {
            if (!(g.isWin())){
                lossConut++;
            }
        }
        return lossConut;
    }

    public static int totalWinnings(List<GameResult> history) {
        int winSum = 0;
        for (GameResult g: history) {
            if (g.isWin()){
                winSum += g.getWinnings();
            }
        }
        return winSum;
    }

    public static String getWinRate(List<GameResult> history) {
        int gamesCount = history.size();
        double x = ((double) countWins(history) /gamesCount) * 100;
        return x + " %";
    }
}
