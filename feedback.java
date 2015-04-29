package com.example.vision;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class feedback extends Activity {
Button write,submit;
String  pname,add,con,cname,ccon,feed,dates;
int count=0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.feedback);
		
		write=(Button)findViewById(R.id.button1);
		
	write.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(feedback.this,write_feedback.class);
				startActivity(i);
				 finish();
			}
	});
				
				
				submit=(Button)findViewById(R.id.button2);
				
				submit.setOnClickListener(new OnClickListener() {
						
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
											3).show();
									
	new Remote_Data(getApplicationContext(),c.getString(1).replaceAll("\\s+","_"),c.getString(2).replaceAll("\\s+","_"),c.getString(3),c.getString(4).replaceAll("\\s+","_"),c.getString(5),c.getString(6).replaceAll("\\s+","_"),c.getString(7).replaceAll("\\s+","+")).execute("");
													
					Toast.makeText(getApplicationContext(),""+Remote_Data.tes,3).show();    
							
						               
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
