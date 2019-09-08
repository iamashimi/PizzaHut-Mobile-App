package com.example.uee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText( MainActivity.this, "Open pizzaHut App", Toast.LENGTH_SHORT ).show();
        Button d_button = findViewById(R.id.del_button);
        Button t_button = findViewById(R.id.take_button);
        Button login_button = findViewById( R.id.login_button );
        Button reg_button = findViewById( R.id.signin_button );

        d_button.setOnClickListener(this);
        t_button.setOnClickListener(this);
        login_button.setOnClickListener( this );
        reg_button.setOnClickListener( this );

        t_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2 = new Intent(MainActivity.this,take.class);
                startActivity(int2);
            }
        });

        d_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int3 = new Intent(MainActivity.this,del.class);
                startActivity(int3);
            }
        });

        login_button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int4 = new Intent( MainActivity.this,login.class);
                startActivity( int4 );
            }
        });
        reg_button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int5 = new Intent( MainActivity.this,registerCustomer.class);
                startActivity( int5 );
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
