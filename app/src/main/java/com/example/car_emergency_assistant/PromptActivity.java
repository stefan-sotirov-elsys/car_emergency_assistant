package com.example.car_emergency_assistant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class PromptActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prompt);
    }

    public void affirmative_button_on_click(View view) {
        Global.connection.set_alarm("MAJOR");

        finish();
    }


    public void negative_button_on_click(View view) {
        finish();
    }
}