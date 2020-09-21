package com.example.manishrchandran.symbiot4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bu2 = (Button)findViewById(R.id.but1);

        bu2.setOnClickListener(
                new Button.OnClickListener() {


                    public void onClick(View v) {

                        Intent j = new Intent(MainActivity.this, Main4Activity.class);
                        startActivity(j);
                    }
                }
        );



                        Button bu1 = (Button)findViewById(R.id.button3);
        bu1.setOnClickListener(
                new Button.OnClickListener(){


                    public void onClick(View v){
                        Intent j = new Intent(MainActivity.this, Main3Activity.class);
                        startActivity(j);



                    }
                }




        );






    }




}
