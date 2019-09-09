package com.example.uee;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.mobsandgeeks.saripaar.annotation.NotEmpty;


public class registerCustomer extends AppCompatActivity {

    @NotEmpty
    private EditText full_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_register_customer );
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setRequestedOrientation ( ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        final TextView full_name = findViewById( R.id.fullName );
        final TextView email = findViewById( R.id.userEmailId );
        final TextView contact = findViewById( R.id.mobileNumber );
        final TextView password = findViewById( R.id.password );
        final TextView re_password = findViewById( R.id.confirmPassword );



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
