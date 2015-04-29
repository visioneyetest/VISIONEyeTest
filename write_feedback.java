package com.example.vision;

import java.text.SimpleDateFormat;
import java.util.Date;


import com.example.vision.DatabaseHandler;

import android.R.string;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class write_feedback extends Activity {
Button submit,disp;
EditText  id,pname1,add1,con1,cname1,ccon1,feed1,dates1;
String pname,add,con,cname,ccon,feed,dates;	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.write_feedback);
		id=(EditText) findViewById(R.id.editText1);
		 pname1 = (EditText) findViewById(R.id.editText2);
		 add1 = (EditText) findViewById(R.id.editText3);
		 con1 = (EditText) findViewById(R.id.editText4);
		 cname1 = (EditText) findViewById(R.id.editText5);
		 ccon1 = (EditText) findViewById(R.id.editText6);
		 feed1 = (EditText) findViewById(R.id.editText7);
		 dates1 = (EditText) findViewById(R.id.editText8);
		 
		submit=(Button)findViewById(R.id.button1);
		disp=(Button)findViewById(R.id.button2);
		
		 submit.setOnClickListener(new View.OnClickListener() {
			 
			 
	            @Override
	            public void onClick(View arg0) {
	               
	            	  String pname = pname1.getText().toString();
		                String add = add1.getText().toString();
		                String con = con1.getText().toString();
		                String cname = cname1.getText().toString();
		                String ccon = ccon1.getText().toString();
		                String feed = feed1.getText().toString();
		                String dates = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		    			 //dates1.setText(dates.toString());
		               
		               
	                if (pname.trim().length() > 0) {
	                    DatabaseHandler db = new DatabaseHandler(getApplicationContext());
	                    db.insertUser(pname,add,con,cname,ccon,feed,dates.toString());
	                   // db.de();
	                    // making input filed text to blank
	                    pname1.setText("");
	                   add1.setText("");
	                   con1.setText("");
	                   cname1.setText("");
	                   ccon1.setText("");
	                   feed1.setText("");
	                   dates1.setText("");
	                   
	                    // Hiding the keyboard
	                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
	                    imm.hideSoftInputFromWindow(pname1.getWindowToken(), 0);
	                    imm.hideSoftInputFromWindow(add1.getWindowToken(), 0);
	                    imm.hideSoftInputFromWindow(con1.getWindowToken(), 0);
	                    imm.hideSoftInputFromWindow(cname1.getWindowToken(), 0);
	                    imm.hideSoftInputFromWindow(ccon1.getWindowToken(), 0);
	                    imm.hideSoftInputFromWindow(feed1.getWindowToken(), 0);
	                    
	                    
	                    Toast.makeText(getApplicationContext(), "Data insert successfully",  Toast.LENGTH_SHORT).show();
	      	                  
	                    finish();   
	                } 
	                else 
	                {
	                    Toast.makeText(getApplicationContext(), "Please enter name",
	                            Toast.LENGTH_SHORT).show();
	                }
	 
	            }
	        });
		 
		 

		 //display2 toast ALL AND IN TXT
	        disp.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
		DatabaseHandler db = new DatabaseHandler(getApplicationContext());
	                   
		Cursor c = (Cursor) db.getAllContacts();
					if (c.moveToFirst())
					{
						do {
							DisplayContact(c);
						} while (c.moveToNext());
					}
					db.close();
				}
	 
				private void DisplayContact(Cursor c)
				{
					// TODO Auto-generated method stub
					Toast.makeText(getBaseContext(),"pname " + c.getString(1) + "\n" +"add1: " + c.getString(2) + "\n" +
							"con1" + c.getString(3) +"\n" +"cname1" + c.getString(4) +"\n" +"ccon1" + c.getString(5) + "\n"+"feed1 " + c.getString(6)+ "\n"+"date " + c.getString(7),
							Toast.LENGTH_LONG).show();
					
					 id.setText(c.getString(0));
					  pname1.setText(c.getString(1));
	                   add1.setText(c.getString(2));
	                   con1.setText(c.getString(3));
	                   cname1.setText(c.getString(4));
	                   ccon1.setText(c.getString(5));
	                   feed1.setText(c.getString(6));
	                   dates1.setText(c.getString(7));
					
	    
			
		               
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
	 
		
		 