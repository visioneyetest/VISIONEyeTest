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

public class ngo_info extends Activity {
	GridView gridView;

	static final String[] GRID_DATA = new String[] { "View NGO Info-" ,
			"Registration-", "Update Profile-"};
	
	String str1;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ngo_info);

		//Get gridview object from xml file
		gridView = (GridView) findViewById(R.id.gridView1);

		// Set custom adapter (GridAdapter) to gridview
		gridView.setAdapter(new CustomGridAdapter(this, GRID_DATA));

		gridView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				
				Toast.makeText(
						getApplicationContext(),
					str1= (String) ((TextView) v.findViewById(R.id.grid_item_label))
								.getText(), Toast.LENGTH_SHORT).show();

				
				if(str1=="View NGO Info-")
				{Toast.makeText(getApplicationContext(), ""+str1,  Toast.LENGTH_SHORT).show();
				
				//	Intent i=new Intent(ngo_info.this,duochrome.class);
					Intent i=new Intent(ngo_info.this,viewngoinfo.class);
					startActivity(i);
					finish();
				}
				
				else if(str1=="Registration-")
				{Toast.makeText(getApplicationContext(), ""+str1,  Toast.LENGTH_SHORT).show();
				
					Intent i2=new Intent(ngo_info.this,ngoregistration.class);
					startActivity(i2);
					finish();
				}
				
				else if(str1=="Update Profile-")
				{Toast.makeText(getApplicationContext(), ""+str1,  Toast.LENGTH_SHORT).show();
				
					Intent i3=new Intent(ngo_info.this,ngoprofile.class);
					startActivity(i3);
					finish();
				}
				
				
				
			}
		
					
			
			
		});
		
		
	}

}






