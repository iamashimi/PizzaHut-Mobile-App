package com.example.uee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class PaymentDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_payment_details );

        Button pay = findViewById( R.id.pay );
        final RadioButton radioButton = findViewById(R.id.radioMaster);

        pay.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radioButton.isChecked()){
                    System.out.println("ininininijnii");
                    Intent i = new Intent( getApplicationContext(),order_placed.class );
                    startActivity( i );
                }
                else{
                    Intent i = new Intent( getApplicationContext(),OnlinePayment.class );
                    startActivity( i );
                }
            }
        } );
    }
}
