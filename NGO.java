package com.example.vision;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class NGO extends BaseAdapter {
	
	private Context context; 
	private final String[] gridValues;

	//Constructor to initialize values
	public NGO(Context context, String[] gridValues) {
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

			if (mobile.equals("View NGO Info")) {
				
				imageView.setImageResource(R.drawable.a2);
				
			} 
			else if (mobile.equals("Registration")) {
				
				imageView.setImageResource(R.drawable.a3);
				
			} 
			else if (mobile.equals("Update Profile")) {
				
				imageView.setImageResource(R.drawable.a8);
				
			} 



		} 
		
		else {
			gridView = (View) convertView;
		}

		return gridView;
	}
}
