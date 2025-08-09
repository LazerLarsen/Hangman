package com.hangman;

import java.util.Scanner;

public class ConsoleUI implements HangmanUI{

    private Scanner scanner = new Scanner(System.in);
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public void printMessage(String message, String colorCode) {
        System.out.println(colorCode + message + ANSI_RESET);
    }

    @Override
    public void displayGameState(HangmanGame game) {
        System.out.println(HangmanStages.STAGES[game.getWrongGuessCount()]);
        System.out.println("Word: " + game.getMaskedWord());
        System.out.println("Remaining attempts " + game.getRemainingAttemps());
    }

    @Override
    public char getUserGuess() {
        System.out.println("Enter a letter: ");
        String input = scanner.nextLine();
        return input.toLowerCase().charAt(0);
    }

    @Override
    public void displayResult(boolean won, String word, HangmanGame game) {
        if (won) {
            printMessage("Congratulations! You guessed the word: " + word, ANSI_GREEN);
        } else {
            System.out.print(HangmanStages.STAGES[game.getWrongGuessCount()]);
            printMessage("Game over! The word was: " + word, ANSI_RED);
        }
    }

    @Override
    public void displayGuessResult(boolean correct) {
        if (correct) {
            printMessage("You guessed correct!", ANSI_GREEN);
        } else {
            printMessage("You guessed wrong!", ANSI_RED);
        }
    }

    public Difficulty askForDifficulty() {
        System.out.println("Choose difficulty: EASY, MEDIUM, HARD");
        Difficulty difficulty = null;
        while (difficulty == null) {
            try {
                String input = scanner.nextLine().trim().toUpperCase();
                difficulty = Difficulty.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid choice. Please type EASY, MEDIUM, or HARD:");
            }
        }

        return difficulty;
    }
}