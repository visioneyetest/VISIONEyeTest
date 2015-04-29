package com.example.vision;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
 
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
 
public class DatabaseHandler extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "Vision ";
 
    // Labels table name
    private static final String TABLE_LABELS = "write_feedback";
    private static final String TABLE_TODO_TAG = "dr_info";
    private static final String TABLE_TAG = "ngo_info";

 
    // Labels Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "patient_name";
    private static final String KEY_ADD = "patient_address";
    private static final String KEY_CON = "patient_contact";
    private static final String KEY_CNAME = "consultant_name";
    private static final String KEY_CCON = "consultant_contact";
    private static final String KEY_FEEDBACK = "feedback";
    private static final String KEY_DATES = "dates";
    
    
    
    private static final String D_ID = "did";
    private static final String D_NAME= "dname"; 
    private static final String D_ADDRESS = "daddress";
    private static final String D_CON = "dcon";
    private static final String D_EDU = "dedu";
    
    private static final String NGO_ID = "nid";
    private static final String NGO_NAME= "nname"; 
    private static final String NGO_ADDRESS = "naddress";
    private static final String NGO_CON = "ncon";
    private static final String NGO_INCH = "ninch";
    
    
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
 
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Category table create query
        String CREATE_CATEGORIES_TABLE = "CREATE TABLE " + TABLE_LABELS + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
        		+ KEY_NAME + " TEXT,"
        		+ KEY_ADD + " TEXT,"
        		+ KEY_CON + " INTIGER,"
        		+ KEY_CNAME + " TEXT,"
        		+ KEY_CCON + " INTIGER,"
        		+ KEY_FEEDBACK + " TEXT,"
        		+ KEY_DATES + " DATETIME"
        		       		       		
        		+ ")";
        db.execSQL(CREATE_CATEGORIES_TABLE);
        
        String CREATE_TABLE_TAG = "CREATE TABLE " + TABLE_TODO_TAG
        		+ "(" + D_ID + " INTEGER," + D_NAME + " TEXT,"
    			+ D_ADDRESS + " TEXT,"+ D_CON + " INTEGER,"+ D_EDU + " TEXT" + ")";
        db.execSQL(CREATE_TABLE_TAG);
        
        

        String NGO = "CREATE TABLE " + TABLE_TAG
        		+ "(" + NGO_ID + " INTEGER," + NGO_NAME + " TEXT,"
    			+ NGO_ADDRESS + " TEXT,"+ NGO_CON + " INTEGER,"+ NGO_INCH + " TEXT" + ")";
        db.execSQL(NGO);
    }
 
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LABELS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TODO_TAG);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TAG);
        
        // Create tables again
        onCreate(db);
    }
 
    /**
     * Inserting new lable into lables table
     * */
    public void insertUser(String pname,String add,String con,String cname,String ccon,String feed,String dates){
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
      
        values.put(KEY_NAME, pname);
        values.put(KEY_ADD, add);
        values.put(KEY_CON, con);
        values.put(KEY_CNAME, cname);
        values.put(KEY_CCON, ccon);
        values.put(KEY_FEEDBACK, feed);
        values.put(KEY_DATES, getDateTime());
        
        // Inserting Row
        db.insert(TABLE_LABELS, null, values);
        
        db.close(); // Closing database connection
    }
 
   //insert into local db from remote
    public void insertDr(String id,String dname,String dadd,String dcon,String dedu){
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
      values.put(D_ID, id);
      values.put(D_NAME, dname);
        values.put(D_ADDRESS, dadd);
        values.put(D_CON, dcon);
        values.put(D_EDU, dedu);
        // Inserting Row
        db.insert(TABLE_TODO_TAG, null, values);
        
        db.close(); // Closing database connection
    }
 
    
    //NGO
    public void insertNgo(long id,String nname,String nadd,String ncon,String ninch){
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
      values.put(NGO_ID, id);
      values.put(NGO_NAME, nname);
        values.put(NGO_ADDRESS, nadd);
        values.put(NGO_CON, ncon);
        values.put(NGO_INCH, ninch);
        // Inserting Row
        db.insert(TABLE_TAG, null, values);
        
        db.close(); // Closing database connection
    }
 
   //update local data
 	public boolean updateLocaldr(long id,String dname,String dadd,String dcon,String dedu){
  		SQLiteDatabase db = this.getReadableDatabase();
  		ContentValues values = new ContentValues();
  		
  		 values.put(D_ID, id);
  	      values.put(D_NAME, dname);
  	        values.put(D_ADDRESS, dadd);
  	        values.put(D_CON, dcon);
  	        values.put(D_EDU, dedu);
  	     
  	    return db.update(TABLE_TODO_TAG, values, D_ID + "=" + id, null) > 0;
  	}
 	
    //update local data ngo
  	public boolean updateLocalngo(long id,String nname,String nadd,String ncon,String ninch){
   		SQLiteDatabase db = this.getReadableDatabase();
   		ContentValues values = new ContentValues();
   		
   		 values.put(NGO_ID, id);
   	      values.put(NGO_NAME, nname);
   	        values.put(NGO_ADDRESS, nadd);
   	        values.put(NGO_CON, ncon);
   	        values.put(NGO_INCH, ninch);
   	     
   	    return db.update(TABLE_TAG, values, NGO_ID + "=" + id, null) > 0;
   	}
  	
  	//delete from local db
 	 public long deleteDr()
     {	
     	
     	SQLiteDatabase db = this.getReadableDatabase();   
     	
     		return db.delete(TABLE_TODO_TAG, null, null);
     	
     }
    
 	 public long deleteNgo()
     {	
     	
     	SQLiteDatabase db = this.getReadableDatabase();   
     	
     		return db.delete(TABLE_TAG, null, null);
     	
     }
    
 	public Cursor getDrdata()
	{	SQLiteDatabase db = this.getReadableDatabase();
		return db.query(TABLE_TODO_TAG, new String[] {D_ID,D_NAME,D_ADDRESS,D_CON,D_EDU},null, null, null, null, null);
	}
    
 	public Cursor getNgodata()
	{	SQLiteDatabase db = this.getReadableDatabase();
		return db.query(TABLE_TAG, new String[] {NGO_ID,NGO_NAME,NGO_ADDRESS,NGO_CON,NGO_INCH},null, null, null, null, null);
	}
    
    

    public int checkData(String id) throws SQLException
  	{
    	SQLiteDatabase db = this.getReadableDatabase();

      int i = 0;
      try
  	    { 	 Cursor c = null;
  	       	c = db.rawQuery("select * from dr_info where did ='"+id+ "'", null);  	   
  	        c.moveToFirst();
  	        i = c.getCount(); 
  	        //c.close();   	       
  	    }
  	    catch(Exception e)
  	    {
  	        e.printStackTrace();
  	        i=5;
  	    }
  	    return i;
  	}

