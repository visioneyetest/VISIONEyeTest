package com.example.vision;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;




import android.R.integer;
import android.app.LauncherActivity.ListItem;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Remote_Data extends AsyncTask<String,Void,String> 
{
	 HttpResponse response;
	 HttpGet request ;
	 URL url;
	 int d_id,n_id;
	 String strLink,a,Str1,Str2,cnt,strId,strName,strContact,strUserId,strUserName,usrnm,con;	
	 String p_name,p_add,p_con,c_name,c_con,feed,dates,p_edu,p_pass,p_id,d_name,d_add,d_con,d_edu,d_pass;
	 String n_name,n_add,n_con,n_inch,n_pass;
		
	 public static String tes="";
	 HttpClient client;
	 EditText etxt1,etxt2,etxt3,etxt4,etxt5;
	 TextView txt1,txt2;
	 Context context;
	 EditText dnm,dad,dcon,dedu,dpas;//for dr
	 EditText nnm,nad,ncon,ninch,npas;//for ngo
	 TextView idd;
	public static int drid=0,loginid=0,ngoid=0,ngologinid=0;
	public static int did=0,nid=0;
	public static String ok;
	public static long l=0;
	public static String ok1,or;
	public static int ok2=10;
	public static int j=0;
	DatabaseHandler db,db1;

	public Remote_Data(Context context,String p_name,String p_add,String p_con,String p_edu,String p_pass)
	{//4
		this.context=context;
		
		this.p_name=p_name.toString().replaceAll("\\s+","_");

		this.p_add=p_add.toString().replaceAll("\\s+","_");

		this.p_con=p_con.toString();
		this.p_edu=p_edu.toString().replaceAll("\\s+","_");

		this.p_pass=p_pass.toString().replaceAll("\\s+","_");

		a="userreg";
		//registration
	}
	
	public Remote_Data(Context context,int n,String p_name,String p_add,String p_con,String p_edu,String p_pass)
	{//4
		this.context=context;
		
		this.n_name=p_name.toString().replaceAll("\\s+","_");

		this.n_add=p_add.toString().replaceAll("\\s+","_");

		this.n_con=p_con.toString();
		this.n_inch=p_edu.toString().replaceAll("\\s+","_");

		this.n_pass=p_pass.toString().replaceAll("\\s+","_");

		a="ngoreg";
		//registration
	}
	public Remote_Data(Context context,String strUserName,String strContact)
	{//1
		this.context=context;

		this.strUserName=strUserName;
		this.strContact=strContact;
		a="getid";
		

		//getiddoctor
	}	

	public Remote_Data(Context context,int k,String strUserName,String strContact)
	{//1
		this.context=context;

		this.strUserName=strUserName;
		this.strContact=strContact;
		a="getngoid";
		

		//getidngo
	}	
	public Remote_Data(Context context,String p_id,String p_pass,int i)
	{//1
		this.context=context;

		this.p_id=p_id;
		this.p_pass=p_pass;
		a="loginid";
		

		//getid
	}	

	public Remote_Data(Context context,int k,int j,String p_id,String p_pass)
	{//1
		this.context=context;

		this.p_id=p_id;
		this.p_pass=p_pass;
		a="ngologinid";
		
		

		//getid
	}	
	
	
	public Remote_Data(Context context,String selectdrinfo)
	{//3
		this.context=context;		
		a="selectdrinfo";		
	//selectall
		
	}

	
	public Remote_Data(Context context,int n,String selectngoinfo)
	{//3
		this.context=context;		
		a="selectngoinfo";		
	//selectall ngoinfo
		
	}

	public Remote_Data(Context context,TextView idd,EditText dnm,EditText dad,EditText dcon,EditText dedu,EditText dpas,int did)
	{//3
		this.context=context;		
		this.idd=idd;
		this.dnm=dnm;
		this.dad=dad;
		this.dcon=dcon;
		this.dedu=dedu;
		this.dpas=dpas;
		this.d_id=did;
		a="displaydrinfo";	
		
	//selectall dr info for update
		
	}
	public Remote_Data(Context context,TextView idd,EditText nnm,EditText nad,EditText ncon,EditText ninch,EditText npas,int nid,int did)
	{//3

		this.context=context;		
		this.idd=idd;
		this.nnm=nnm;
		this.nad=nad;
		this.ncon=ncon;
		this.ninch=ninch;
		this.npas=npas;
		this.n_id=nid;
		a="displayngoinfo";	
		
	//selectall ngo to for update
		
	}
	public Remote_Data(Context context,String p_name,String p_add,String p_con,String c_name,String c_con,String feed,String dates)
	{
		this.context=context;
		this.p_name=p_name;
		this.p_add=p_add;
		this.p_con=p_con;
		this.c_name=c_name;
		this.c_con=c_con;
		this.feed=feed;
		this.dates=dates;
		a="writefeedback";
		tes=""+p_name+p_add+p_con+c_name+c_con+feed+dates;
        		}

public Remote_Data(Context context,String d_name,String d_add,String d_con,String d_edu,String d_pass,int d_id)

{
	this.context=context;
	this.d_name=d_name;
	this.d_add=d_add;
	this.d_con=d_con;
	this.d_edu=d_edu;
	this.d_pass=d_pass;
	this.d_id=d_id;
	
	a="update";
	}

public Remote_Data(Context context,String n_name,String n_add,String n_con,String n_inch,String n_pass,int n_id,String update)

{
	this.context=context;
	this.n_name=n_name;
	this.n_add=n_add;
	this.n_con=n_con;
	this.n_inch=n_inch;
	this.n_pass=n_pass;
	this.n_id=n_id;
	a="nupdate";
	
	}
@Override
	protected String doInBackground(String... arg0) 
	{
		// TODO Auto-generated method stub	
		
        try {
        	
        	String disid=String.valueOf(d_id);
        	String disnid=String.valueOf(n_id);
     
        	if(a=="userreg")
        	{	String name=p_name.toString().replaceAll("\\s+","_");
    		   String add=p_add.toString().replaceAll("\\s+","_");
    		   String con=p_con.toString().replaceAll("\\s+","_");
    		   String edu=p_edu.toString().replaceAll("\\s+","_");
    		   String pass= p_pass.toString().replaceAll("\\s+","_");

    			strLink = "http://192.168.0.65/visionPHP/registration.php?name="+name+"&add="+add+"&con="+con+"&edu="+edu+"&pass="+pass;
        	    
        		url = new URL(strLink);
        		client = new DefaultHttpClient();
        		request = new HttpGet();
        		request.setURI(new URI(strLink));
        		response = client.execute(request);
        	
        	}
        	else if(a=="ngoreg")
            	{	String name=n_name.toString().replaceAll("\\s+","_");
        		   String add=n_add.toString().replaceAll("\\s+","_");
        		   String con=n_con.toString().replaceAll("\\s+","_");
        		   String inc=n_inch.toString().replaceAll("\\s+","_");
        		   String pass= n_pass.toString().replaceAll("\\s+","_");

        		strLink = "http://192.168.0.65/visionPHP/ngoreg.php?ngoname="+name+"&ngoadd="+add+"&ngocon="+con+"&ngoincharge="+inc+"&ngopass="+pass;
            	    
            		url = new URL(strLink);
            		client = new DefaultHttpClient();
            		request = new HttpGet();
            		request.setURI(new URI(strLink));

            		response = client.execute(request);
            		     	
            	}

        	else if(a=="update")
            	{	String name=d_name.toString().replaceAll("\\s+","_");
        		   String add=d_add.toString().replaceAll("\\s+","_");
        		   String con=d_con.toString().replaceAll("\\s+","_");
        		   String edu=d_edu.toString().replaceAll("\\s+","_");
        		   String pass=d_pass.toString().replaceAll("\\s+","_");
        		   int id=d_id;
        		  	strLink = "http://192.168.0.65/visionPHP/update.php?name="+name+"&add="+add+"&con="+con+"&edu="+edu+"&pass="+pass+"&id="+id;
            	    
            		url = new URL(strLink);
            		client = new DefaultHttpClient();
            		request = new HttpGet();
            		request.setURI(new URI(strLink));
            		response = client.execute(request);
            	
            	}
        	else if(a=="nupdate")
        	{	String name=n_name.toString().replaceAll("\\s+","_");
    		   String add=n_add.toString().replaceAll("\\s+","_");
    		   String con=n_con.toString().replaceAll("\\s+","_");
    		   String inch=n_inch.toString().replaceAll("\\s+","_");
    		   String pass=n_pass.toString().replaceAll("\\s+","_");
    		   int id=n_id;
    		  strLink = "http://192.168.0.65/visionPHP/ngoupdate.php?ngoname="+name+"&ngoadd="+add+"&ngocon="+con+"&ngoinch="+inch+"&ngopass="+pass+"&id="+id;
        	
    		   url = new URL(strLink);
        		client = new DefaultHttpClient();
        		request = new HttpGet();
        		request.setURI(new URI(strLink));
        		response = client.execute(request);
        	
        	}

        		else if(a=="getid")
        	{

        		String strName1=strUserName.toString().replaceAll("\\s+","_");	
        		String con=strContact.toString();
        		//1st col    
        	

        		strLink = "http://192.168.0.65/visionPHP/getid.php?name="+strName1+"&contact="+con;
        		//strLink = "http://192.168.0.65/table.php?name=md&contact=8888888888";
            	 
        		url = new URL(strLink);
        		client = new DefaultHttpClient();
        		request = new HttpGet();
        		request.setURI(new URI(strLink));
        		response = client.execute(request);
        
        	} 
        		else if(a=="getngoid")
        	{

        		String strName1=strUserName.toString().replaceAll("\\s+","_");	
        		String con=strContact.toString();
        		//1st col    
        	
        		
        		strLink = "http://192.168.0.65/visionPHP/ngoid.php?ngoname="+strName1+"&ngocon="+con;
        		//strLink = "http://192.168.0.65/table.php?name=md&contact=8888888888";
            	 
        		url = new URL(strLink);
        		client = new DefaultHttpClient();
        		
        		request = new HttpGet();
        		request.setURI(new URI(strLink));
        		response = client.execute(request);
        
        	} 
        	        	
        	else if(a=="writefeedback")
        	{
        		

        		String p_name1=p_name.toString().replaceAll("\\s+","_");
        		String p_add1=p_add.toString().replaceAll("\\s+","_");
        		String p_con1=p_con.toString();
        		String c_name1=c_name.toString().replaceAll("\\s+","_");
        		String c_con1=c_con.toString();
        		String feed1=feed.toString().replaceAll("\\s+","_");
        		String dates1=dates.toString().replaceAll("\\s+","+");
        	   
        		
            	//strLink="http://192.168.0.65/order.php?order_id=1&table_id=2&order_itid=4&order_item=dg&order_price=78&order_quantity=58&order_ototal=45&order_tips=hgfh&order_status=Pending";
        		
            	strLink="http://192.168.0.65/visionPHP/feedback.php?p_name="+p_name1+"&p_add="+p_add1+"&p_con="+p_con1+"&c_name="+c_name1+"&c_con="+c_con1+"&feed="+feed1+"&dates="+dates1;
        		//or=""+O_ITEMS1+O_OITID1+O_OTOTAL1+O_OID1+O_TID1+O_PRICE1+O_QTY1+O_STATUS1;
            	
        		url = new URL(strLink);
            	
            	client = new DefaultHttpClient();
        		request = new HttpGet();
        		request.setURI(new URI(strLink));
        		
        		response = client.execute(request);
        		
        	}
        	else if(a=="selectdrinfo")
        	{
        		strLink = "http://192.168.0.65/visionPHP/selectdrinfo.php";
        		//strLink = "http://192.168.4.131/selectall.php";
        		url = new URL(strLink);
        		client = new DefaultHttpClient();
        		request = new HttpGet();
        		request.setURI(new URI(strLink));
        		response = client.execute(request);
        		ok1="kk";
        	}
        	else if(a=="selectngoinfo")
        	{
        		strLink = "http://192.168.0.65/visionPHP/selectngoinfo.php";
        		//strLink = "http://192.168.4.131/selectall.php";
        		url = new URL(strLink);
        		client = new DefaultHttpClient();
        		request = new HttpGet();
        		request.setURI(new URI(strLink));
        		response = client.execute(request);
        	}
        	else if(a=="loginid")
        	{

        		String uid=p_id.toString();	
        		String upass=p_pass.toString();
        		//1st col    
        	

        		strLink = "http://192.168.0.65/visionPHP/login.php?uid="+uid+"&upass="+upass;
        		//strLink = "http://192.168.0.65/table.php?name=md&contact=8888888888";
            	 
        		url = new URL(strLink);
        		client = new DefaultHttpClient();
        		request = new HttpGet();
        		request.setURI(new URI(strLink));
        		response = client.execute(request);
        
        	} //ngologinid
        	else if(a=="ngologinid")
        	{

        		String uid=p_id.toString();	
        		String upass=p_pass.toString();
        		//1st col    
        	

        		strLink = "http://192.168.0.65/visionPHP/ngologin.php?uid="+uid+"&upass="+upass;
        		//strLink = "http://192.168.0.65/table.php?name=md&contact=8888888888";
            	 
        		url = new URL(strLink);
        		client = new DefaultHttpClient();
        		request = new HttpGet();
        		request.setURI(new URI(strLink));
        		response = client.execute(request);
        
        	}
        
        	//this.txt1.setText (json_data.getString("id"));
        		//displaydrinfo
        	else if(a=="displaydrinfo")
        	{
        		
        	   
            	//strLink="http://192.168.0.65/order.php?order_id=1&table_id=2&order_itid=4&order_item=dg&order_price=78&order_quantity=58&order_ototal=45&order_tips=hgfh&order_status=Pending";
        		
            	strLink="http://192.168.0.65/visionPHP/displaydrinfo.php?id="+disid;
        		//or=""+O_ITEMS1+O_OITID1+O_OTOTAL1+O_OID1+O_TID1+O_PRICE1+O_QTY1+O_STATUS1;
            	
            			url = new URL(strLink);
            	
            	client = new DefaultHttpClient();
        		request = new HttpGet();
        		request.setURI(new URI(strLink));
        	
        		response = client.execute(request);
        		
        	}
        	else if(a=="displayngoinfo")
        	{
        		
        	   
            	//strLink="http://192.168.0.65/order.php?order_id=1&table_id=2&order_itid=4&order_item=dg&order_price=78&order_quantity=58&order_ototal=45&order_tips=hgfh&order_status=Pending";
        		
            	strLink="http://192.168.0.65/visionPHP/displayngoinfo.php?id="+disnid;
        		//or=""+O_ITEMS1+O_OITID1+O_OTOTAL1+O_OID1+O_TID1+O_PRICE1+O_QTY1+O_STATUS1;
            	
            			url = new URL(strLink);
            	
            	client = new DefaultHttpClient();
        		request = new HttpGet();
        		request.setURI(new URI(strLink));
        	
        		response = client.execute(request);
        	
        		}
        
	        BufferedReader in = new BufferedReader
          		  (new InputStreamReader(response.getEntity().getContent()));

            StringBuffer sb = new StringBuffer("");
            String line="";
            while ((line = in.readLine()) != null) {
          	  sb.append(line);
          	  break;
          	  
            }
            
            in.close(); 
    
            return sb.toString();
            
		
     }
        
        catch (Exception e) 
        {
			// TODO Auto-generated catch block
			 return new String("Exception: " + e.getMessage());
		}

		
		 
	}
	  @Override
	   protected void onPostExecute(String result)
	  {
		  	 
		  try {
			  JSONObject json_data;
			  if(a=="getid")
					   {		
				  json_data = new JSONObject(result);
				

				  did=Integer.parseInt(json_data.getString("id"));			
				 profile.userid=did;
				 ok="registration";
				 drid=did;	
					
					   }
			  
			  
			  //getngoid
			  else if(a=="getngoid")
			   {		
		  json_data = new JSONObject(result);
		

		  nid=Integer.parseInt(json_data.getString("id"));			
		 ngoprofile.userid=nid;
		 ok="ngo";
		 ngoid=nid;	
			
			   }
	  
	  	else if(a=="loginid")
			   {		
		  json_data = new JSONObject(result);
		

		  int lid=Integer.parseInt(json_data.getString("lid"));			
		  loginid=lid;
			   }
			  
	  	else if(a=="ngologinid")
		   {		
	  json_data = new JSONObject(result);
	

	  int nid=Integer.parseInt(json_data.getString("nid"));			
	  ngologinid=nid;
		   }
		  
		  			  
			  else if(a=="displaydrinfo")
			  {		
					json_data = new JSONObject(result);
				  		this.idd.setText(json_data.getString("id"));
				  		this.dnm.setText(json_data.getString("name"));
			 	 		this.dad.setText(json_data.getString("add"));
			 	 		this.dcon.setText(json_data.getString("con"));
			 	 		this.dedu.setText(json_data.getString("ed"));
			 	 		this.dpas.setText(json_data.getString("pass"));
			 	 	
			  }
			  else if(a=="displayngoinfo")
			  {		
					json_data = new JSONObject(result);
				  		this.idd.setText(json_data.getString("id"));
				  		this.nnm.setText(json_data.getString("name"));
			 	 		this.nad.setText(json_data.getString("add"));
			 	 		this.ncon.setText(json_data.getString("con"));
			 	 		this.ninch.setText(json_data.getString("inch"));
			 	 		this.npas.setText(json_data.getString("pass"));
			 	 
    		  }
			  else if(a=="selectdrinfo")
			  {		
					json_data = new JSONObject(result);
				  	db1= new DatabaseHandler(context);
				  	int count=Integer.parseInt(json_data.getString("countrow"));				 
			  

				  	for(int  i=0;i<count;i++)
				  	{
				  		String item_id=json_data.getString("dr_id"+i).toString();				
			 			int g=db1.checkData(item_id);

						if(g==1)				  
						{
							long one=Integer.parseInt(json_data.getString("dr_id"+i).toString());
							String dname=json_data.getString("dr_name"+i).toString();
						
							String dadd= json_data.getString("dr_add"+i).toString();
						
							String dcon=json_data.getString("dr_con"+i).toString();
						
							String dedu= json_data.getString("dr_edu"+i).toString();
						
							db1.updateLocaldr(one,dname,dadd,dcon,dedu);
			ok2=40;			
						}
						else
							
						{
						
			 				String id=json_data.getString("dr_id"+i).toString();				
			 				ok2=20;
							String dname=json_data.getString("dr_name"+i).toString();
							
						
							String dadd= json_data.getString("dr_add"+i).toString();
							
						
							String dcon=json_data.getString("dr_con"+i).toString();
							
						
							String dedu= json_data.getString("dr_edu"+i).toString();
							
											
							db1.insertDr(id,dname,dadd,dcon,dedu);					
							
						}	
				  	
			  
				  	}
			  }


			  else if(a=="selectngoinfo")
			  {		
					json_data = new JSONObject(result);
				  	db1= new DatabaseHandler(context);
				  	int count=Integer.parseInt(json_data.getString("countrow"));				 
			  

				  	for(int  i=0;i<count;i++)
				  	{
				  		String item_id=json_data.getString("ngo_id"+i).toString();				
			 			int g=db1.checkData2(item_id);

						if(g==1)				  
						{
							long one=Integer.parseInt(json_data.getString("ngo_id"+i).toString());
							String nname=json_data.getString("ngo_name"+i).toString();
						
							String nadd= json_data.getString("ngo_add"+i).toString();
						
							String ncon=json_data.getString("ngo_con"+i).toString();
						
							String nicn= json_data.getString("ngo_inch"+i).toString();
						
							
							db1.updateLocalngo(one,nname,nadd,ncon,nicn);
			ok2=40;			
						}
						else
							
						{
						
			 				long one=Integer.parseInt(json_data.getString("ngo_id"+i).toString());
							String nname=json_data.getString("ngo_name"+i).toString();
						
							String nadd= json_data.getString("ngo_add"+i).toString();
						
							String ncon=json_data.getString("ngo_con"+i).toString();
						
							String nicn= json_data.getString("ngo_inch"+i).toString();
							db1.insertNgo(one,nname,nadd,ncon,nicn);					
							
						}	
				  	
			  
				  	}
			  }


		  
		  }


		  
	
		  catch (JSONException e) 
		  {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	 
	  
	  
	 
	  }
	 
}
