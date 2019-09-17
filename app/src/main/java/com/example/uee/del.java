package com.example.uee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class del extends AppCompatActivity implements View.OnClickListener{

    EditText StreetAndCityEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_del);

        Button help_button = findViewById(R.id.help);
        Button ConformButton = findViewById(R.id.button3);
        final EditText HouseNoEditText = findViewById(R.id.editText2);
        StreetAndCityEditText = findViewById(R.id.editText4);

        ConformButton.setOnClickListener(this);
        Button selectPizza = findViewById( R.id.button3 );

        selectPizza.setOnClickListener( this );

        selectPizza.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( getApplicationContext(),SearchPizza.class );
                startActivity( i );
            }
        } );


        ConformButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String HouseNo = HouseNoEditText.getText().toString();
                final String StreetAndCity = StreetAndCityEditText.getText().toString();

                if(HouseNo.length()==0){
                    HouseNoEditText.requestFocus();
                    HouseNoEditText.setError("PLEASE ENTER THE HOUSE NO.");
                }

                else if(StreetAndCity.length()==0){
                    StreetAndCityEditText.requestFocus();
                    StreetAndCityEditText.setError("PLEASE ENTER THE STREET AND CITY.");
                }

                else {
                    Toast.makeText(del.this,"Validation Successful", Toast.LENGTH_LONG).show();
                    Intent i = new Intent( getApplicationContext(),SearchPizza.class );
                    startActivity( i );
                }
            }
        });

        help_button.setOnClickListener(this);

        help_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2 = new Intent(del.this,Help.class);
                startActivity(int2);
            }
        });

        Toast.makeText( del.this, "Opening Delivery...", Toast.LENGTH_SHORT ).show();
        ImageButton back = findViewById(R.id.imageButton);

        back.setOnClickListener(this);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2 = new Intent(del.this,MainActivity.class);
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
