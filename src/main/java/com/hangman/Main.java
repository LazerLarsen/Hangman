package com.hangman;

public class Main {
    public static void main(String[] args) {
        WordProvider wordProvider = new FileWordProvider("words.txt");
        HangmanGame game = new HangmanGame(wordProvider);
        
        HangmanUI ui = new ConsoleUI();

        while (!game.isGameOver() && !game.isGameWon()){
            ui.displayGameState(game);
            char guess = ui.getUserGuess();
            boolean correct = game.guessLetter(guess);

            ui.displayGuessResult(correct);
        }

        ui.displayResult(game.isGameWon(),game.getWord(), game);
    }
}