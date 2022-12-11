package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button but2authorization;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        but2authorization = findViewById(R.id.but2authorization);
        Intent int2secAct = new Intent(this, BottomNavActivity.class);


        EditText login = findViewById(R.id.email);
        EditText pas = findViewById(R.id.password);
        but2authorization.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editable loginEntered = login.getText();
                Editable passEntered = pas.getText();
                String[] logins = getResources().getStringArray(R.array.logins);
                String[] passwords = getResources().getStringArray(R.array.passwords);
                boolean isCorrectInputData = false;
                for(int i = 0; i < logins.length && !isCorrectInputData; i++) {
                    if (loginEntered.toString().equals(logins[i]) & passEntered.toString().equals(passwords[i]))
                    {
                        Toast.makeText(getApplicationContext(), "Succesful!", Toast.LENGTH_LONG).show();
                        startActivity(int2secAct);
                        isCorrectInputData = true;
                    }
                }
                if (!isCorrectInputData)
                {
                    Toast.makeText(getApplicationContext(), "Password or login not corrected!", Toast.LENGTH_LONG).show();
                    startActivity(int2secAct);
                }
            }
        });
    }
}