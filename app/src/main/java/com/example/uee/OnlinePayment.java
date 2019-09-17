package com.example.uee;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Pattern;

import java.util.Calendar;
import java.util.List;


public class OnlinePayment extends AppCompatActivity implements Validator.ValidationListener{

    @NotEmpty
    private EditText card_holder;

    @NotEmpty
    @Pattern(regex = "^(?:4[0-9]{12}(?:[0-9]{3})?|[25][1-7][0-9]{14}|6(?:011|5[0-9][0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|(?:2131|1800|35\\d{3})\\d{11})$")
    private EditText card_number;

    @NotEmpty
    @Pattern(regex = "^[0-9]{3}$")
    private EditText card_cvv;

    private Button submitButton;

    private Validator validator;

    private static final String TAG = "OnlinePayment";

    private EditText date;
    private DatePickerDialog.OnDateSetListener dateListner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_online_payment );

        intitView();
        validator = new Validator( this );
        validator.setValidationListener( this );


        date = (EditText) findViewById( R.id.ex_date);
        date.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get( Calendar.YEAR );
                int month = cal.get( Calendar.MONTH );
                int day = cal.get( Calendar.DAY_OF_MONTH );

                DatePickerDialog dialog = new DatePickerDialog(
                        OnlinePayment.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth,
                        dateListner,
                        year,month,day
                );
                dialog.getWindow().setBackgroundDrawable( new ColorDrawable( Color.TRANSPARENT ) );
                dialog.show();
            }
        } );
        dateListner = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Log.d( TAG, "onDateSet: mm/dd/yyy: " + month + "/" + dayOfMonth + "/" + year);
                String date_ = month + "/" + dayOfMonth + "/" + year;
                date.setText( date_ );
            }
        };
    }
    private void intitView(){
        card_holder = findViewById( R.id.card_holder  );
        card_number = findViewById( R.id.card_num );
        card_cvv = findViewById( R.id.cvv );
        submitButton = findViewById( R.id.paySubmit );

        submitButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitButton_onClick(v);
            }
        } );
    }
    private void submitButton_onClick(View view){
        validator.validate();
        String cardCheck = card_number.getText().toString();
        String cvvCheck = card_cvv.getText().toString();
        if(!cardCheck.matches( "^(?:4[0-9]{12}(?:[0-9]{3})?|[25][1-7][0-9]{14}|6(?:011|5[0-9][0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|(?:2131|1800|35\\d{3})\\d{11})$" )){
            card_number.setError( getText( R.string.card_invalid ) );
        }
        else if(!cvvCheck.matches("^[0-9]{3}$")){
            card_cvv.setError(getText(R.string.cvv_invalid));
        }
    }
    @Override
    public void onValidationSucceeded(){
        Toast.makeText(this,"payment Successfully",Toast.LENGTH_SHORT).show();
        Intent i = new Intent( getApplicationContext(),order_placed.class );
        startActivity( i );
    }
    @Override
    public void onValidationFailed(List<ValidationError> errors){
        for(ValidationError error:errors){
            View view = error.getView();
            String message = error.getCollatedErrorMessage( this );
            if(view instanceof EditText){
                ((EditText)view).setError( message );
            }else{
                Toast.makeText( this,message,Toast.LENGTH_LONG ).show();
            }
        }
    }
}
