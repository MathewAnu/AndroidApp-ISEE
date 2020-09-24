package com.example.activitymanager.AndroidApp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;



public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);




        RelativeLayout first = (RelativeLayout)findViewById(R.id.first);
        first.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(MainMenu.this, EnterActivity.class);
                startActivity(j);
            }
        });

        RelativeLayout second = (RelativeLayout )findViewById(R.id.second);
        second.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(MainMenu.this, ViewAllEntries.class);
                startActivity(j);
            }
        });


        RelativeLayout third = (RelativeLayout )findViewById(R.id.third);
        third.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(MainMenu.this, AnalyseActivity.class);
                startActivity(j);
            }
        });


        RelativeLayout fourth = (RelativeLayout )findViewById(R.id.fourth);
        fourth.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(MainMenu.this, ExportData.class);
                startActivity(j);
            }
        });


        RelativeLayout fifth = (RelativeLayout )findViewById(R.id.fifth);
        fifth.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(MainMenu.this, Security.class);
                startActivity(j);
            }
        });


        RelativeLayout sixth = (RelativeLayout )findViewById(R.id.sixth);
        sixth.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(MainMenu.this, SendFeedback.class);
                startActivity(j);
            }
        });

    }

    @Override
    public void onBackPressed(){
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }
}
