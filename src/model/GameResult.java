package model;

import core.Game;

import java.io.Serial;
import java.io.Serializable;

public class GameResult implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Game game;
    private int winnings, bet;
    private boolean win;

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getWinnings() {
        return winnings;
    }

    public void setWinnings(int winnings) {
        this.winnings = winnings;
    }

    public boolean isWin() {
        return win;
    }

    public int getBet() {
        return bet;
    }

    public GameResult(Game game, int winnings, int bet, boolean win) {
        this.game = game;
        this.winnings = winnings;
        this.bet = bet;
        this.win = win;
    }

    @Override
    public String toString() {
        return win ? "Game: " + game.getGameName()
                + "\n Vsazeno: " + getBet()
                + "\n Vyhrana castka: " + getWinnings()
                :
                "Game: " + game.getGameName()
                + "\n Vsazeno: " + getBet()
                + "\n Prohrano";
    }
}
