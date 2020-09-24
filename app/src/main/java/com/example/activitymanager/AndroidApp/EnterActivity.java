package com.example.activitymanager.AndroidApp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;


public class EnterActivity extends AppCompatActivity {

    DatabaseHelper myDb;

    EditText enteractivity,enterdate,enterdescription,entertime,enterduration,enterenddate;
    Button Save;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_activity);

        myDb = new DatabaseHelper(this);
        spinner = (Spinner) findViewById(R.id.enter_category);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Categories, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        enteractivity = (EditText) findViewById(R.id.enter_activity);;
        enterdate = (EditText) findViewById(R.id.enter_date);
        enterdescription = (EditText) findViewById(R.id.enter_description);
        entertime = (EditText) findViewById(R.id.enter_time);
        enterduration = (EditText) findViewById(R.id.enter_duration);
        enterenddate = (EditText) findViewById(R.id.enter_enddate);

        Save = (Button)findViewById(R.id.save);
       AddData();
    }




    public void AddData() {
        Save.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(String.valueOf(spinner.getSelectedItem()),
                                enteractivity.getText().toString(),enterdate.getText().toString(),
                                enterdescription.getText().toString(),
                                entertime.getText().toString(),enterduration.getText().toString());

                        if(isInserted ==true)
                            Toast.makeText(EnterActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(EnterActivity.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

}
