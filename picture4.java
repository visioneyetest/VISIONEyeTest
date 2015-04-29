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

public class picture4 extends Activity 
{
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.picture4);
       
        Button b1 = (Button) findViewById(R.id.button1);
        Button b2 = (Button) findViewById(R.id.button2);
        
        // -- register click event with first button ---
        b1.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {
               // --- find the text view --
               //TextView txtView = (TextView) findViewById(R.id.textView1);
               // -- change text size --
             //  txtView.setText("Test Pass......");
        	   picture.pcounter=picture.pcounter+1;
        	  // Toast.makeText(picture4.this, "pass step2...",Toast.LENGTH_LONG ).show();
        	   Intent i=new Intent(picture4.this,picture5.class);
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
        	   Toast.makeText(getBaseContext(), "Sorry.....You are fail.... Your score is="+picture.pcounter, 4).show();
        	   picture.pcounter=0;
        	   Intent i=new Intent(picture4.this,MainActivity.class);
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
