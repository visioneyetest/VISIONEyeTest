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

public class registration extends Activity {
Button submit,get,display,delete;
public static String uname,contact;
EditText etxName,etxAdd,etxContact,etxEdu,etxPass;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registration);
		
		submit=(Button)findViewById(R.id.button1);
		get=(Button)findViewById(R.id.button2);
		display=(Button)findViewById(R.id.button3);
delete=(Button)findViewById(R.id.button4);

etxName=(EditText)findViewById(R.id.editText1);  
etxAdd=(EditText)findViewById(R.id.editText2);  
		etxContact=(EditText)findViewById(R.id.editText3);  
		etxEdu=(EditText)findViewById(R.id.editText4);  
		etxPass=(EditText)findViewById(R.id.editText5);  
			
		
		//connect to registration page
		submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String selectdrinfo="";
				
		
			uname=etxName.getText().toString().replaceAll("\\s+","_");
				contact=etxContact.getText().toString().replaceAll("\\s+","_");
				
				String addr=etxAdd.getText().toString().replaceAll("\\s+","_");
				String pass=etxPass.getText().toString().replaceAll("\\s+","_");
					
				String name=etxName.getText().toString().replaceAll("\\s+","_");
				
				
				String con=etxContact.getText().toString().replaceAll("\\s+","_");
				String ed=etxEdu.getText().toString().replaceAll("\\s+","_");
				
				new Remote_Data(getApplicationContext(),name,addr,con,ed,pass).execute("");
				
				Toast.makeText(getApplicationContext(), ""+Remote_Data.ok,  Toast.LENGTH_SHORT).show();
				//getid
				new Remote_Data(getApplicationContext(),name,con).execute("");
				
				int doctorid=Remote_Data.did;
				Toast.makeText(registration.this, "Your Id"+Remote_Data.did,Toast.LENGTH_SHORT).show();
			  	   finish();
			}
		});
		

		

delete.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				String selectdrinfo="";
				// TODO Auto-generated method stub

				DatabaseHandler db = new DatabaseHandler(getApplicationContext());
				long sd=db.deleteDr();
				
				Toast.makeText(registration.this, "deletedr..."+String.valueOf(sd),5).show();
				
				String name=etxName.getText().toString().replaceAll("\\s+","_");
				String con=etxContact.getText().toString().replaceAll("\\s+","_");
				getid(name, con);
			}
		});
		
		
		
	
get.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				DatabaseHandler db = new DatabaseHandler(getApplicationContext());
				
				String selectdrinfo="";
				// TODO Auto-generated method stub
				new Remote_Data(getApplicationContext(),selectdrinfo).execute("");
				
						
				Toast.makeText(registration.this, "selectAll"+Remote_Data.ok2,Toast.LENGTH_SHORT).show();
								  
				
				
				Cursor c = (Cursor) db.getDrdata();
				
							if (c.moveToLast())
							{
								do {
									DisplayContact(c);
								} while (c.moveToNext());
							}
							
							else
							{
								Toast.makeText(registration.this, "norecords",Toast.LENGTH_SHORT).show();
												
							}
							db.close();
						}
			 
						private void DisplayContact(Cursor c)
						{
							// TODO Auto-generated method stub
							Toast.makeText(getBaseContext(),"id " + c.getString(0)+
									"name " + c.getString(1)+
									"\n" +"address " + c.getString(2) + 
									"\n" +"con: " + c.getString(3) +
									"\n" +"edu" + c.getString(4),						
									Toast.LENGTH_SHORT).show();
							
					
			    				
						}

				
		});
		

display.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		DatabaseHandler db = new DatabaseHandler(getApplicationContext());
		
	Cursor c = (Cursor) db.getDrdata();
	
				if (c.moveToLast())
				{
					do {
						DisplayContact(c);
					} while (c.moveToNext());
				}
				
				else
				{
					Toast.makeText(registration.this, "norecords",Toast.LENGTH_SHORT).show();
									
				}
				db.close();
			}
 
			private void DisplayContact(Cursor c)
			{
				// TODO Auto-generated method stub
				Toast.makeText(getBaseContext(),"id " + c.getString(0)+
						"name " + c.getString(1)+
						"\n" +"address " + c.getString(2) + 
						"\n" +"con: " + c.getString(3) +
						"\n" +"edu" + c.getString(4),						
						Toast.LENGTH_SHORT).show();
				
		
    				
			}

	
});



	}
public void getid(String name,String con)
{
	new Remote_Data(getApplicationContext(),name,con).execute("");
	new Remote_Data(getApplicationContext(),name,con).execute("");
	new Remote_Data(getApplicationContext(),name,con).execute("");
	new Remote_Data(getApplicationContext(),name,con).execute("");
	new Remote_Data(getApplicationContext(),name,con).execute("");
	new Remote_Data(getApplicationContext(),name,con).execute("");
	new Remote_Data(getApplicationContext(),name,con).execute("");
	new Remote_Data(getApplicationContext(),name,con).execute("");
	new Remote_Data(getApplicationContext(),name,con).execute("");
	new Remote_Data(getApplicationContext(),name,con).execute("");
}
	
}