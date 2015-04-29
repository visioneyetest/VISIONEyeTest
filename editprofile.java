package com.example.vision;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class editprofile extends Activity {
Button submit,get;
EditText nm,ad,con,edu,pass;
TextView did;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.editprofile);
		
		submit=(Button)findViewById(R.id.button1);
		get=(Button)findViewById(R.id.button2);
		nm=(EditText)findViewById(R.id.editText1);
		ad=(EditText)findViewById(R.id.editText2);
		con=(EditText)findViewById(R.id.editText3);
		edu=(EditText)findViewById(R.id.editText4);
		pass=(EditText)findViewById(R.id.editText5);
		did=(TextView)findViewById(R.id.textView1);
		//connect to registration page
		submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 Toast.makeText(editprofile.this, "Your profile edit successfully..",Toast.LENGTH_LONG ).show();
			//update
				
					int id=profile.loginid1;
					String name=nm.getText().toString().replaceAll("\\s+","_");
					 String addr=ad.getText().toString().replaceAll("\\s+","_");	
					String conn=con.getText().toString().replaceAll("\\s+","_");
					String ed=edu.getText().toString().replaceAll("\\s+","_");
					String pas=pass.getText().toString().replaceAll("\\s+","_");
					
					new Remote_Data(getApplicationContext(),name,addr,conn,ed,pas,id).execute("");	
				Intent i=new Intent(editprofile.this,MainActivity.class);
				startActivity(i);
				 finish();
			}
		});

		get.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				 
				int id=profile.loginid1;
				 Toast.makeText(editprofile.this,""+id,5).show();
								
			new Remote_Data(getApplicationContext(),did,nm,ad,con,edu,pass,id).execute("");
			}
		});
		
	
	
	

	}

	
}