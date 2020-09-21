package com.example.teamatom.symbiote;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);




        LinearLayout first = (LinearLayout )findViewById(R.id.first);
        first.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(MainActivity2.this, enterAct.class);
                startActivity(j);
            }
        });

        LinearLayout second = (LinearLayout )findViewById(R.id.second);
        second.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(MainActivity2.this, enterAct.class);
                startActivity(j);
            }
        });


        LinearLayout third = (LinearLayout )findViewById(R.id.third);
        third.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(MainActivity2.this, enterAct.class);
                startActivity(j);
            }
        });


        LinearLayout fourth = (LinearLayout )findViewById(R.id.fourth);
        fourth.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(MainActivity2.this, reset_pin.class);
                startActivity(j);
            }
        });


        LinearLayout fifth = (LinearLayout )findViewById(R.id.fifth);
        fifth.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(MainActivity2.this, enterAct.class);
                startActivity(j);
            }
        });


        LinearLayout sixth = (LinearLayout )findViewById(R.id.sixth);
        sixth.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(MainActivity2.this, enterAct.class);
                startActivity(j);
            }
        });




    }
}