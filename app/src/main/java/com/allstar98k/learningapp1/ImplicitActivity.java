package com.allstar98k.learningapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ImplicitActivity extends AppCompatActivity {
TextView tv1;
Button share_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit);
        tv1 = findViewById(R.id.textViewForAnswer);
        share_btn = findViewById(R.id.buttonForShare);
        //getting data passed from back
        Intent i = getIntent();
        int val = i.getIntExtra("valvalue",0);
        int n = i.getIntExtra("nvalue",0);
        double ans = Double.valueOf(String.format("%.3f",Math.pow(val,1.0/n)));
        tv1.setText(String.format("%.3f",ans));

        share_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //implicit intent
                shareData(val,n,ans);
            }
        });
    }

    public void shareData(int val,int n,double ans){
         //Implicit Intents
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        String valu = String.valueOf(val);
        String numb = String.valueOf(n);
        String answ = String.valueOf(ans);
        String cut;
        if(n%10==1&&n!=11){
            cut="st";
        }else if(n==2&&n!=12){
            cut="nd";
        }else if(n%10==3&&n!=13){
            cut="rd";
        }else{
            cut="th";
        }
        i.putExtra(Intent.EXTRA_TEXT,"Your Question is : Find "+numb+cut+" "+"Root of "+valu+"\n"+"\n"+"The answer is :- "+ans);
        startActivity(Intent.createChooser(i,"Select The Platform To Share..."));
    }
}