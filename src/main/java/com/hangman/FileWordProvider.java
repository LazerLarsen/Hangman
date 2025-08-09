package com.hangman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class FileWordProvider implements WordProvider {

    private List<String> words;
    private Random random = new Random();

    /*public FileWordProvider(String filePath){
        try {
            words = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    public FileWordProvider(String resourceName) {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(resourceName)) {
            if (inputStream == null) {
                throw new IllegalStateException(resourceName + " not found in resources folder!");
            }
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                words = reader.lines()
                              .map(String::trim)
                              .filter(line -> !line.isEmpty())
                              .collect(Collectors.toList());
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to load words from " + resourceName, e);
        }
    }

    @Override
    public String getRandomWord(Difficulty difficulty){
        List<String> filtered = new ArrayList();
        for (String w : words){
            if (difficulty == Difficulty.EASY && w.length() <= 4) {
                filtered.add(w);
            } else if (difficulty == Difficulty.MEDIUM && w.length() > 4 && w.length() <= 7) {
                filtered.add(w);
            } else if (difficulty == Difficulty.HARD && w.length() > 7) {
                filtered.add(w);
            }
        }
        return filtered.get(random.nextInt(filtered.size()));
    }
}
