package com.example.manishrchandran.AndroidApp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.database.Cursor;
import android.widget.TextView;


public class AnalyseActivity extends AppCompatActivity {

    Button viewButton, delButton;
    TextView dataView;
    DatabaseHelper myDb;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.analyse_activity);
        viewButton = (Button)findViewById(R.id.btnAnalyse);
        delButton = (Button)findViewById(R.id.btnDelete);
        dataView = (TextView)findViewById(R.id.filteredView);
        myDb = new DatabaseHelper(this);

       viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor result = myDb.getAllData();
                if (result.getCount() == 0) {
                    showMessage("Error","Nothing found");

                }
                else
                {
                    StringBuffer buffer = new StringBuffer();
                    while (result.moveToNext())
                    {
                        buffer.append("Category : " + result.getString(1) + "\n");
                        buffer.append("Activity : " + result.getString(2) + "\n");
                        buffer.append("Date : " + result.getString(3) + "\n");
                        buffer.append("Description : " + result.getString(4) + "\n");
                        buffer.append("Time : " + result.getString(5) + "\n");
                        buffer.append("Duration : " + result.getString(6) + "\n\n");
                        dataView.setText(buffer.toString());
                    }

                }

            }
        });

        delButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDb.deleteData();
                dataView.setText("No entries Found");
            }
        } );
}

    public void showMessage (String title, String Message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        final Intent j = new Intent(AnalyseActivity.this, MainMenu.class);
        builder.show();

    }
}