//NGOCHECK
    public int checkData2(String id) throws SQLException
  	{
    	SQLiteDatabase db = this.getReadableDatabase();

      int i = 0;
      try
  	    { 	 Cursor c = null;
  	       	c = db.rawQuery("select * from ngo_info where nid ='"+id+ "'", null);  	   
  	        c.moveToFirst();
  	        i = c.getCount(); 
  	        //c.close();   	       
  	    }
  	    catch(Exception e)
  	    {
  	        e.printStackTrace();
  	        i=5;
  	    }
  	    return i;
  	}

    private String getDateTime()
    {
    	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss",Locale.getDefault());
    	Date date=new Date();
    	return dateformat.format(date);
    }
    
    /**
     * Getting all labels
     * returns list of labels
     * */
       
    
    
    public List<String> getdrdata()
    {
        List<String> labels = new ArrayList<String>();
 String spacing="  ";
        // Select All Query
        String selectQuery = "select * from dr_info";
 
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
 
        // looping through all rows and adding to list
        if (c.moveToFirst()) 
        {
            do 
            {
            	labels.add(c.getString(0)+spacing+c.getString(1)+spacing+c.getString(2)+spacing+c.getString(3)+spacing+c.getString(4));
                               
            } while (c.moveToNext());
        }
 
        // closing connection
        c.close();
        db.close(); 
        // returning lables
        return labels;
    }
 
 //ngo

    public List<String> getngodata()
    {
        List<String> labels = new ArrayList<String>();
 String spacing="  ";
        // Select All Query
        String selectQuery = "select * from ngo_info";
 
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
 
        // looping through all rows and adding to list
        if (c.moveToFirst()) 
        {
            do 
            {
            	labels.add(c.getString(0)+spacing+c.getString(1)+spacing+c.getString(2)+spacing+c.getString(3)+spacing+c.getString(4));
                               
            } while (c.moveToNext());
        }
 
        // closing connection
        c.close();
        db.close(); 
        // returning lables
        return labels;
    }
 
    //delete
  
    
    //getall toast
    public Cursor getAllContacts()
	{	SQLiteDatabase db = this.getReadableDatabase();
		return db.query(TABLE_LABELS, new String[] {KEY_ID,KEY_NAME,KEY_ADD,KEY_CON,KEY_CNAME,KEY_CCON,KEY_FEEDBACK,KEY_DATES}, 
				null, null, null, null, null);
	}
    
    
  //---retrieves a particular contact---
  	public Cursor getContact(long rowId) throws SQLException
  	{	SQLiteDatabase db = this.getReadableDatabase();
  	
  		Cursor mCursor =db.query(true, TABLE_LABELS, new String[] {KEY_ID,
  				KEY_NAME, KEY_CON}, KEY_ID + "=" + rowId, null,
  				null, null, null, null);
  		if (mCursor != null) {
      			mCursor.moveToFirst();
  		}
  		return mCursor;
  	}
  	
  	
  	//---updates a contact---
  	public boolean updateContact(long rowId, String name, String email)
  	{SQLiteDatabase db = this.getReadableDatabase();
  		ContentValues args = new ContentValues();
  		args.put(KEY_NAME, name);
  		args.put(KEY_CON, email);
  		return db.update(TABLE_LABELS, args, KEY_ID + "=" + rowId, null) > 0;
  	}
}