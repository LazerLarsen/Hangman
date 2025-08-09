package com.hangman;

public class HangmanStages {
    public static final String[] STAGES = {
        // Stage 0: Only hanger
        """
         +---+
         |   |
             |
             |
             |
             |
        =========
        """,

        // Stage 1: Head
        """
         +---+
         |   |
         O   |
             |
             |
             |
        =========
        """,

        // Stage 2: Head + Body
        """
         +---+
         |   |
         O   |
         |   |
             |
             |
        =========
        """,

        // Stage 3: Head + Body + 1 Leg
        """
         +---+
         |   |
         O   |
         |   |
        / \\  |
             |
        =========
        """,

        // Stage 4: Head + Body + 2 Legs
        """
         +---+
         |   |
         O   |
        /|\\  |
        / \\  |
             |
        =========
        """
    };
}
