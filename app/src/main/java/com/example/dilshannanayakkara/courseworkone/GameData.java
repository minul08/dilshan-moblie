package com.example.dilshannanayakkara.courseworkone;

import android.app.Activity;

/**
 * Created by Dilshan Nanayakkara on 12/03/2017.
 */

public class GameData  {
    public static int id;
    public static String difficulty_level;
    public static int score;
    public static boolean hintMode;
    public static int numOfHints;
    public static int numberOfQuestions;

    public static boolean isCont() {
        return cont;
    }

    public static void setCont(boolean cont) {
        GameData.cont = cont;
    }

    public static boolean cont;

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        GameData.id = id;
    }

    public static String getDifficulty_level() {
        return difficulty_level;
    }

    public static void setDifficulty_level(String difficulty_level) {
        GameData.difficulty_level = difficulty_level;
    }

    public static int getScore() {
        return score;
    }

    public static void setScore(int score) {
        GameData.score = score;
    }

    public static boolean isHintMode() {
        return hintMode;
    }

    public static void setHintMode(boolean hintMode) {
        GameData.hintMode = hintMode;
    }

    public static int getNumOfHints() {
        return numOfHints;
    }

    public static void setNumOfHints(int numOfHints) {
        GameData.numOfHints = numOfHints;
    }

    public static int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public static void setNumberOfQuestions(int numberOfQuestions) {
        GameData.numberOfQuestions = numberOfQuestions;
    }

}
