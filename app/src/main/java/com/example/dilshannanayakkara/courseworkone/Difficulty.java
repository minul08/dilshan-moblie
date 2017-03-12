package com.example.dilshannanayakkara.courseworkone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.Toast;
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
        switchControl();

    }

    public void startNewGame(){

        Button startNewGame = (Button) findViewById(R.id.start_game);
        gameData = new GameData();

        final RadioButton difficultyNovice = (RadioButton) findViewById(R.id.radioButtonNovice);
        final RadioButton difficultyEasy = (RadioButton) findViewById(R.id.radioButtonEasy);
        final RadioButton difficultyMedium = (RadioButton) findViewById(R.id.radioButtonMedium);
        final RadioButton difficultyGuru = (RadioButton) findViewById(R.id.radioButtonGuru);
        //String radioText = "";
        startNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                gameData = new GameData();

                if (difficultyNovice.isChecked()) {
                    gameData.setDifficulty_level("novice");
                }
                if (difficultyEasy.isChecked()) {
                    gameData.setDifficulty_level("easy");
                }
                if (difficultyMedium.isChecked()) {
                    gameData.setDifficulty_level("medium");
                }
                if (difficultyGuru.isChecked()) {
                    gameData.setDifficulty_level("guru");
                }
                startActivity(new Intent(Difficulty.this, GamePlay.class));

            }
        });
    }

    public void switchControl(){
        gameData.setNumOfHints(4);
        Switch hintSwitch = (Switch) findViewById(R.id.hintSwitch);

        hintSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    gameData.setHintMode(true);
                   Toast.makeText(getApplicationContext(), "Hint Mode ON", Toast.LENGTH_LONG).show();
                } else {
                    gameData.setHintMode(false);
                   Toast.makeText(getApplicationContext(), "Hint Mode OFF", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}




