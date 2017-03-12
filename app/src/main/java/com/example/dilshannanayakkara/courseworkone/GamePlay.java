package com.example.dilshannanayakkara.courseworkone;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

/**
 * Created by Dilshan Nanayakkara on 12/03/2017.
 */

public class GamePlay extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_play);
        secondsRemaning = (TextView) this.findViewById(R.id.secs);
        qa = (TextView) findViewById(R.id.txtQuestion);
        txtAnswer = (TextView) findViewById(R.id.txtAnswer);
        hint = (TextView) findViewById(R.id.txtHint);
        difLevelChecker();
        button0();
        button1();
        button2();
        button3();
        button4();
        button5();
        button6();
        button7();
        button8();
        button9();
        buttonMinus();
        buttonHash();
        hintMode();
    }

    public CountDownTimer time;
    GameData gameData = new GameData();
    String question;
    TextView qa;
    TextView secondsRemaning;
    TextView responce;
    TextView txtAnswer;
    TextView hint;
    int answer = 0;
    public int amount = 11;
    public Spannable responceText;

    public void difLevelChecker() {
        gameData.setNumOfHints(4);
        //hintMode();
        System.out.println("Difficulty level: "+gameData.getDifficulty_level());
        if (gameData.getDifficulty_level().equalsIgnoreCase("easy")) {
            questionGenEasy();
        }

        if (gameData.getDifficulty_level().equalsIgnoreCase("novice")) {
            questionGenNovice();
        }

        if (gameData.getDifficulty_level().equalsIgnoreCase("medium")) {
            questionGenMedium();
        }

        if (gameData.getDifficulty_level().equalsIgnoreCase("guru")) {
            questionGenGuru();
        }
    }

//TIMER
    public void timer() {
        time = new CountDownTimer(10000, 1000) {

            public void onTick(long millisUntilFinished) {
                secondsRemaning.setText("" + millisUntilFinished / 1000);

            }

            public void onFinish() {
                if (gameData.getNumberOfQuestions() > amount) {
                    time.cancel();
                    //scoreDialogBox();
                } else {
                    difLevelChecker();
                }
            }

        }.start();
    }

    public void Delay() {
        new CountDownTimer(1000, 1000) {
            TextView responce = (TextView) findViewById(R.id.responseTextView);

            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                //responce.setText("Time Remaining");
                //secs.setText("Seconds");
            }
        }.start();
    }

