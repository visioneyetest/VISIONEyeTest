package com.example.vision;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class CustomGridAdapter extends BaseAdapter {
	
	private Context context; 
	private final String[] gridValues;

	//Constructor to initialize values
	public CustomGridAdapter(Context context, String[] gridValues) {
		this.context = context;
		this.gridValues = gridValues;
	}
	
	@Override
	public int getCount() {
		
		// Number of times getView method call depends upon gridValues.length
		return gridValues.length;
	}

	@Override
	public Object getItem(int position) {
		
		return null;
	}

	@Override
	public long getItemId(int position) {
		
		return 0;
	}

	
	
	
	
    // Number of times getView method call depends upon gridValues.length
	
	public View getView(int position, View convertView, ViewGroup parent) {

		//LayoutInflator to call external grid_item.xml file
		
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View gridView;

		if (convertView == null) {

			gridView = new View(context);

			// get layout from grid_item.xml
			gridView = inflater.inflate(R.layout.grid_item, null);

			// set value into textview
			
			TextView textView = (TextView) gridView
					.findViewById(R.id.grid_item_label);
			textView.setText(gridValues[position]);

			// set image based on selected text
			
			ImageView imageView = (ImageView) gridView
					.findViewById(R.id.grid_item_image);

			String mobile = gridValues[position];
			if (mobile.equals("Visual Acuity Test")) {
				
				imageView.setImageResource(R.drawable.a1);
				
			} 
			else if (mobile.equals("Ishihara Color Blindness Test")) {
				
				imageView.setImageResource(R.drawable.a2);
				
			} 
			else if (mobile.equals("Amsler Grid Test")) {
				
				imageView.setImageResource(R.drawable.a3);
				
			} 
			else if (mobile.equals("Duochrome Test")) {
				
				imageView.setImageResource(R.drawable.a4);
					
			}
			else if (mobile.equals("Landolt Test")) {
	
				imageView.setImageResource(R.drawable.a5);
	
			}
			else if (mobile.equals("Picture Test")) {
	
				imageView.setImageResource(R.drawable.a6);
	
			}
			else if (mobile.equals("Doctor Info")) {
	
				imageView.setImageResource(R.drawable.a7);
	
			}
			else if (mobile.equals("NGO Info")) {
	
				imageView.setImageResource(R.drawable.a8);
	
			}
			else if (mobile.equals("Medical Info")) {
	
				imageView.setImageResource(R.drawable.a9);
	
			}
			else if (mobile.equals("Manual")) {
	
				imageView.setImageResource(R.drawable.a10);
	
			}
			
			else if (mobile.equals("Feedback")) {
				
				imageView.setImageResource(R.drawable.a11);
			}
			//NEW CODE FOR NGO_INFO PAGE
			else if (mobile.equals("View NGO Info-")) {
				
				imageView.setImageResource(R.drawable.n1);
			}
			
			else if (mobile.equals("Registration-")) {
				
				imageView.setImageResource(R.drawable.n1);
			}
			
			else if (mobile.equals("Update Profile-")) {
				
				imageView.setImageResource(R.drawable.n1);
			}
			
			else if (mobile.equals("View Doctor Info")) {
				
				imageView.setImageResource(R.drawable.n1);
			}
			
			
			//NEW CODE FOR Dr_INFO PAGE
			else if (mobile.equals("View NGO Info")) {
				
				imageView.setImageResource(R.drawable.d1);
			}
			
			else if (mobile.equals("Registration")) {
				
				imageView.setImageResource(R.drawable.d1);
			}
			
			else if (mobile.equals("Update Profile")) {
				
				imageView.setImageResource(R.drawable.d1);
			}
			
			else if (mobile.equals("View Doctor Info")) {
				
				imageView.setImageResource(R.drawable.d1);
			}

		} 
		
		else {
			gridView = (View) convertView;
		}

		return gridView;
	}
}
