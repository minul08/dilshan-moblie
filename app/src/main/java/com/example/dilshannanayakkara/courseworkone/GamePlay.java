package com.example.dilshannanayakkara.courseworkone;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by Dilshan Nanayakkara on 12/03/2017.
 */

public class GamePlay extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_play);
    }

    public CountDownTimer time;
    GameData gameData = new GameData();
    String question;
    TextView qa = (TextView) findViewById(R.id.txtQuestion);
    TextView text = (TextView) this.findViewById(R.id.secs);
    public int amount = 11;

    public void difLevelChecker() {
        gameData.numOfHints = 4;
        //hintMode();
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
        //text = (TextView) this.findViewById(R.id.sec);
        //timeElapsedView = (TextView) this.findViewById(R.id.timeRemaining);

        time = new CountDownTimer(10000, 1000) {

            public void onTick(long millisUntilFinished) {
                text.setText("" + millisUntilFinished / 1000);

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
        //answer = ans;
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

//    public void answerGuiRespond() {
//        responce = (TextView) findViewById(R.id.responce);
//        String[] text = qa.getText().toString().split("=");
//        System.out.println("Split: " + text[0]);
//
//        if(text.length>1) {
//            if ((Integer.valueOf(text[1]) == answer)) {
//                WordtoSpan = new SpannableString("CORRECT");
//                WordtoSpan.setSpan(new ForegroundColorSpan(Color.GREEN), 0, 7, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//                responce.setText(WordtoSpan);
//
//                Delay();
//                time.cancel();
//                pointCalc();
//
//                if (gameData.isHintMode()) {
//                    if (gameData.numberOfQuestions < amount) {
//                        gameData.numOfHints = 4;
//                        hintMode();
//                        difLevelChecker();
//                    } else {
//                        time.cancel();
//                        scoreDialogBox();
//                    }
//                } else {
//                    if (gameData.numberOfQuestions < amount) {
//                        difLevelChecker();
//                    } else {
//                        time.cancel();
//                        scoreDialogBox();
//                    }
//                }
//
//            } else {
//                wrongProceed(Integer.valueOf(text[1]));
//            }
//        }else{
//            wrongProceed(Integer.valueOf(text[1]));
//        }
//    }
}
