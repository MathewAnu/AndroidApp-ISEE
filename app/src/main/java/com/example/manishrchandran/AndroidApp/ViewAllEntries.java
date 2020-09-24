package com.example.manishrchandran.AndroidApp;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.database.Cursor;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;

public class ViewAllEntries extends AppCompatActivity {
    DatabaseHelper myDb;
    ArrayList<String> category, activity, description, date, time, duration;
    CustomAdapter customAdapter;
    RecyclerView recyclerView = (RecyclerView)findViewById(R.id.my_recycler_view);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_all_entries);

        recyclerView = findViewById(R.id.my_recycler_view);

        myDb = new DatabaseHelper(ViewAllEntries.this);
        activity = new ArrayList<>();
        description = new ArrayList<>();
        date = new ArrayList<>();
        time = new ArrayList<>();
        duration = new ArrayList<>();

        storeDataInArrays();
        customAdapter = new CustomAdapter(this, category, activity, description, date, time, duration);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ViewAllEntries.this));

    }

    public void storeDataInArrays()
    {
        Cursor result = myDb.getAllData();

        if (result.getCount() == 0) {
            showMessage("Error","Nothing found");
            return;
        }
        else
        {
            while (result.moveToNext())
            {
                category.add(result.getString(1) );
                activity.add(result.getString(2));
                date.add(result.getString(3));
               description.add(result.getString(4));
                time.add(result.getString(5));
                duration.add(result.getString(6));
            }

        }
    }
public void viewData()
{
    Cursor result = myDb.getAllData();


    if (result.getCount() == 0) {
        showMessage("Error","Nothing found");

    }
    else
    {
        StringBuffer buffer = new StringBuffer();
        while (result.moveToNext())
        {
            buffer.append("activity :" + result.getString(1) + "\n");
            buffer.append("date" + result.getString(2) + "\n");
            buffer.append("description" + result.getString(3) + "\n");
            buffer.append("time" + result.getString(4) + "\n");
            buffer.append("duration" + result.getString(5) + "\n\n");
             showMessage("Data",buffer.toString());
        }

    }
}
        public void showMessage (String title, String Message)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(true);
            builder.setTitle(title);
            builder.setMessage(Message);
            builder.show();

        }


}
