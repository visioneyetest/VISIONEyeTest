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

public class ishihara13 extends Activity 
{
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ishihara13);
       
        Button b1 = (Button) findViewById(R.id.button1);
        Button b2 = (Button) findViewById(R.id.button2);
        
        // -- register click event with first button ---
        b1.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {
               // --- find the text view --
               //TextView txtView = (TextView) findViewById(R.id.textView1);
               // -- change text size --
             //  txtView.setText("Test Pass......");
        	   ishihara.icounter=ishihara.icounter+1;
        	   //Toast.makeText(ishihara1.this, "pass step1...",Toast.LENGTH_LONG ).show();
        	   Intent i=new Intent(ishihara13.this,ishihara14.class);
        	   startActivity(i);
        	   finish();
           }
        });
        
        // -- register click event with second button ---
        b2.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {
               // --- find the text view --
               //TextView txtView = (TextView) findViewById(R.id.textView1);
               // -- change text size --
            // txtView.setText("Test Fail......");
        	   //Toast.makeText(amsler.this, "Sorry.....You are fail....",Toast.LENGTH_LONG ).show();
        	   Toast.makeText(getBaseContext(), "Sorry.....You are fail.... Your score is="+ishihara.icounter, 4).show();
        	   ishihara.icounter=0;
        	   Intent i=new Intent(ishihara13.this,MainActivity.class);
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
