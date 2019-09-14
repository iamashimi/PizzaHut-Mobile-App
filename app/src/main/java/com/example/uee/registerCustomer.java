package com.example.uee;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.annotation.ConfirmPassword;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Password;
import com.mobsandgeeks.saripaar.annotation.Pattern;

import java.util.List;


public class registerCustomer extends AppCompatActivity implements Validator.ValidationListener{

    @NotEmpty
    private EditText full_name;

    @NotEmpty
    @Password
    private EditText password;

    @ConfirmPassword
    private EditText confirmPassword;

    @NotEmpty
    @Pattern(regex =  "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$")
    private EditText contact;

    @NotEmpty
    @Email
    private EditText email;

    private Button submitButton;

    private Validator validator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_register_customer );
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setRequestedOrientation ( ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        intitView();
        validator = new Validator( this );
        validator.setValidationListener( this );

    }

    private void intitView(){
        full_name = findViewById( R.id.fullName  );
        email = findViewById( R.id.userEmailId );
        contact = findViewById( R.id.mobileNumber );
        password = findViewById( R.id.password );
        confirmPassword = findViewById( R.id.confirmPassword );
        submitButton = findViewById( R.id.signIn );
        submitButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitButton_onClick(v);
            }
        } );
    }
    private void submitButton_onClick(View view){
        validator.validate();
        String emailCheck = email.getText().toString();
        if(emailCheck.equalsIgnoreCase( "test@sample.com" )){
            email.setError( getText( R.string.email_already_exists ) );
        }
    }

    @Override
    public void onValidationSucceeded(){
        Toast.makeText(this,"Registration is Successfull",Toast.LENGTH_SHORT).show();
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
