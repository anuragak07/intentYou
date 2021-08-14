package com.masai.intentyou;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HomeScreen extends AppCompatActivity {
    private TextView mtvUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        mtvUserName = findViewById(R.id.tvUsername);
        Intent intent = getIntent();
        String name = intent.getStringExtra("Username");
        mtvUserName.setText(name);

    }
}