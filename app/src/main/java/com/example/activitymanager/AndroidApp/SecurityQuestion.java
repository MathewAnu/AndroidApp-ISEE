package com.example.activitymanager.AndroidApp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecurityQuestion extends AppCompatActivity {

    public static final String MyPREFERENCES = "MyPrefs";
    SharedPreferences sharedpreferences;
    String Question;
    String Answer, ipAnswer;
    TextView q;
    EditText a;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.security_question);
        q = (TextView) findViewById(R.id.txtQ);
        a = (EditText) findViewById(R.id.txtA);
        b = (Button) findViewById(R.id.btnSubmit);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        if (sharedpreferences.contains("Question")&&sharedpreferences.contains("Answer")) {
            Question = sharedpreferences.getString("Question", null);
            Answer = sharedpreferences.getString("Answer", null);
        } else {
            Question = "Is the initial Password 0000?(yes/no)";
            Answer = "yes";
        }

        q.setText(Question);
        b.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ipAnswer = a.getText().toString();
                        if (Answer.equals(ipAnswer)) {
                            Toast.makeText(SecurityQuestion.this, "Answer is correct", Toast.LENGTH_LONG).show();
                            Intent j = new Intent(SecurityQuestion.this, Security.class);
                            startActivity(j);
                        }
                        else
                        {
                            Toast.makeText(SecurityQuestion.this, "Answer is wrong! \n Closing the App!", Toast.LENGTH_LONG).show();
                            Intent a = new Intent(Intent.ACTION_MAIN);
                            a.addCategory(Intent.CATEGORY_HOME);
                            a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(a);
                        }
                        }


                });
    }
}
