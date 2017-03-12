package com.example.dilshannanayakkara.courseworkone;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.ViewFlipper;

/**
 * Created by Dilshan Nanayakkara on 12/03/2017.
 */

public class Difficulty extends Activity{

    public GameData gameData;

    ViewFlipper flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.difficulty);
        startNewGame();
        //switchControl();

    }

    public void startNewGame(){

        Button startNewGame = (Button) findViewById(R.id.NewGameButton);

        final RadioButton difficultyNovice = (RadioButton) findViewById(R.id.radioButtonNovice);
        gameData = new GameData();
        if (difficultyNovice.isChecked()){
            gameData.setdifficultyLevel("novice");
        }

        final RadioButton difficultyNovice = (RadioButton) findViewById(R.id.radioButtonNovice);
        final RadioButton difficultyEasy = (RadioButton) findViewById(R.id.radioButtonEasy);
        final RadioButton difficultyMedium = (RadioButton) findViewById(R.id.radioButtonMedium);
        final RadioButton difficultyGuru = (RadioButton) findViewById(R.id.radioButtonGuru);
        //String radioText = "";


    }
}
