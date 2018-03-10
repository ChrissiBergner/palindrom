package com.example.christianebergner.palindrom;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.checkbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check();
            }
        });
        editText = findViewById(R.id.edit_text);
    }


    public void check(){
        String s = editText.getText().toString();
        if(s.isEmpty())
            s="Geben Sie einen Text ein";
        else if(s.length()>0 && s.length()<5)
            s="Nicht genügend Buchstaben";
        else{
           boolean palindrom=s.equals(new StringBuilder(s).reverse().toString());
           if(palindrom){
               s="Ist ein Palindrom";
           }else{
               s="Ist kein Palindrom";
           }
        }

        Toast toast = Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT);
        toast.show();
    }
}
