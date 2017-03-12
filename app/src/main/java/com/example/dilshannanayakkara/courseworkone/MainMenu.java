package com.example.dilshannanayakkara.courseworkone;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context context = this;

        button1();
        button2();
        button4();
        button3(context);
    }
    public void button1(){
        Button button1 = (Button) findViewById(R.id.NewGameButton);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenu.this, Difficulty.class));

            }
        });
    }

    GameData gameData = new GameData();
    public void button2(){
        Button button2 = (Button) findViewById(R.id.ContinueButton);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameData.setCont(true);
                startActivity(new Intent(MainMenu.this, GamePlay.class));

            }
        });
    }

    public void button3(final Context context){
        Button button3 = (Button) findViewById(R.id.HelpButton);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
                builder1.setMessage("This Game will help you test your IQ level!!\n" +
                        "You will be given a series of mathematical questions.\n" +
                        "The faster you answer with the correct answer the more chance of your score being higher:)\n"+
                        "Click # after typing the answer and at the end the score will be shown.\n " +
                        "GOOD LUCK!!");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                builder1.setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();




            }
        });
    }

    public void button4(){
        Button button4 = (Button) findViewById(R.id.ExitButton);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
