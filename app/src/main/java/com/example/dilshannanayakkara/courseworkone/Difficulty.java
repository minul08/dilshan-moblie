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

        Button startNewGame = (Button) findViewById(R.id.NewGameButton);
        final RadioButton difficultyNovice = (RadioButton) findViewById(R.id.radioButtonNovice);
        gameData = new GameData();
        if (difficultyNovice.isChecked()){
            //gameData.setdifficultyLevel("novice");
        }

        //final RadioButton difficultyNovice = (RadioButton) findViewById(R.id.radioButtonNovice);
        final RadioButton difficultyEasy = (RadioButton) findViewById(R.id.radioButtonEasy);
        final RadioButton difficultyMedium = (RadioButton) findViewById(R.id.radioButtonMedium);
        final RadioButton difficultyGuru = (RadioButton) findViewById(R.id.radioButtonGuru);
        //String radioText = "";
        startNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                gameData = new GameData();

                final RadioButton difficultyNovice = (RadioButton) findViewById(R.id.radioButtonNovice);
                if (difficultyNovice.isChecked())

                {
                  gameData.setDifficulty_level("novice");
                }

                final RadioButton difficultyEasy = (RadioButton) findViewById(R.id.radioButtonEasy);
                if (difficultyNovice.isChecked())

                {
                   gameData.setDifficulty_level("easy");
                }

                final RadioButton difficultyMedium = (RadioButton) findViewById(R.id.radioButtonMedium);
                if (difficultyNovice.isChecked())

                {
                    gameData.setDifficulty_level("medium");
                }

                final RadioButton difficultyGuru = (RadioButton) findViewById(R.id.radioButtonGuru);
                if (difficultyNovice.isChecked())

                {
                    gameData.setDifficulty_level("guru");
                }

                startActivity(new Intent(Difficulty.this, GamePlay.class));

            }
        });
    }

    public void switchControl(){
        gameData.setnumberOfHints(4);
        Switch hintSwitch = (Switch) findViewById(R.id.hintSwitch);

        hintSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "Hint Mode ON", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Hint Mode OFF", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}




