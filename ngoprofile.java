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

public class ngoprofile extends Activity {
Button editprofile;
EditText eidd,epass;
public static int userid=0,ngologinid1=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ngoprofile);
		
		editprofile=(Button)findViewById(R.id.button1);
		
		eidd=(EditText)findViewById(R.id.editText1);
		epass=(EditText)findViewById(R.id.editText2);
		//connect to registration page
		editprofile.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
	Toast.makeText(getApplicationContext(), "edit profile...",  Toast.LENGTH_SHORT).show();
				
				//if else getid
				String eid=eidd.getText().toString().replaceAll("\\s+","_");
								
								
								String epas=epass.getText().toString().replaceAll("\\s+","_");
								int k=0,j=0;
								new Remote_Data(getApplicationContext(),k,j,eid,epas).execute("");	
								
								if(Remote_Data.ngologinid==100==true)
								{
									ngologinid1=Integer.parseInt(eid);
									Toast.makeText(getApplicationContext(), "ngoedit",  Toast.LENGTH_SHORT).show();
											Intent i=new Intent(ngoprofile.this,ngoeditprofile.class);
								startActivity(i);
								finish();
								}
								else
								{
									Toast.makeText(getApplicationContext(), "Please try again...",  Toast.LENGTH_SHORT).show();
										
								}
											  
			}
		});
		
		
	
	
	

	}

	
}