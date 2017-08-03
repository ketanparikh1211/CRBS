package com.example.shefaliupadhyaya.crbs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {
    private static EditText userName, password;
    private static Button login;
    private static ImageButton signup, forgotpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onLoginClick();
        onSignUpClick();
        onforgotpassClick();
    }

    public void onLoginClick() {
        userName = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if (userName.getText().toString().equals("User") && password.getText().toString().equals("Android")) {
                    Toast.makeText(MainActivity.this, "Username and Password is correct", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(MainActivity.this,Homepage.class);
                    startActivity(i);
                } else
                    Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_LONG).show();
                String user = userName.getText().toString();
                String pass = password.getText().toString();
                /*if (isValidUser(user)) {
                    if (isValidPassword(pass)) {
                        if (userName.getText().toString().equals("User") && password.getText().toString().equals("Android123")) {
                            Toast.makeText(MainActivity.this, "Username and Password is correct", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(MainActivity.this, Homepage.class);
                            startActivity(i);
                        } else
                            Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Invalid password format",Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(getApplicationContext(), "Invalid username format", Toast.LENGTH_SHORT).show();
                }*/
            }
        });
    }

    public void onSignUpClick() {
        signup = (ImageButton) findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent("com.example.shefaliupadhyaya.crbs.SignUp");
                startActivity(i);
            }
        });
    }

    public void onforgotpassClick() {
        forgotpass=(ImageButton)findViewById(R.id.forgotpass);
        forgotpass.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent i = new Intent("com.example.shefaliupadhyaya.crbs.ForgotPassword");
                startActivity(i);
            }
        });
    }

    // validating email id
    private boolean isValidUser(String user) {
        String EMAIL_PATTERN = "[a-zA-Z\\d\\!@#\\$%&\\*]{3,}";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(user);
        return matcher.matches();
    }

    // validating password with retype password
    private boolean isValidPassword(String pass) {

        boolean match=isValidPassword2(pass);
        if (pass != null && pass.length()>8 && match) {
            return true;
        }
        return false;
    }
    // validating password
    private boolean isValidPassword2(String pass) {
        String PASS_PATTERN = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";
        Pattern pattern = Pattern.compile(PASS_PATTERN);
        Matcher matcher = pattern.matcher(pass);
        return matcher.matches();
    }

    @Override
    public void onBackPressed() {

    }
}
