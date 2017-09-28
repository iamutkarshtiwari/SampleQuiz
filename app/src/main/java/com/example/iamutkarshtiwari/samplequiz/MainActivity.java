package com.example.iamutkarshtiwari.samplequiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button submit;
    int correctAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = (Button) findViewById(R.id.submitButton);
        submit.setOnClickListener(this);
    }

    /**
     * Question 1 evaluation
     */
    private void checkQuestionOneAnswers(){
        CheckBox questionOneMario = (CheckBox) findViewById(R.id.checkboxQuest1AnswerMario);
        CheckBox questionOneDonkey = (CheckBox) findViewById(R.id.checkboxQuest1AnswerDonkey);
        CheckBox questionOnePortal = (CheckBox) findViewById(R.id.checkboxQuest1AnswerPortal);
        boolean isQuestionOneMarioChecked = questionOneMario.isChecked();
        boolean isQuestionOneDonkeyChecked = questionOneDonkey.isChecked();
        boolean isQuestionOnePortalChecked = questionOnePortal.isChecked();

        if (isQuestionOneMarioChecked && isQuestionOneDonkeyChecked && !isQuestionOnePortalChecked){
            correctAnswers += 1;
        }
    }

    /**
     * Question 2 evaluation
     */
    private void checkQuestionTwoAnswers(){
        RadioButton radioButton1989 = (RadioButton) findViewById(R.id.radio_1989);
        boolean isQuestionTwo1989Checked = radioButton1989.isChecked();
        if (isQuestionTwo1989Checked){
            correctAnswers += 1;
        }
    }

    /**
     * Fetches answer entered by user
     * @return
     */
    private String getQuestionThreeUserInput() {
        EditText userInputLastName = (EditText) findViewById(R.id.answerInputUserLastName);
        String name = userInputLastName.getText().toString();
        return name;
    }

    /**
     * Question 3 evaluation
     */
    private void checkQuestionThreeAnswer(){
        String name = getQuestionThreeUserInput();
        if (name.trim().equalsIgnoreCase("croft")){
            correctAnswers += 1;
        }
    }

    /**
     * Question 4 evaluation
     */
    private void checkQuestionFourAnswers(){
        RadioButton radioButtonPortal = (RadioButton) findViewById(R.id.radio_portal);
        boolean isQuestionTwoPortalChecked = radioButtonPortal.isChecked();
        if (isQuestionTwoPortalChecked){
            correctAnswers += 1;
        }
    }

    /**
     * Question 5 evaluation
     */
    private void checkQuestionFiveAnswers(){
        CheckBox questionFiveGameBoy = (CheckBox) findViewById(R.id.checkboxQuest5GameBoy);
        CheckBox questionFivePSP = (CheckBox) findViewById(R.id.checkboxQuestPSP);
        CheckBox questionFiveWii = (CheckBox) findViewById(R.id.checkboxQuest5Wii);
        boolean isQuestionFiveGameBoyChecked = questionFiveGameBoy.isChecked();
        boolean isQuestionFivePSPChecked = questionFivePSP.isChecked();
        boolean isQuestionFiveWiiChecked = questionFiveWii.isChecked();

        if (isQuestionFiveGameBoyChecked && !isQuestionFivePSPChecked && isQuestionFiveWiiChecked){
            correctAnswers += 1;
        }
    }

    /**
     * Check all questions one by one
     */
    private void checkAllQuestions(){
        checkQuestionOneAnswers();
        checkQuestionTwoAnswers();
        checkQuestionThreeAnswer();
        checkQuestionFourAnswers();
        checkQuestionFiveAnswers();
    }

    /**
     * Resets counter value
     */
    private void resetCounterCorrectAnswers(){
        correctAnswers = 0;
    }

    /**
     * On click listener for this activity
     * @param view
     */
    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.submitButton) {
            checkAllQuestions();
            Toast.makeText(MainActivity.this, getStringFromID(R.string.correct_answer) + correctAnswers + getStringFromID(R.string.by_5),
                    Toast.LENGTH_LONG).show();
            resetCounterCorrectAnswers();}

    }

    /**
     * Gets string from res ID
     * @param id res id
     * @return string value
     */
    private String getStringFromID(int id) {
        return getResources().getString(id);
    }

}