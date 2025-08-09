package com.hangman;

import java.util.HashSet;
import java.util.Set;

public class HangmanGame {
    private String _wordToGuess;
    private Set<Character> _correctGuesses = new HashSet<>();
    private Set<Character> _wrongGuesses = new HashSet<>();
    private int _maxAttempts = 4;
    private int _attempts = 0;

    public HangmanGame(WordProvider provider, Difficulty difficulty){
        this._wordToGuess = provider.getRandomWord(difficulty);
    }

    public String getWord(){
        return this._wordToGuess;
    }

    public boolean guessLetter(char letter) {
        letter = Character.toLowerCase(letter);

        // Avoid repeated guesses
        if (_correctGuesses.contains(letter) || _wrongGuesses.contains(letter)) {
            return false;
        }

        if (_wordToGuess.toLowerCase().indexOf(letter) >= 0) {
            _correctGuesses.add(letter);
            return true; // Correct guess
        } else {
            _wrongGuesses.add(letter);
            _attempts++;
            return false; // Failed guess increase attemts
        }
    }

    public boolean isGameWon(){
        for (char c : _wordToGuess.toLowerCase().toCharArray()) {
            if (!_correctGuesses.contains(c)) {
                return false;
            }
        }
        return true;
    }

    public boolean isGameOver(){
        if (_attempts >= _maxAttempts) {
            return true;
        } else {
            return false;
        }
    }

    public String getMaskedWord() {
        // Replace _ with the letter if guessed correct.

        StringBuilder masked = new StringBuilder();

        for (char c : _wordToGuess.toCharArray()) {
            if (_correctGuesses.contains(c)) {
                masked.append(c).append(' ');
            } else {
                masked.append("_ ");
            }
        }
        return masked.toString();
    }

    public int getRemainingAttemps() {
        return _maxAttempts - _attempts;
    }

    public int getWrongGuessCount() {
        return this._wrongGuesses.size();
    }
}
