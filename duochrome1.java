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

public class duochrome1 extends Activity 
{
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.duochrome1);
       
        Button next = (Button) findViewById(R.id.button1);
        Button stop = (Button) findViewById(R.id.button2);
        
        // -- register click event with first button ---
        next.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {
               // --- find the text view --
               //TextView txtView = (TextView) findViewById(R.id.textView1);
               // -- change text size --
             //  txtView.setText("Test Pass......");
        	   Intent i=new Intent(duochrome1.this,duochrome2.class);
        	   startActivity(i);
           }
        });
        
        // -- register click event with second button ---
        stop.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {
               // --- find the text view --
               //TextView txtView = (TextView) findViewById(R.id.textView1);
               // -- change text size --
            // txtView.setText("Test Fail......");
        	   Toast.makeText(duochrome1.this, "Sorry.....You are fail....",Toast.LENGTH_LONG ).show();
        	   Intent i=new Intent(duochrome1.this,MainActivity.class);
        	   startActivity(i);
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
