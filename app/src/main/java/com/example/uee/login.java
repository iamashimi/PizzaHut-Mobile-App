package com.example.uee;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login );
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        setRequestedOrientation ( ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        TextView signUp = (TextView) findViewById(R.id.createAccount);
        Button signIn = (Button) findViewById( R.id.signIn3 );
        final TextView email_field = findViewById( R.id.email );
        final TextView password_field = findViewById( R.id.password );

        signIn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = email_field.getText().toString();
                final String password = password_field.getText().toString();
                if(email.isEmpty()){
                    email_field.requestFocus();
                    email_field.setError( "Please Enter the email" );
                }
                else if(password.isEmpty()){
                    password_field.requestFocus();
                    password_field.setError( "Please enter the password" );
                }
                else if(!email.matches( "[a-zA-z0-9._-]+@[a-z]+.[a-z]+" )){
                    email_field.requestFocus();
                    email_field.setError( "Enter a valid email" );
                }else if(email.contains( "test@example.com" )&& password.contains( "123" )){
                    Intent login = new Intent( getApplicationContext(),MainActivityAfterLogin.class );
                    startActivity( login );
                }
                else{
                    Toast.makeText(getApplicationContext(), "InValid Email Address or Password!!! Try again.", Toast.LENGTH_SHORT).show();
                }
            }
        } );

        signUp.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( getApplicationContext(),registerCustomer.class );
                startActivity( i );
            }
        } );

    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
