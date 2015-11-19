package com.oop.muj.mujtabaproject2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void sendMessage(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        startActivity(intent);
    }


    public void displayName(View view) {
        // Do something in response to button
        ((TextView)findViewById(R.id.textView)).setText("*Mujtaba,Hamid,Sarim,Abdullah*");
    }




}
