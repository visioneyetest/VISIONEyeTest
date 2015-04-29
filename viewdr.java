package com.example.vision;


import java.util.ArrayList;
import java.util.List;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class viewdr extends Activity {
Button  display,getfromnet;
ListView list;
private  ArrayList<String> Array1 = new ArrayList<String>();// to store list of selected views
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewdr);
		list=(ListView) findViewById(R.id.listView1);
		display=(Button)findViewById(R.id.button1);
		getfromnet=(Button)findViewById(R.id.button2);
		//connect to registration page
		display.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			loaddata();
			}
		});

		getfromnet.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				 String selectdrinfo="";
				new Remote_Data(getApplicationContext(),selectdrinfo).execute("");
				
				
				Toast.makeText(viewdr.this, "Geting all data...",Toast.LENGTH_SHORT).show();
				
			}
		});
		
	
	
	

	}

	public void loaddata()
	{	DatabaseHandler db = new DatabaseHandler(getApplicationContext());
    List<String> lables1 = db.getdrdata();
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
	        android.R.layout.simple_list_item_1, lables1);
    list.setAdapter(adapter);   

	
	}
	
}