package com.hangman;

public class Main {
    public static void main(String[] args) {

        HangmanUI ui = new ConsoleUI();
        Difficulty difficulty = ui.askForDifficulty();
        WordProvider wordProvider = new FileWordProvider("words.txt");
        HangmanGame game = new HangmanGame(wordProvider, difficulty);
        
        

        while (!game.isGameOver() && !game.isGameWon()){
            ui.displayGameState(game);
            char guess = ui.getUserGuess();
            boolean correct = game.guessLetter(guess);

            ui.displayGuessResult(correct);
        }

        ui.displayResult(game.isGameWon(),game.getWord(), game);
    }
}