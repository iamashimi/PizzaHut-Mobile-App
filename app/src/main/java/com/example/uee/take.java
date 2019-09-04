package com.example.uee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class take extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take);

        Button help_button = findViewById(R.id.help);

        help_button.setOnClickListener(this);

        help_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2 = new Intent(take.this,Help2.class);
                startActivity(int2);
            }
        });

        Toast.makeText( take.this, "Openning Takeaway....", Toast.LENGTH_SHORT ).show();
        ImageButton back = findViewById(R.id.imageButton);

        back.setOnClickListener(this);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2 = new Intent(take.this,MainActivity.class);
                startActivity(int2);
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageButton:
                Toast.makeText(this, "Back", Toast.LENGTH_LONG).show();
        }
    }
}
