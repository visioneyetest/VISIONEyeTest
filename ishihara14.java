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

public class ishihara14 extends Activity 
{
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ishihara14);
       
        Button stop = (Button) findViewById(R.id.button1);
        
       
        
        // -- register click event with second button ---
        stop.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {
               // --- find the text view --
               //TextView txtView = (TextView) findViewById(R.id.textView1);
               // -- change text size --
            // txtView.setText("Test Fail......");
        	   //Toast.makeText(amsler.this, "Sorry.....You are fail....",Toast.LENGTH_LONG ).show();
        	   ishihara.icounter=ishihara.icounter+1;
        	   Toast.makeText(getBaseContext(), "Your vision is good.... Your score is="+ishihara.icounter, 4).show();
        	   ishihara.icounter=0;
        	   Intent i=new Intent(ishihara14.this,MainActivity.class);
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
