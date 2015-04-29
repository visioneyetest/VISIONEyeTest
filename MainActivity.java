package com.example.vision;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {
	GridView gridView;

	static final String[] GRID_DATA = new String[] { "Visual Acuity Test" ,
			"Ishihara Color Blindness Test", "Amsler Grid Test" ,"Landolt Test","Duochrome Test" ,
			"Picture Test", "Doctor Info" ,"NGO Info","Medical Info" ,
			"Manual", "Feedback"};
	
	String str;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//Get gridview object from xml file
		gridView = (GridView) findViewById(R.id.gridView1);

		// Set custom adapter (GridAdapter) to gridview
		gridView.setAdapter(new CustomGridAdapter(this, GRID_DATA));

		
		cleardata();
		
		gridView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				
				Toast.makeText(
						getApplicationContext(),
					str= (String) ((TextView) v.findViewById(R.id.grid_item_label))
								.getText(), Toast.LENGTH_SHORT).show();

				
				if(str=="Visual Acuity Test")
				{

//Toast.makeText(MainActivity.this,""+position,Toast.LENGTH_LONG).show();
					Intent i=new Intent(MainActivity.this,visual.class);
					startActivity(i);
				}
				
				else if(str=="Ishihara Color Blindness Test")
				{
					Intent i=new Intent(MainActivity.this,ishihara.class);
					startActivity(i);
					
//			Toast.makeText(MainActivity.this,""+position,Toast.LENGTH_LONG).show();
				}
				
				else if(str=="Amsler Grid Test")
				{
					Intent i=new Intent(MainActivity.this,amsler.class);
					startActivity(i);
				}
				
				else if(str=="Duochrome Test")
				{
					Intent i=new Intent(MainActivity.this,duochrome.class);
					startActivity(i);
				}
				
				else if(str=="Landolt Test")
				{
					Intent i=new Intent(MainActivity.this,landolt.class);
					startActivity(i);
				}
				if(str=="Picture Test")
				{
					Intent i=new Intent(MainActivity.this,picture.class);
					startActivity(i);
				}
				
				if(str=="Doctor Info")
				{
					Intent i=new Intent(MainActivity.this,dr_info.class);
					startActivity(i);
				}
				
				if(str=="NGO Info")
				{
					Intent i=new Intent(MainActivity.this,ngo_info.class);
					startActivity(i);
				}
				
				if(str=="Medical Info")
				{
					Intent i=new Intent(MainActivity.this,medical_info.class);
					startActivity(i);
				}
				
				if(str=="Manual")
				{
					Intent i=new Intent(MainActivity.this,manual.class);
					startActivity(i);
				}
				
				if(str=="Feedback")
				{
					Intent i=new Intent(MainActivity.this,feedback.class);
					startActivity(i);
				}
				
				
			}
		
					
			
			
		});
		
		
}

	
	public void cleardata()
	{//Toast.makeText(MainActivity.this,"Welcome To Home Page",Toast.LENGTH_LONG).show();
		amsler.counter=0;
		ishihara.icounter=0;
	landolt.lcounter=0;	
	picture.pcounter=0;
	visual.vcounter=0;
	}
}






