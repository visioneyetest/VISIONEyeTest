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

public class ngoregistration extends Activity {
Button submit,get,display,delete;
public static String uname,contact;
EditText etxName,etxAdd,etxContact,etxinchu,etxPass;

	@Override
	protected void onCreate(Bundle savinchInstanceState) {
		super.onCreate(savinchInstanceState);
		setContentView(R.layout.ngoregistration);
		
		submit=(Button)findViewById(R.id.button5);
		get=(Button)findViewById(R.id.button2);
		display=(Button)findViewById(R.id.button3);
delete=(Button)findViewById(R.id.button4);

etxName=(EditText)findViewById(R.id.editText1);  
etxAdd=(EditText)findViewById(R.id.editText2);  
		etxContact=(EditText)findViewById(R.id.editText3);  
		etxinchu=(EditText)findViewById(R.id.editText4);  
		etxPass=(EditText)findViewById(R.id.editText5);  
		
		//connect to registration page
		submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generatinch method stub
				String ngoinfo="";
				int n=1;
							
					
						uname=etxName.getText().toString().replaceAll("\\s+","_");
							contact=etxContact.getText().toString().replaceAll("\\s+","_");
							
								
							String name=etxName.getText().toString().replaceAll("\\s+","_");
							String addr=etxAdd.getText().toString().replaceAll("\\s+","_");
							String pass=etxPass.getText().toString().replaceAll("\\s+","_");
							String con=etxContact.getText().toString().replaceAll("\\s+","_");
							String inch=etxinchu.getText().toString().replaceAll("\\s+","_");
							
							new Remote_Data(getApplicationContext(),n,name,addr,con,inch,pass).execute("");
			Toast.makeText(getApplicationContext(), "registration..."+name+addr+con+inch+pass,  Toast.LENGTH_SHORT).show();
											
							//getid
							new Remote_Data(getApplicationContext(),n,name,con).execute("");
							Toast.makeText(getApplicationContext(), "id-n"+n,  Toast.LENGTH_SHORT).show();
											
							int doctorid=Remote_Data.nid;
							finish();	
						}
					
		});
		
		
	


delete.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
	
				// TODO Auto-generated method stub

				DatabaseHandler db = new DatabaseHandler(getApplicationContext());
				long sd=db.deleteNgo();
				
				Toast.makeText(ngoregistration.this, "deletedr..."+String.valueOf(sd),5).show();
				
				String name=etxName.getText().toString().replaceAll("\\s+","_");
				String con=etxContact.getText().toString().replaceAll("\\s+","_");
				getid(name, con);
			}
		});
		
		
		
	
get.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				String ngoinfo="";
				// TODO Auto-generated method stub
int n=1;
				new Remote_Data(getApplicationContext(),n,ngoinfo).execute("");
				
						
				DatabaseHandler db = new DatabaseHandler(getApplicationContext());
				
				Cursor c = (Cursor) db.getNgodata();
				
							if (c.moveToLast())
							{
								do {
									DisplayContact(c);
								} while (c.moveToNext());
							}
							
							else
							{
								Toast.makeText(ngoregistration.this, "norecords",Toast.LENGTH_SHORT).show();
												
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
									"\n" +"inch" + c.getString(4),						
									Toast.LENGTH_SHORT).show();
							
					
			    				
						}

				
		});
		

display.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		DatabaseHandler db = new DatabaseHandler(getApplicationContext());
		
	Cursor c = (Cursor) db.getNgodata();
	
				if (c.moveToLast())
				{
					do {
						DisplayContact(c);
					} while (c.moveToNext());
				}
				
				else
				{
					Toast.makeText(ngoregistration.this, "norecords",Toast.LENGTH_SHORT).show();
									
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
						"\n" +"ngo" + c.getString(4),						
						Toast.LENGTH_SHORT).show();
				
		
    				
			}

	
});


	}

	public void getid(String name,String con)
	{ int n=1;
		new Remote_Data(getApplicationContext(),n,name,con).execute("");
		new Remote_Data(getApplicationContext(),n,name,con).execute("");
		new Remote_Data(getApplicationContext(),n,name,con).execute("");
		new Remote_Data(getApplicationContext(),n,name,con).execute("");
		new Remote_Data(getApplicationContext(),n,name,con).execute("");
		new Remote_Data(getApplicationContext(),n,name,con).execute("");
		new Remote_Data(getApplicationContext(),n,name,con).execute("");
		new Remote_Data(getApplicationContext(),n,name,con).execute("");
		new Remote_Data(getApplicationContext(),n,name,con).execute("");
		new Remote_Data(getApplicationContext(),n,name,con).execute("");
	}
}