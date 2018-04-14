package com.example.pcc.chat_file;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Start_Activity extends AppCompatActivity {
    private Button btn_signup;
    private Button btn_signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_);
        btn_signup=(Button)findViewById(R.id.btn_get_acc);
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Start_Activity.this,Register_Activity.class);
                startActivity(intent);
            }
        });
        btn_signin=(Button)findViewById(R.id.btn_log);
        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Start_Activity.this,Signin_Activity.class);
                startActivity(intent);
            }
        });
    }
}

