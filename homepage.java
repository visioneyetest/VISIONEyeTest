

package com.example.vision;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class homepage extends Activity {
Button test, ngo, dr, medical, manual, wfeed;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.homepage);
		
		test=(Button)findViewById(R.id.button1);
		ngo=(Button)findViewById(R.id.button2);
		dr=(Button)findViewById(R.id.button3);
		medical=(Button)findViewById(R.id.button4);
		manual=(Button)findViewById(R.id.button5);
		wfeed=(Button)findViewById(R.id.button6);
		//connect to test page
		test.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "testttttttt",  Toast.LENGTH_SHORT).show();
				
				Intent i=new Intent(homepage.this,test.class);
				startActivity(i);
				  
			}
		});
		
		//connect to feedback page
	wfeed.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(homepage.this,feedback.class);
				startActivity(i);
				 Toast.makeText(getApplicationContext(), "feedbackkk",  Toast.LENGTH_SHORT).show();
					
				
			}
		});
	
	//connect to NGO page
	ngo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(homepage.this,ngo_info.class);
				startActivity(i);
				 Toast.makeText(getApplicationContext(), "Select NGO Location",  Toast.LENGTH_SHORT).show();
					
				
			}
		});
	
	//connect to NGO page
		dr.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent i=new Intent(homepage.this,dr_info.class);
					startActivity(i);
					 Toast.makeText(getApplicationContext(), "Select dr Location",  Toast.LENGTH_SHORT).show();
						
					
				}
			});
		
manual.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "testttttttt",  Toast.LENGTH_SHORT).show();
				
				Intent i=new Intent(homepage.this,manual.class);
				startActivity(i);
				  
			}
		});


medical.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Toast.makeText(getApplicationContext(), "testttttttt",  Toast.LENGTH_SHORT).show();
		
		Intent i=new Intent(homepage.this,medical_info.class);
		startActivity(i);
		  
	}
});
	}

	
}
