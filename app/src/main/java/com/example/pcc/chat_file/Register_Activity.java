package com.example.pcc.chat_file;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Register_Activity extends AppCompatActivity {
    private TextInputLayout txin1;
    private TextInputLayout txin2;
    private TextInputLayout txin3;
    private Button btn_signup;
            Socket s=null;
            ObjectOutputStream oos=null;
    String email_toserver;
    User user_details=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_);
        txin1=(TextInputLayout)findViewById(R.id.txt_inp_Lay1);
        txin2=(TextInputLayout)findViewById(R.id.txt_inp_Lay2);
        txin3=(TextInputLayout)findViewById(R.id.txt_inp_Lay3);
        btn_signup=(Button)findViewById(R.id.btn_sign_up);

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread t=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            s=new Socket("192.168.1.101",8080);
                            oos=new ObjectOutputStream(new BufferedOutputStream(s.getOutputStream()));
                            user_details=new User(1,txin1.getEditText().getText().toString(),txin2.getEditText().getText().toString(),txin3.getEditText().getText().toString());
                            oos.writeObject(user_details);
                            oos.flush();
                            oos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Bundle b=new Bundle();
                        b.putString("user",txin1.getEditText().getText().toString());
                        /*ProgressDialog progressDialog=new ProgressDialog(Register_Activity.this);
                        progressDialog.setMessage("Loading while Creating your account");
                        progressDialog.setTitle("Loading");
                        progressDialog.show();*/

                        Intent intent=new Intent(Register_Activity.this,MainActivity.class);
                        intent.putExtras(b);
                        startActivity(intent);

                    }
                });
              t.start();
            }
        });
    }
}