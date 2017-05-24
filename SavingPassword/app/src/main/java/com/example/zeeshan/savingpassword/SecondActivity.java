package com.example.zeeshan.savingpassword;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity { public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Password = "Password";
    public static final String Frequency = "Frequency";
    public static final String IsScreenLock = "IsScreenLock";
    public Boolean ScreenLock = false;
    SharedPreferences sharedpreferences;
    TextView textView1, textView2, textView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView1 = (TextView) findViewById(R.id.tv_saved_password);
        textView2 = (TextView) findViewById(R.id.tv_saved_frequency);
        textView3 = (TextView) findViewById(R.id.tv_saved_checkbox);
        sharedpreferences = getApplicationContext().getSharedPreferences(MyPREFERENCES, 0); // 0 - for private mode
        //Editor editor = pref.edit();

        String passwoedText = sharedpreferences.getString(Password, "NA");
        Log.e("passwoedText ",passwoedText);
        String frequencyText = sharedpreferences.getString(Frequency, "NA");
        Log.e("frequencyText ",frequencyText);
        Boolean checkedText = sharedpreferences.getBoolean(IsScreenLock, false);
        Log.e("checkedText ",checkedText.toString());

        textView1.setText(passwoedText);
        textView2.setText(frequencyText);
        textView3.setText(checkedText.toString());
    }
}