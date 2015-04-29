package com.example.vision;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class medical_info extends Activity {
Button disease, symptoms;
String strLink1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.medical_info);
		
		disease=(Button)findViewById(R.id.button1);
		
		
		
		//connect to registration page
		disease.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Toast.makeText(getApplicationContext(), "Diseases from A to Z..",  Toast.LENGTH_SHORT).show();
			    CopyAssets();
				//Intent i=new Intent(medical_info.this,eyedisease.class);
				//startActivity(i);
			    
			}
		});
		
		
		/*//connect to registration page
				symptoms.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						Toast.makeText(getApplicationContext(), "edit profile...",  Toast.LENGTH_SHORT).show();
						
						Intent i=new Intent(medical_info.this,eyedisease.class);
						startActivity(i);
						  
					}
				});*/
				
	
	

	}

	 private void CopyAssets() {

	        AssetManager assetManager = getAssets();

	        InputStream in = null;
	        OutputStream out = null;
	        File file = new File(getFilesDir(), "disease.pdf");
	        try {
	            in = assetManager.open("disease.pdf");
	            out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);
Toast.makeText(medical_info.this,""+out,5).show();
	            copyFile(in, out);
	            in.close();
	            in = null;
	            out.flush();
	            out.close();
	            out = null;
	        } catch (Exception e) {
	            Log.e("tag", e.getMessage());
	        }

	        Intent intent = new Intent(Intent.ACTION_VIEW);
	        intent.setDataAndType(
	                Uri.parse("file://" + getFilesDir() + "/disease.pdf"),
	                "application/pdf");

	        startActivity(intent);
	    }

	    private void copyFile(InputStream in, OutputStream out) throws IOException {
	        byte[] buffer = new byte[1024];
	        int read;
	        while ((read = in.read(buffer)) != -1) {
	            out.write(buffer, 0, read);
	        }
	    }

	
}