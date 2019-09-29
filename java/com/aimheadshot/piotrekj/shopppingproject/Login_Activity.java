package com.aimheadshot.piotrekj.shopppingproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.aimheadshot.guptastationery.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login_Activity extends AppCompatActivity {
    private EditText email_id_text;
    private EditText password_text;
    private ImageView help_image;
    private Button sign_in_button;
    private Button create_account_button;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    private FirebaseUser firebaseUser;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);

        firebaseAuth=FirebaseAuth.getInstance();
        email_id_text=(EditText)findViewById(R.id.emailId);
        password_text=(EditText)findViewById(R.id.password);
        sign_in_button= (Button) findViewById(R.id.signIn);
        create_account_button=(Button)findViewById(R.id.createAccount);
        help_image=(ImageView)findViewById(R.id.help_image_id);
        progressDialog=new ProgressDialog(this);

        create_account_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login_Activity.this, CreateAccountActivity.class));
                finish();
            }
        });

        authStateListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                firebaseUser=firebaseAuth.getCurrentUser();

                if(firebaseUser!=null){
                    Toast.makeText(Login_Activity.this,"Signed In",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Login_Activity.this,MainActivity.class));
                    finish();

                }else{

                    Toast.makeText(Login_Activity.this,"Not signed In",Toast.LENGTH_LONG).show();


                }


            }
        };

        help_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Login_Activity.this,Help_Activity.class));
            }
        });

        sign_in_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(!TextUtils.isEmpty(email_id_text.getText().toString())
                        && !TextUtils.isEmpty(password_text.getText().toString())){


                    String email=email_id_text.getText().toString();
                    String pwd=password_text.getText().toString();

                    login(email,pwd);

                }
            }
        });

    }

    private void login(String email, String pwd) {


        progressDialog.setMessage("Signing in....");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(email,pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    progressDialog.dismiss();
                    startActivity(new Intent(Login_Activity.this,MainActivity.class));
                    finish();
                }
                else{
                    Toast.makeText(Login_Activity.this,"Invalid Credentials!!",Toast.LENGTH_LONG).show();
                    progressDialog.dismiss();

                }

            }
        });


    }
    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(authStateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(authStateListener!=null){
            firebaseAuth.removeAuthStateListener(authStateListener);
        }
    }
}
