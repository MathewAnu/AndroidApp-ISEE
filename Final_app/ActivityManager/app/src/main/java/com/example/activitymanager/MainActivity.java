package com.example.activitymanager;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.database.Cursor;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText enteractivity,entercategory,enterdate,entercolor,enterdescription,entertime,enterduration,enterenddate;
    Button Save,Display,Update;
//    RadioGroup Repeat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);

        enteractivity = (EditText) findViewById(R.id.enter_activity);
        entercategory = (EditText) findViewById(R.id.enter_category);
        enterdate = (EditText) findViewById(R.id.enter_date);
        entercolor = (EditText) findViewById(R.id.enter_colour);
        enterdescription = (EditText) findViewById(R.id.enter_description);
        entertime = (EditText) findViewById(R.id.enter_time);
        enterduration = (EditText) findViewById(R.id.enter_duration);
        enterenddate = (EditText) findViewById(R.id.enter_enddate);

        Save = (Button)findViewById(R.id.Save);
        Display= (Button)findViewById(R.id.Display);
//        Repeat =(RadioGroup)findViewById(R.id.radio_Group);
        Update=(Button)findViewById(R.id.Save);
        AddData();
        viewAll();
        UpdateData();

    }

    public void viewAll(){
        Display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = myDb.getAllData();
                if (res.getCount()==0)
                {
                    showMessage("Error","Nothing found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext())
                {
                    buffer.append("Id :" + res.getString(0) +"\n");
                    buffer.append("activity :" + res.getString(1) +"\n");
                    buffer.append("category" + res.getString(2) +"\n");
                    buffer.append("date" + res.getString(3) +"\n");
                    buffer.append("description" + res.getString(4) +"\n");
                    buffer.append("color" + res.getString(5) +"\n");
                    buffer.append("time" + res.getString(6) +"\n");
                    buffer.append("duration" + res.getString(7) +"\n");
                    buffer.append("enddate" + res.getString(8) +"|\n\n");
//                    buffer.append("repeatvalue" + res.getString(0) +"|n");

                    showMessage("Data",buffer.toString());

                }
            }
        });
    }



    public void AddData() {
        Save.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(entercategory.getText().toString(),
                                enteractivity.getText().toString(),enterdate.getText().toString(),
                                entercolor.getText().toString(),enterdescription.getText().toString(),
                                entertime.getText().toString(),enterduration.getText().toString(),
                                enterenddate.getText().toString());

                        if(isInserted =true)
                            Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void showMessage(String title,String Message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder( this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();

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

    public void UpdateData() {
        Update.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = myDb.updateData(enteractivity.getText().toString(),
                                entercategory.getText().toString(), enterdate.getText().toString(),
                                enterdescription.getText().toString(),entercolor.getText().toString(),
                                entertime.getText().toString(), enterduration.getText().toString(),
                                enterenddate.getText().toString());
                        if(isUpdate == true)
                            Toast.makeText(MainActivity.this,"Data Update",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this,"Data not Updated",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }


}
