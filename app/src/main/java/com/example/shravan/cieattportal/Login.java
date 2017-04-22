package com.example.shravan.cieattportal;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    enum UserType { STUDENT, TEACHER };
    TextView appTitle, loginTitle;
    Typeface titleTypeface;

    EditText username, password;
    Button signInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        appTitle = (TextView) findViewById(R.id.appTitle);
        loginTitle = (TextView) findViewById(R.id.loginTitle);

        titleTypeface = Typeface.createFromAsset(getAssets(), "fonts/basictitlefont.ttf");
        if (titleTypeface != null) {
            appTitle.setTypeface(titleTypeface);
            appTitle.setTextSize(30);
            loginTitle.setTypeface(titleTypeface);
            loginTitle.setTextSize(26);
        }

        username = (EditText) findViewById(R.id.usernameEdit);
        password = (EditText) findViewById(R.id.passwordEdit);
        signInButton = (Button) findViewById(R.id.signInButton);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = "";

                if (username != null) {
                    name = username.getText().toString();

                    if (name.toLowerCase().startsWith("student_")) {
                        String[] credentials = name.split("_");
                        if ((credentials.length != 1) && (credentials.length != 0)) {
                            Intent i = new Intent(Login.this, StudentPortal.class);
                            i.putExtra("student_name_key", name.split("_")[1]);
                            startActivity(i);
                        }
                    }
                    else if (name.toLowerCase().startsWith("teacher_")) {
                        String[] credentials = name.split("_");
                        if ((credentials.length != 1) && (credentials.length != 0)) {
                            Intent i = new Intent(Login.this, TeacherPortal.class);
                            i.putExtra("teacher_name_key", name.split("_")[1]);
                            startActivity(i);
                        }
                    }
                    else {
                    }
                }
            }
        });
    }
}
