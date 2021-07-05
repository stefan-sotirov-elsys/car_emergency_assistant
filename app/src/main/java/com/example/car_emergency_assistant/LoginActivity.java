package com.example.car_emergency_assistant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login_button_on_click(View view) {
        String tenant_id, username, password;
        Snackbar invalid_input_message;

        tenant_id = ((EditText)findViewById(R.id.tenant_id_plain_text)).getText().toString();

        username = ((EditText)findViewById(R.id.username_plain_text)).getText().toString();

        password = ((EditText)findViewById(R.id.password_plain_text)).getText().toString();

        if (tenant_id.equals("") || username.equals("") || password.equals(""))
        {
            invalid_input_message = Snackbar.make(view, "Invalid input", BaseTransientBottomBar.LENGTH_SHORT);

            invalid_input_message.show();
        }
        else if (!Global.connection.establish(tenant_id, username, password))
        {
            invalid_input_message = Snackbar.make(view, "Incorrect credentials, please try again", BaseTransientBottomBar.LENGTH_SHORT);

            invalid_input_message.show();
        }
        else
        {

        }
    }
}