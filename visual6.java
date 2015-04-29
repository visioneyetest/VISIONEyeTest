package com.example.vision;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class visual6 extends Activity 
{
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.visual6);
       
        Button next = (Button) findViewById(R.id.button1);
        Button stop = (Button) findViewById(R.id.button2);
        
        // -- register click event with first button ---
        next.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {
               // --- find the text view --
               //TextView txtView = (TextView) findViewById(R.id.textView1);
               // -- change text size --
             //  txtView.setText("Test Pass......");
        	   visual.vcounter=visual.vcounter+1;
        	   //Toast.makeText(picture.this, "pass step1...",Toast.LENGTH_LONG ).show();
        	   Intent i=new Intent(visual6.this,visual7.class);
        	   startActivity(i);
        	   finish();
           }
        });
        
        // -- register click event with second button ---
        stop.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {
               // --- find the text view --
               //TextView txtView = (TextView) findViewById(R.id.textView1);
               // -- change text size --
            // txtView.setText("Test Fail......");
        	   //Toast.makeText(amsler.this, "Sorry.....You are fail....",Toast.LENGTH_LONG ).show();
        	   Toast.makeText(getBaseContext(), "Sorry.....You are fail.... Your score is="+visual.vcounter, 4).show();
        	   visual.vcounter=0;
        	   Intent i=new Intent(visual6.this,MainActivity.class);
        	   startActivity(i);
        	   finish();
           }
        });
    }
       
			
	

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	
    
}
