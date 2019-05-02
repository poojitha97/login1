package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication2.R;

//  import android.widget.Toast;
public class Main1Activity extends AppCompatActivity {
    int counter = 5;
    private EditText Name;
    private EditText Password;
    private Button Login;
    private Button Cancel;
    private TextView tx1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        Login = (Button) findViewById(R.id.button1);
        Name = (EditText) findViewById(R.id.text);
        Password = (EditText) findViewById(R.id.text2);
        Cancel = (Button) findViewById(R.id.button2);
        tx1 = (TextView) findViewById(R.id.textView3);
        tx1.setVisibility(View.GONE);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });
    }

    private void validate(String userName, String userPassword) {
        if ((userName.equals("Admin")) && (userPassword.equals("123456"))) {
            Intent intent = new Intent(Main1Activity.this, SecondActivity.class);
            startActivity(intent);
            // Toast.makeText(getApplicationContext(), "Redirecting...",Toast.LENGTH_SHORT).show();
        } else {
            //  Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();
            tx1.setVisibility(View.VISIBLE);
            tx1.setBackgroundColor(Color.RED);
            counter--;
            tx1.setText(Integer.toString(counter));
            if (counter == 0) {
                Login.setEnabled(false);
            }
        }
        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
