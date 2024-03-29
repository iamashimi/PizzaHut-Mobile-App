package com.example.uee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivityAfterLogin extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_after_login);
        getSupportActionBar().hide();

        Toast.makeText( MainActivityAfterLogin.this, "Open pizzaHut App", Toast.LENGTH_SHORT ).show();
        Button d_button = findViewById(R.id.del_button);
        Button t_button = findViewById(R.id.take_button);
        Button profile_button = findViewById( R.id.profile_button );
        Button logout_button = findViewById( R.id.logout_button );

        d_button.setOnClickListener(this);
        t_button.setOnClickListener(this);
        profile_button.setOnClickListener( this );
        logout_button.setOnClickListener( this );

        logout_button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logout = new Intent( MainActivityAfterLogin.this, MainActivity.class );
                startActivity( logout );
            }
        } );

        t_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2 = new Intent(MainActivityAfterLogin.this,take.class);
                startActivity(int2);
            }
        });

        d_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int3 = new Intent(MainActivityAfterLogin.this,del.class);
                startActivity(int3);
            }
        });

        profile_button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int4 = new Intent( MainActivityAfterLogin.this,profile.class);
                startActivity( int4 );
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.del_button:
                Toast.makeText(this, "Delivery page lodaing", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.nav_menu, menu);
        return true;
    }
}

