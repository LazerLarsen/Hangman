package com.hangman;

public interface HangmanUI {
    public void displayGameState(HangmanGame game);
    public char getUserGuess();
    public void displayResult(boolean won, String word, HangmanGame game);
    public void displayGuessResult(boolean correct);
    public Difficulty askForDifficulty();
}
