package com.example.manishrchandran.AndroidApp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;


public class SendFeedback extends AppCompatActivity {
    EditText TextMessage;
    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_feedback);

        TextMessage= (EditText) findViewById(R.id.txtMsg);

        send=(Button)findViewById(R.id.btnSendFeedback);

        send.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View arg0) {
                String to="anushamathw@gmail.com";
                String subject="User Feedback - TimeTracker";
                String message=TextMessage.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));

            }

        });
    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.send_feedback, menu);
        return true;
    }

 */

}
