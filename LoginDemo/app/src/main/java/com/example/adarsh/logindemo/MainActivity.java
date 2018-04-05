package com.example.adarsh.logindemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Create variables matching with layout widgets
    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Link variables with layout widgets
        Name = (EditText) findViewById(R.id.etName);
        Password = (EditText) findViewById(R.id.etPassword);
        Info = (TextView) findViewById(R.id.tvInfo);
        Login = (Button) findViewById(R.id.btnLogin);

        Info.setText("No of Attempts Remaining: 5");

        //Create function for Login action
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });
    }

    //Create a function to validate the username & password entered
    private void validate(String userName, String userPassword) {
        if ((userName.equals("admin")) && (userPassword.equals("12345"))) {
            Intent intent = new Intent(MainActivity.this, SecondaryActivity.class); //intent used to move between activities
            startActivity(intent);
        }
        else{
            counter--;  //Reduce counter indicating no of attempts

            Info.setText("No of Attempts Remaining: " + String.valueOf(counter)); //String.valueOf() used to convert int to string & used for textview here

            //Disable Login button once the counter reaches 0 indicating attempts left
            if(counter == 0){
                Login.setEnabled(false);
            }
        }
    }
}
