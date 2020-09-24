package com.example.manishrchandran.AndroidApp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Security extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "MyPrefs" ;
    Button b, a;
    EditText newPass, cNewPass, answer;
    Spinner spinnerQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.security);
        b = (Button) findViewById(R.id.btnChangePass);
        a=(Button)findViewById(R.id.btnChangeQ);
        newPass=(EditText)findViewById(R.id.newPass);
        cNewPass=(EditText)findViewById(R.id.cNewPass);
        answer=(EditText)findViewById(R.id.answer);

        spinnerQ = (Spinner) findViewById(R.id.chooseQ);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Questions, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerQ.setAdapter(adapter);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newPassword = newPass.getText().toString();
                String confirmPassword = newPass.getText().toString();
                if (newPassword.equals(confirmPassword)) {

                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString("Password", newPassword);
                    boolean status = editor.commit();
                    //sharedpreferences.getString("Password", null)
                    if (status) {
                        Toast.makeText(Security.this, "Password Changed", Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(Security.this, "Error! \n Unable to change password!", Toast.LENGTH_LONG).show();
                    }
                }
                else
                {
                    Toast.makeText(Security.this,"Passwords doesn't match!",Toast.LENGTH_LONG).show();
                }
            }
        });

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newAnswer = answer.getText().toString();
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString("Answer", newAnswer);
                editor.putString("Question", String.valueOf(spinnerQ.getSelectedItem()));
                boolean status = editor.commit();
                if (status) {
                        Toast.makeText(Security.this, "Data saved", Toast.LENGTH_LONG).show();
                }
                else{
                        Toast.makeText(Security.this, "Error! \n Unable to save data!", Toast.LENGTH_LONG).show();
                    }
                }


        });
    }

    @Override
    public void onBackPressed() {
        Intent j = new Intent(Security.this, MainMenu.class);
        startActivity(j);
    }
}
