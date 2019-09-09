package com.example.uee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Help extends AppCompatActivity implements View.OnClickListener{
    EditText NameEditText, CnoEditText, emailEditText, RaddEditText;
    Button sendButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        NameEditText = findViewById(R.id.editText2);
        CnoEditText = findViewById(R.id.editText4);
        emailEditText = findViewById(R.id.editText5);
        RaddEditText = findViewById(R.id.editText6);
        sendButton = findViewById(R.id.button3);
        ImageButton back = findViewById(R.id.imageButton);

        sendButton.setOnClickListener(this);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String Name = NameEditText.getText().toString();
                final String ContactNo = CnoEditText.getText().toString();
                final String Email = emailEditText.getText().toString();
                final String ResAddress = RaddEditText.getText().toString();

                if(Name.length()==0){
                    NameEditText.requestFocus();
                    NameEditText.setError("PLEASE ENTER THE NAME.");
                }

                else if(ContactNo.length()==0){
                    CnoEditText.requestFocus();
                    CnoEditText.setError("PLEASE ENTER THE CONTACT NUMBER.");
                }

                else if(!ContactNo.matches("[0-9]{10}")){
                    CnoEditText.requestFocus();
                    CnoEditText.setError("PLEASE ENTER VALID CONTACT NUMBER.");
                }

                else if(Email.length()==0){
                    emailEditText.requestFocus();
                    emailEditText.setError("PLEASE ENTER THE EMAIL ADDRESS.");
                }

                else if(!Email.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")){
                    emailEditText.requestFocus();
                    emailEditText.setError("PLEASE ENTER VALID EMAIL ADDRESS.");
                }

                else if(ResAddress.length()==0){
                    RaddEditText.requestFocus();
                    RaddEditText.setError("PLEASE ENTER THE RECIPIENT ADDRESS.");
                }

                else {
                    Toast.makeText(Help.this,"Validation Successful", Toast.LENGTH_LONG).show();
                }
            }
        });


        back.setOnClickListener(this);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2 = new Intent(Help.this,del.class);
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
