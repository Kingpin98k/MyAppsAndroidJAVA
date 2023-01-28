package com.allstar98k.learningapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     ImageView img;
    EditText val,num;
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        val = findViewById(R.id.edTxt); //reference to edit text layout
        //to get the input in string
        num = findViewById(R.id.valueOfN);

        //handling the image

        img = findViewById(R.id.imgfront);

        //initializing button counter and view for it
        bt = findViewById(R.id.myButton1);
        //handling the click events

        bt.setOnClickListener(new View.OnClickListener() {  // actions to perform when button is clicked
            @Override
            public void onClick(View view) {
                int valu = Integer.valueOf(val.getText().toString());
                int n = Integer.valueOf(num.getText().toString());
                //Explicit Intent
                Intent i = new Intent(getApplicationContext(),ImplicitActivity.class);
                i.putExtra("nvalue",n);
                i.putExtra("valvalue",valu);

                startActivity(i);
            }
        });
        //Adding functionalities
    }
}