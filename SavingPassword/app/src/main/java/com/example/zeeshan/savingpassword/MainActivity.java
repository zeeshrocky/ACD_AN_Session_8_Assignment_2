package com.example.zeeshan.savingpassword;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editText1, editText2;
    CheckBox checkBox;
    Button saveButton, nextButton;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Password = "Password";
    public static final String Frequency = "Frequency";
    public static final String IsScreenLock = "IsScreenLock";
    public Boolean ScreenLock = false;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.ev_password);
        editText2 = (EditText) findViewById(R.id.ev_set_frequency);
        checkBox = (CheckBox) findViewById(R.id.cb_screen_pw);

        saveButton = (Button) findViewById(R.id.save_button);
        nextButton = (Button) findViewById(R.id.next_button);

        saveButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
    }

    @Override
    public void onClick(View v) {
        String text_password = editText1.getText().toString();
        String text_frequency = editText2.getText().toString();
        ScreenLock = checkBox.isChecked();

        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(Password, text_password);
        editor.putString(Frequency, text_frequency);
        editor.putBoolean(IsScreenLock, ScreenLock);
        editor.apply();
        Toast.makeText(MainActivity.this,"Preferences Saved.", Toast.LENGTH_LONG).show();

        if(v.getId() == nextButton.getId()){
            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
            startActivity(intent);
        }

    }
}