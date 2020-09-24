package com.example.manishrchandran.AndroidApp;

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
    // EditText entercategory, entercolor;
    Button Save,Display,Update;
    //    RadioGroup Repeat;

    Spinner spinner;
    // Specify the layout to use when the list of choices appears


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_activity);

        myDb = new DatabaseHelper(this);
        spinner = (Spinner) findViewById(R.id.enter_category);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Categories, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        enteractivity = (EditText) findViewById(R.id.enter_activity);
        //entercategory = (Spinner) findViewById(R.id.enter_category);
        enterdate = (EditText) findViewById(R.id.enter_date);
        //entercolor = (EditText) findViewById(R.id.enter_colour);
        enterdescription = (EditText) findViewById(R.id.enter_description);
        entertime = (EditText) findViewById(R.id.enter_time);
        enterduration = (EditText) findViewById(R.id.enter_duration);
        enterenddate = (EditText) findViewById(R.id.enter_enddate);

        Save = (Button)findViewById(R.id.save);
        //Display= (Button)findViewById(R.id.Display);
//        Repeat =(RadioGroup)findViewById(R.id.radio_Group);
       // Update=(Button)findViewById(R.id.Save);
       AddData();
        //viewAll();
        //UpdateData();

    }




    public void AddData() {
        Save.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        /*
                        boolean isInserted = myDb.insertData(entercategory.getText().toString(),
                                enteractivity.getText().toString(),enterdate.getText().toString(),
                                entercolor.getText().toString(),enterdescription.getText().toString(),
                                entertime.getText().toString(),enterduration.getText().toString(),
                                enterenddate.getText().toString());
                                */
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



//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    /*
    public void UpdateData() {
        Update.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        /*
                        boolean isUpdate = myDb.updateData(enteractivity.getText().toString(),
                                entercategory.getText().toString(), enterdate.getText().toString(),
                                enterdescription.getText().toString(),entercolor.getText().toString(),
                                entertime.getText().toString(), enterduration.getText().toString(),
                                enterenddate.getText().toString());

                         */
    /*
                        boolean isUpdate = myDb.updateData(String.valueOf(spinner.getSelectedItem()),
                                enteractivity.getText().toString(),
                                 enterdate.getText().toString(),
                                enterdescription.getText().toString(),
                                entertime.getText().toString(), enterduration.getText().toString());
                        if(isUpdate == true)
                            Toast.makeText(enter_activity.this,"Data Update",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(enter_activity.this,"Data not Updated",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    */


}
