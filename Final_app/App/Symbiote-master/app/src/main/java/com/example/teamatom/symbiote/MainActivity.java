package com.example.teamatom.symbiote;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.view.View.OnClickListener;
import android.app.AlertDialog.Builder;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.view.View;
import android.widget.TextView;
import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    public Button proceed;
    public EditText password;
    private TextView Info;
    private int counter = 5;
    public String pass_result;
    public Boolean PinState;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setHasOptionsMenu(true);
        PinState=false; //PIN state from database
        proceed = (Button) findViewById(R.id.proceedNext);
        password = (EditText) findViewById(R.id.pass);
        Info = (TextView)findViewById(R.id.textView2);
        pass_result = password.getText().toString();
        final String correct_pass= new String("0000");
        //password here........
        Info.setText("No of attempts remaining: 5");

        proceed.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

        if (password.getText().toString().equals(correct_pass)&&counter>=0) {

                    Intent j = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(j);


        } else if ((pass_result!="0000")&&counter>0) {
            AlertDialog alertDialog = new AlertDialog.Builder(
                    MainActivity.this).create();

            // Setting Dialog Title
            alertDialog.setTitle("Wrong Password!");

            // Setting Dialog Message
            //alertDialog.setMessage(password.getText().toString());

            // Setting Icon to Dialog
            //alertDialog.setIcon(R.drawable.tick);

            // Setting OK Button
            alertDialog.setButton("Ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // Write your code here to execute after dialog closed
                    Toast.makeText(getApplicationContext(), "Attempt ", Toast.LENGTH_SHORT).show();
                }
            });

            // Showing Alert Message
            alertDialog.show();




                counter--;




        Info.setText("No of attempts remaining: " + String.valueOf(counter));

        }

         else {

                    AlertDialog alertDialog = new AlertDialog.Builder(
                    MainActivity.this).create();

            // Setting Dialog Title
            alertDialog.setTitle("Wrong Password!");

            // Setting Dialog Message
            alertDialog.setMessage("No attempts left");

            // Setting Icon to Dialog
            //alertDialog.setIcon(R.drawable.tick);

            // Setting OK Button
            alertDialog.setButton("Reset password", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // Write your code here to execute after dialog closed
                    Toast.makeText(getApplicationContext(), "Cannot reset! ", Toast.LENGTH_SHORT).show();
                }
            });

            // Showing Alert Message
            alertDialog.show();


        }


                }
            });



    }

    //@Override
    /*public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu1, menu);
    }
    */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Wir prüfen, ob Menü-Element mit der ID "action_daten_aktualisieren"
        // ausgewählt wurde und geben eine Meldung aus
        int id = item.getItemId();
        if (id == R.id.action_daten_aktualisieren) {
            //Toast.makeText(getActivity(), "Aktualisieren gedrückt!", Toast.LENGTH_LONG).show();
            Toast.makeText(this, "We are Team ATOM!", Toast.LENGTH_LONG).show();

            return true;
        }
        if (id == R.id.pinManage) {
            if(PinState) {
                final AlertDialog alertDialog2 = new AlertDialog.Builder(
                        MainActivity.this).create();

                alertDialog2.setTitle("Enter Password!");
                final EditText input = new EditText(MainActivity.this);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
                input.setLayoutParams(lp);
                input.setTransformationMethod(new PasswordTransformationMethod());
                alertDialog2.setView(input);
                input.setGravity(Gravity.CENTER_HORIZONTAL);
                input.setEms(4);
                input.setTextSize(25);
                //final String passcheck;

                int maxLength = 4;
                InputFilter[] fArray = new InputFilter[1];
                fArray[0] = new InputFilter.LengthFilter(maxLength);
                input.setFilters(fArray);

                // Setting Dialog Message
                //passcheck = input.getText().toString();

                // Setting Icon to Dialog
                //alertDialog.setIcon(R.drawable.tick);

                // Setting OK Button
                alertDialog2.setButton("Disable", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to execute after dialog closed
                        //Toast.makeText(getApplicationContext(), "Password Disabled! ", Toast.LENGTH_SHORT).show();
                        if (input.getText().toString().equals("0000")) {
                            Toast.makeText(getApplicationContext(), "PIN Disabled! ", Toast.LENGTH_SHORT).show();
                            PinState=false;
                        } else {

                            Toast.makeText(getApplicationContext(),
                                    "Wrong Password!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                // Showing Alert Message
                alertDialog2.show();
            }
            if(!PinState) {
                //Toast.makeText(getActivity(), "Aktualisieren gedrückt!", Toast.LENGTH_LONG).show();
                Toast.makeText(this, " PIN ENABLED!", Toast.LENGTH_LONG).show();
                PinState=true;
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}