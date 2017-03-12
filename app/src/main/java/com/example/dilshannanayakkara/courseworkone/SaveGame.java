package com.example.dilshannanayakkara.courseworkone;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Minul on 3/12/2017.
 */

public class SaveGame {

    private static final String PREFS_NAME = "com.our.package.Save_Retrieve_Game_Data";
    private static SharedPreferences settings;
    private static SharedPreferences.Editor editor;

    public SaveGame(Context ctx){
        if(settings == null){
            settings = ctx.getSharedPreferences(PREFS_NAME,
                    Context.MODE_PRIVATE );
        }

        editor = settings.edit();
    }

    public static final String KEY_PREFIX =
            "com.our.package.KEY";

    private String getFieldKey(int id, String fieldKey) {
        return  KEY_PREFIX + id + "_" + fieldKey;
    }

    private static final String KEY_DIFFICULTY = "com.our.package.KEY_DIFFICULTY";
    private static final String KEY_NUMBEROFHINTS = "com.our.package.KEY_DIFFICULTYLEVEL";
    private static final String KEY_NUMBEROFQUESTIONS = "com.our.package.KEY_DIFFICULTYLEVEL";
    private static final String KEY_HINTMODE = "com.our.package.KEY_REGISTERED";
    private static final String KEY_SCORE = "com.our.package.KEY_SCORE";

    public void saveGameData(GameData gameDataSave){
        int id = gameDataSave.getId();
        System.out.println("Difficulty Level: " + gameDataSave.getDifficulty_level());
        System.out.println("ID: " + gameDataSave.getId());
        System.out.println("Score is: " + gameDataSave.getScore());
        System.out.println("Hint Mode: " + gameDataSave.isHintMode());
        System.out.println("Number of hints is: " + gameDataSave.getNumOfHints());
        System.out.println("Number of Questions is: " + gameDataSave.getNumberOfQuestions());
        System.out.println("Game Saved");


        System.out.println(getFieldKey(id, KEY_DIFFICULTY)+ gameDataSave.getDifficulty_level());

        editor.putString(getFieldKey(id, KEY_DIFFICULTY), gameDataSave.getDifficulty_level());
        editor.putInt(getFieldKey(id, KEY_SCORE), gameDataSave.getScore());
        editor.putBoolean(getFieldKey(id, KEY_HINTMODE), gameDataSave.isHintMode());
        editor.putInt(getFieldKey(id, KEY_NUMBEROFHINTS), gameDataSave.getNumOfHints());
        editor.putInt(getFieldKey(id, KEY_NUMBEROFQUESTIONS), gameDataSave.getNumberOfQuestions());
        editor.commit();
    }


    public void retGameData(int id) {

        String diffLevel = settings.getString(getFieldKey(id, KEY_DIFFICULTY), "");
        int score = settings.getInt(getFieldKey(id, KEY_SCORE), 0);
        boolean hintMode = settings.getBoolean(getFieldKey(id, KEY_HINTMODE), true);
        int numberOfHints = settings.getInt(getFieldKey(id, KEY_NUMBEROFHINTS), 0);
        int numberOfQuestions = settings.getInt(getFieldKey(id, KEY_NUMBEROFQUESTIONS), 0);

        GameData gameData = new GameData();
        gameData.setDifficulty_level(diffLevel);
        gameData.setScore(score);
        gameData.setHintMode(hintMode);
        gameData.setNumOfHints(numberOfHints);
        gameData.setNumberOfQuestions(numberOfQuestions);

        System.out.println("Difficulty Level: " + diffLevel);
        System.out.println("Score is: "+score);
        System.out.println("Hint Mode: "+hintMode);
        System.out.println("Number of hints is: "+numberOfHints);
        System.out.println("Number of Questions is: "+numberOfQuestions);
    }

}
