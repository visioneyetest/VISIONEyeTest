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

public class dr_info extends Activity {
	GridView gridView;

	static final String[] GRID_DATA = new String[] { "View Doctor Info" ,
			"Registration", "Update Profile"};
	
	String str2;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dr_info);

		//Get gridview object from xml file
		gridView = (GridView) findViewById(R.id.gridView1);

		// Set custom adapter (GridAdapter) to gridview
		gridView.setAdapter(new CustomGridAdapter(this, GRID_DATA));

		gridView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				
				Toast.makeText(
						getApplicationContext(),
					str2= (String) ((TextView) v.findViewById(R.id.grid_item_label))
								.getText(), Toast.LENGTH_SHORT).show();

				
				if(str2=="View Doctor Info")
				{
					Intent i=new Intent(dr_info.this,viewdr.class);
					startActivity(i);
					 finish();
				}
				
				else if(str2=="Registration")
				{
					Intent i=new Intent(dr_info.this,registration.class);
					startActivity(i);
					 finish();
				}
				
				else if(str2=="Update Profile")
				{
					Intent i=new Intent(dr_info.this,profile.class);
					startActivity(i);
					 finish();
				}
				
				
				
			}
		
					
			
			
		});
		
		
	}

}






