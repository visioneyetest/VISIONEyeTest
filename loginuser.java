package com.example.vision;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginuser extends Activity {
Button submit,getid;
EditText eid,epass;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loginuser);
		
		submit=(Button)findViewById(R.id.button1);
		getid=(Button)findViewById(R.id.button2);
		eid=(EditText)findViewById(R.id.editText1);
		epass=(EditText)findViewById(R.id.editText2);
		loadid();
		//connect to registration page
		submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "homepage...",  Toast.LENGTH_SHORT).show();
				
				}
		});
		
		
	
	
	

	}
public void loadid()
{
	eid.setText(Remote_Data.did);
	eid.setText(Remote_Data.did);
}
	
}