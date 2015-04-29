package com.example.vision;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class login extends Activity {
Button regi, login, profile;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		regi=(Button)findViewById(R.id.button1);
		login=(Button)findViewById(R.id.button2);
		profile=(Button)findViewById(R.id.button3);
		
		//connect to registration page
		regi.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "registration...",  Toast.LENGTH_SHORT).show();
				
				Intent i=new Intent(login.this,registration.class);
				startActivity(i);
				  
			}
		});
		
		//connect to login page
	login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(login.this,loginuser.class);
				startActivity(i);
				 Toast.makeText(getApplicationContext(), "login...",  Toast.LENGTH_SHORT).show();
					
				
			}
		});
	
	
	//connect to profile page
		profile.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent i=new Intent(login.this,profile.class);
					startActivity(i);
					 Toast.makeText(getApplicationContext(), "profile...",  Toast.LENGTH_SHORT).show();
						
					
				}
			});
		
	
	

	}

	
}