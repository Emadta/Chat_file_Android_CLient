package com.example.pcc.chat_file;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.w3c.dom.Text;

public class Signin_Activity extends AppCompatActivity {
    private Button btn_signin;
    private TextInputLayout textInputLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin_);


        btn_signin=(Button)findViewById(R.id.btn_sign_in);
        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog=new ProgressDialog(Signin_Activity.this);
                progressDialog.setMessage("Loading while Sign in your account");
                progressDialog.setTitle("Loading");
                progressDialog.show();

                Intent intent=new Intent(Signin_Activity.this,MainActivity.class);

                startActivity(intent);
            }
        });
    }
}
