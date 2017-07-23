package com.example.android.quizapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int Q1answer = R.id.answer1;
    int Q2answer = R.id.answer2;
    String Q3answer = "Luke Skywalker";
    int Q4answer = R.id.answer4;
    int Q5answer = R.id.answer5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Check the answer is correct or wrong
     */

    private boolean checkQuestion1() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.question1RG);

        if (rg.getCheckedRadioButtonId() == Q1answer) {
            return true;
        }
        return false;
    }

    private boolean checkQuestion2() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.question2RG);

        if (rg.getCheckedRadioButtonId() == Q2answer) {
            return true;
        }
        return false;
    }

    private boolean checkQuestion3() {
        EditText et = (EditText) findViewById(R.id.answer3);

        return et.getText().toString().equalsIgnoreCase(Q3answer);
    }

    private boolean checkQuestion4() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.question4RG);

        if (rg.getCheckedRadioButtonId() == Q4answer) {
            return true;
        }
        return false;
    }

    private boolean checkQuestion5() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.question5RG);

        if (rg.getCheckedRadioButtonId() == Q5answer) {
            return true;
        }
        return false;
    }

    private boolean checkQuestion6() {
        CheckBox c1 = (CheckBox) findViewById(R.id.checkBox1);
        CheckBox c2 = (CheckBox) findViewById(R.id.checkBox2);
        CheckBox c3 = (CheckBox) findViewById(R.id.checkBox3);
        CheckBox c4 = (CheckBox) findViewById(R.id.checkBox4);

        if (c1.isChecked() && c3.isChecked() && !c2.isChecked() && !c4.isChecked()) {
            return true;
        }
        return false;
    }

    /**
     * The quiz scoring processed here
     */

    public void checkQuiz(View v) {
        ArrayList<String> incorrectAnswersList = new ArrayList<String>();

        int numberOfQuestionsCorrect = 0;

        if (checkQuestion1()) {
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add("Question 1");
        }

        if (checkQuestion2()) {
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add("Question 2");
        }

        if (checkQuestion3()) {
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add("Question 3");
        }

        if (checkQuestion4()) {
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add("Question 4");
        }

        if (checkQuestion5()) {
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add("Question 5");
        }

        if (checkQuestion6()) {
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add("Question 6");
        }

        Context context = getApplicationContext();
        CharSequence text = "Your score = " + numberOfQuestionsCorrect + "/6.";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    /**
     * Reset all answer and start again
     */
    public void resetQuiz(View v) {

        EditText resetET = (EditText) findViewById(R.id.answer3);
        resetET.setText("");

        RadioGroup resetRG1 = (RadioGroup) findViewById(R.id.question1RG);
        RadioGroup resetRG2 = (RadioGroup) findViewById(R.id.question2RG);
        RadioGroup resetRG4 = (RadioGroup) findViewById(R.id.question4RG);
        RadioGroup resetRG5 = (RadioGroup) findViewById(R.id.question5RG);

        resetRG1.clearCheck();
        resetRG2.clearCheck();
        resetRG4.clearCheck();
        resetRG5.clearCheck();

        CheckBox resetCB1 = (CheckBox) findViewById(R.id.checkBox1);
        CheckBox resetCB2 = (CheckBox) findViewById(R.id.checkBox2);
        CheckBox resetCB3 = (CheckBox) findViewById(R.id.checkBox3);
        CheckBox resetCB4 = (CheckBox) findViewById(R.id.checkBox4);

        resetCB1.setChecked(false);
        resetCB2.setChecked(false);
        resetCB3.setChecked(false);
        resetCB4.setChecked(false);

    }

}
