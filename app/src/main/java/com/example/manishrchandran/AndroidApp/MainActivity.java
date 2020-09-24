package com.example.manishrchandran.AndroidApp;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.app.AlertDialog.Builder;
import android.widget.Toast;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public Button proceed;
    public EditText password;
    private TextView Info;
    private int counter = 5;
    public String pass_result;
    public Boolean PinState;
    public String initialPass;
    public String savedPass;
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        final String initialPass= new String("0000");

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        if(sharedpreferences.contains("Password")) {
            savedPass = sharedpreferences.getString("Password", null);
        }
        else
        {
            savedPass = initialPass;
        }
        PinState=false; //PIN state from database
        proceed = (Button) findViewById(R.id.proceedNext);
        password = (EditText) findViewById(R.id.pass);
        Info = (TextView)findViewById(R.id.textView2);
        pass_result = password.getText().toString();
        Info.setText("No of attempts remaining: 5");

        proceed.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
            if (password.getText().toString().equals(savedPass)&&counter>=0)
            {
                Intent j = new Intent(MainActivity.this, MainMenu.class);
                    startActivity(j);
            }
            else if (!(password.getText().toString().equals(savedPass))&&counter>0)
            {

             AlertDialog alertDialog = new Builder(
                    MainActivity.this).create();
            alertDialog.setTitle("Wrong Password!");
            alertDialog.setButton("Ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(), String.valueOf(counter)+" Attempts left! ", Toast.LENGTH_SHORT).show();
                }
            });
            alertDialog.show();
                counter--;
        Info.setText("No of attempts remaining: " + String.valueOf(counter));
        }
         else
          {
              AlertDialog alertDialog = new Builder(
                    MainActivity.this).create();
                alertDialog.setTitle("Wrong Password!");
                alertDialog.setMessage("No attempts left");
                alertDialog.setButton("Reset password", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent j = new Intent(MainActivity.this, SecurityQuestion.class);
                        startActivity(j);
                    }
                });
                alertDialog.show();
          }
                }
            });
    }

}