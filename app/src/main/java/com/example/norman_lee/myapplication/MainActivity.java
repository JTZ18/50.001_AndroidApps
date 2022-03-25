package com.example.norman_lee.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {

    Button buttonConvert;
    Button buttonSetExchangeRate;
    EditText editTextValue;
    TextView textViewResult;
    TextView textViewExchangeRate;
    double exchangeRate;
    public final String TAG = "Logcat";
    private SharedPreferences mPreferences;
    private String sharedPrefFile = "com.example.android.mainsharedprefs";
    public static final String RATE_KEY = "Rate_Key";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO 4.5 Get a reference to the sharedPreferences object
        //TODO 4.6 Retrieve the value using the key, and set a default when there is none

        //TODO 3.13 Get the intent, retrieve the values passed to it, and instantiate the ExchangeRate class
        //TODO 3.13a See ExchangeRate class --->
        Intent intent = getIntent();
        String aString = intent.getStringExtra(SubActivity.A_KEY);
        String bString = intent.getStringExtra(SubActivity.B_KEY);
        Log.i(TAG, aString + " " + bString);
        // so far this returns aString and bString both return null so check sub activity to see whats wrong
        ExchangeRate exObj = new ExchangeRate(aString, bString);
        textViewExchangeRate = findViewById(R.id.textViewExchangeRate);
        textViewExchangeRate.setText(exObj.getExchangeRate().toString());

        //TODO 2.1 Use findViewById to get references to the widgets in the layout
        EditText userInput = findViewById(R.id.editTextValue);
        Button buttonConvert = findViewById(R.id.buttonConvert);
        String userInputString = userInput.getText().toString();
//        //TODO 2.2 Assign a default exchange rate of 2.95 to the textView
//        exchangeRate.setText(getString(R.string.default_exchange_rate));
        //TODO 2.3 Set up setOnClickListener for the Convert Button
        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get all view values from xml file by id then convert all views to String data type if necessary
                EditText userInput = findViewById(R.id.editTextValue);
                String userInputString = userInput.getText().toString();
                TextView exchangeRateView = findViewById(R.id.textViewExchangeRate);
                String exchangeRateString = exchangeRateView.getText().toString();
                //TODO 2.4 Display a Toast & Logcat message if the editTextValue widget contains an empty string
                if (userInputString.isEmpty()) {
                    Toast.makeText(MainActivity.this, R.string.empty_string_message, Toast.LENGTH_SHORT).show();
                    Log.i("MainActivity.java", "User input is an empty string, this is illegal");
                }
                else {
                    //TODO 2.5 If not, calculate the units of B with the exchange rate and display it
                    //TODO 2.5a See ExchangeRate class --->
                    //convert
                    ExchangeRate exchangeRate = new ExchangeRate(exchangeRateString);
                    BigDecimal result = exchangeRate.calculateAmount(userInputString);

                    //set value to be result
                    TextView resultView = findViewById(R.id.textViewResult);
                    resultView.setText(result.toString());


                }
            }
        });




        //TODO 3.1 Modify the Android Manifest to specify that the parent of SubActivity is MainActivity
        //TODO 3.2 Get a reference to the Set Exchange Rate Button
        Button setExchangeRateButton = (Button) findViewById(R.id.buttonSetExchangeRate);
        //TODO 3.3 Set up setOnClickListener for this
        setExchangeRateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO 3.4 Write an Explicit Intent to get to SubActivity
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                startActivity(intent);
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //TODO 4.1 Go to res/menu/menu_main.xml and add a menu item Set Exchange Rate
    //TODO 4.2 In onOptionsItemSelected, add a new if-statement and code accordingly

    //TODO 5.1 Go to res/menu/menu_main.xml and add a menu item Open Map App
    //TODO 5.2 In onOptionsItemSelected, add a new if-statement
    //TODO 5.3 code the Uri object and set up the intent

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //TODO 4.3 override the methods in the Android Activity Lifecycle here
    //TODO 4.4 for each of them, write a suitable string to display in the Logcat

    //TODO 4.7 In onPause, get a reference to the SharedPreferences.Editor object
    //TODO 4.8 store the exchange rate using the putString method with a key

}