//GENERATORS
    public int numberGen() {
        Random rand = new Random();
        int randomNum = rand.nextInt((9 - 1) + 1) + 1;
        return randomNum;
    }

    public String signGen() {
        Random rand = new Random();
        int operator = rand.nextInt((4 - 1) + 1) + 1;
        String sign = null;
        switch (operator) {

            case 1:
                sign = "+";
                break;
            case 2:
                sign = "-";
                break;
            case 3:
                sign = "*";
                break;
            case 4:
                sign = "/";
                break;
        }
        return sign;
    }

    public String genSignNum() {
        String set = null;
        set = signGen();
        set = set + Integer.toString(numberGen());
        return set;
    }

    //GAME PLAY
    public void answerCheck(String Question) {
        int ans = 0;
        ans = (int) Question.charAt(0) - 48;
        System.out.println("Question is: " + Question);
        for (int i = 1; i <= Question.length(); i++) {
            String character = "*";
            int questionSign = Question.charAt(i);
            int checker = character.charAt(0);
            if (questionSign == checker) {
                ans = ans * (int) (Question.charAt(i + 1) - 48);
            }
            character = "/";
            questionSign = Question.charAt(i);
            checker = character.charAt(0);
            if (questionSign == checker) {
                ans = ans / (int) (Question.charAt(i + 1) - 48);
            }
            character = "+";
            questionSign = Question.charAt(i);
            checker = character.charAt(0);
            if (questionSign == checker) {
                ans = ans + (int) (Question.charAt(i + 1) - 48);
            }
            character = "-";
            questionSign = Question.charAt(i);
            checker = character.charAt(0);
            if (questionSign == checker) {
                ans = ans - (int) (Question.charAt(i + 1) - 48);
            }
            i++;
            System.out.println("Answer is: " + ans);
        }
        answer = ans;
    }

    public void questionGenNovice() {
        question = null;
        question = Integer.toString(numberGen());
        question = question + genSignNum();
        question = question + "=";
        qa.setText(question);
        System.out.println("Question: " + gameData.getNumberOfQuestions());
        answerCheck(question);
        timer();
        gameData.setNumberOfQuestions(gameData.getNumberOfQuestions() + 1);
    }

    public void questionGenEasy() {
        question = null;
        question = Integer.toString(numberGen());
        question = question + genSignNum();
        question = question + genSignNum();
        question = question + "=";
        qa.setText(question);
        System.out.println("Question: " + gameData.getNumberOfQuestions());
        answerCheck(question);
        timer();
        gameData.setNumberOfQuestions(gameData.getNumberOfQuestions() + 1);
    }

    public void questionGenMedium() {
        question = null;
        question = Integer.toString(numberGen());

        for (int i = 0; i < 3; i++) {
            question = question + genSignNum();
        }

        question = question + "=";
        qa.setText(question);
        System.out.println("Question: " + gameData.getNumberOfQuestions());
        answerCheck(question);
        timer();
        gameData.setNumberOfQuestions(gameData.getNumberOfQuestions() + 1);
    }

    public void questionGenGuru() {
        question = null;
        question = Integer.toString(numberGen());

        for (int i = 0; i < 4; i++) {
            question = question + genSignNum();
        }

        question = question + "=";
        qa.setText(question);
        answerCheck(question);
        System.out.println("Question: " + gameData.getNumberOfQuestions());
        timer();
        gameData.setNumberOfQuestions(gameData.getNumberOfQuestions() + 1);
    }
    String userAnswer=null;
    public void answerGuiRespond() {
        responce = (TextView) findViewById(R.id.responseTextView);
        userAnswer = txtAnswer.getText().toString();
        txtAnswer.setText("");
        System.out.println("-------------------RESPONCE-----------------");

        if(!userAnswer.isEmpty()) {
            if ((Integer.valueOf(userAnswer) == answer)) {
                responceText = new SpannableString("CORRECT");
                responceText.setSpan(new ForegroundColorSpan(Color.GREEN), 0, 7, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                responce.setText(responceText);

/////////////////////////////                Delay();
                time.cancel();
                pointCalc();

                if (gameData.isHintMode()) {
                    if (gameData.numberOfQuestions < amount) {
                        gameData.numOfHints = 4;
                        //hintMode();
                        difLevelChecker();
                    } else {
                        time.cancel();
                        scoreDialogBox();
                    }
                } else {
                    if (gameData.numberOfQuestions < amount) {
                        difLevelChecker();
                    } else {
                        time.cancel();
                        scoreDialogBox();
                    }
                }
            } else {
                wrongProceed();
            }
        }else{
            wrongProceed();
        }
    }


    public void wrongProceed(){
        responceText = new SpannableString("WRONG");
        responceText.setSpan(new ForegroundColorSpan(Color.RED), 0, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        responce.setText(responceText);

       // Delay();

        if (gameData.isHintMode()) {

            if (gameData.numberOfQuestions < amount) {
                if((gameData.numOfHints<=4)&&(gameData.numOfHints>1)){
                    gameData.numOfHints--;
                    compare();
                    hintMode();
                }else{
                    time.cancel();
                    gameData.numOfHints = 4;
                    //hintMode();
                    difLevelChecker();
                }

            } else {
                scoreDialogBox();
            }

        } else {

            if (gameData.numberOfQuestions < amount) {
                time.cancel();
                difLevelChecker();
            } else {
                time.cancel();
                scoreDialogBox();

            }
        }
    }
//POINT CALCULATION
public void pointCalc() {
    TextView secsLeft = (TextView) findViewById(R.id.secs);
    int denominator = 10 - Integer.valueOf((String) secsLeft.getText());
    gameData.setScore(gameData.getScore()+(100 / denominator));
    System.out.println("------------CALCULATED SCORE--------------- " + gameData.getScore());
    System.out.println("------------Score update: " + gameData.getScore());
}

//BUTTONS
public void button1() {
    Button b1 = (Button) findViewById(R.id.no1);
    b1.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            txtAnswer.setText(txtAnswer.getText() + "1");
        }
    });

}

    public void button2() {
        Button b2 = (Button) findViewById(R.id.no2);
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                txtAnswer.setText(txtAnswer.getText() + "2");
            }
        });
    }


    public void button3() {
        Button b3 = (Button) findViewById(R.id.no3);
        b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                txtAnswer.setText(txtAnswer.getText() + "3");
            }
        });
    }


    public void button4() {
        Button b4 = (Button) findViewById(R.id.no4);
        b4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                txtAnswer.setText(txtAnswer.getText() + "4");
            }
        });
    }


    public void button5() {
        Button b5 = (Button) findViewById(R.id.no5);
        b5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                txtAnswer.setText(txtAnswer.getText() + "5");
            }
        });
    }


    public void button6() {
        Button b6 = (Button) findViewById(R.id.no6);
        b6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                txtAnswer.setText(txtAnswer.getText() + "6");
            }
        });
    }


    public void button7() {
        Button b7 = (Button) findViewById(R.id.no7);
        b7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                txtAnswer.setText(txtAnswer.getText() + "7");
            }
        });
    }


    public void button8() {
        Button b8 = (Button) findViewById(R.id.no8);
        b8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                txtAnswer.setText(txtAnswer.getText() + "8");
            }
        });
    }


    public void button9() {
        Button b9 = (Button) findViewById(R.id.no9);
        b9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                txtAnswer.setText(txtAnswer.getText() + "9");
            }
        });
    }


    public void button0() {
        Button b0 = (Button) findViewById(R.id.no0);
        b0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                txtAnswer.setText(txtAnswer.getText() + "0");
            }
        });
    }

    public void buttonMinus() {
        Button bminus = (Button) findViewById(R.id.minusButton);
        bminus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                txtAnswer.setText(txtAnswer.getText() + "-");
            }
        });
    }

    public void buttonHash() {
        Button hash = (Button) findViewById(R.id.hashButton);
        hash.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                answerGuiRespond();

            }
        });
    }

    public void scoreDialogBox() {

        Context context = this;
        AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
        builder1.setMessage("Your Score is " + gameData.getScore() + "\n" + "Do you want to play again?");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //dialogBox = false;
                        dialog.cancel();
                        startActivity(new Intent(getApplicationContext(), MainMenu.class));
                    }
                });

        builder1.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // dialogBox = false;
                        dialog.cancel();
                        startActivity(new Intent(getApplicationContext(), MainMenu.class));
                    }
                });
        time.cancel();
        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

//HINT MODE
    public void compare(){
        if((Integer.parseInt(userAnswer))>answer){
            hint.setText("Less");
            Delay();
        }else{
            hint.setText("Greater");
            Delay();
        }
    }

    public void hintMode() {
        TextView hint = (TextView) findViewById(R.id.tries_remaining);
        if (gameData.isHintMode()) {
            qa.setText(question);
            hint.setText(gameData.getNumOfHints() + "");
        } else {
            RelativeLayout mainLayout = (RelativeLayout) this.findViewById(R.id.hintMode);
            mainLayout.setVisibility(LinearLayout.GONE);
        }
    }

}
