package com.example.manishrchandran.AndroidApp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExportData extends AppCompatActivity {
    private static final String FILE_NAME = "TimeTrackerData.txt";
    Button download, send;
    String Data;
    EditText emailID,Message;
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.export_data);

        download = (Button)findViewById(R.id.btnDownload);
        send = (Button)findViewById(R.id.btnSend);
        emailID =(EditText)findViewById(R.id.mailID);
        myDb = new DatabaseHelper(this);
        Message =(EditText)findViewById(R.id.txtEMsg);

        myDb = new DatabaseHelper(this);

        download.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    saveDataToFile(true);
                }
            });
        send.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        saveDataToFile(false);

                        String to=emailID.getText().toString();
                        String subject="TimeTracker Data";
                        String message=Message.getText().toString();

                        Intent email = new Intent(Intent.ACTION_SEND);
                        email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
                        email.putExtra(Intent.EXTRA_SUBJECT, subject);
                        email.putExtra(Intent.EXTRA_TEXT, message);
                        email.putExtra(Intent.ACTION_ATTACH_DATA, getFilesDir() + "/" + FILE_NAME);
                        email.setType("message/rfc822");

                        startActivity(Intent.createChooser(email, "Choose an Email client :"));
                    }
                });


    }

    public void saveDataToFile(boolean showToast){
        //Data = "This is the content ";
        Cursor result = myDb.getAllData();
        if (result.getCount() == 0) {
            // show a message that database is empty. Go back to main menu
            showMessage("Error","Nothing found in the Databse");
        }
        else {
            StringBuffer buffer = new StringBuffer();
            while (result.moveToNext()) {
                buffer.append("Category : " + result.getString(1) + "\n");
                buffer.append("Activity : " + result.getString(2) + "\n");
                buffer.append("Date : " + result.getString(3) + "\n");
                buffer.append("Description : " + result.getString(4) + "\n");
                buffer.append("Time : " + result.getString(5) + "\n");
                buffer.append("Duration : " + result.getString(6) + "\n\n");
                Data = buffer.toString();
            }
            FileOutputStream fos = null;
            try {
                fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
                fos.write(Data.getBytes());
                if (showToast) {
                    //Toast.makeText(this, "Saved to " + getFilesDir() + "/" + FILE_NAME,Toast.LENGTH_LONG).show();
                    AlertDialog alertDialog = new AlertDialog.Builder(
                            ExportData.this).create();
                    alertDialog.setTitle("Data Saved to Device ");
                    alertDialog.setMessage("Location : " + getFilesDir() + "/" + FILE_NAME);
                    alertDialog.setButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplicationContext(), " Done", Toast.LENGTH_SHORT).show();
                        }
                    });

                    // Showing Alert Message
                    alertDialog.show();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    public void showMessage (String title, String Message)
    {
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();

    }

}

