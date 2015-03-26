package beans;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

public class SingleDatabase {

	SQLiteDatabase db;
	
	Context context;
	
	
	public SingleDatabase(Context con) {
		
		try{
		context=con;
		db=context.openOrCreateDatabase("FCDB.db", 0, null);
		db.execSQL("create table if not exists single_score( ten INT(4), twenty INT(4), thirty INT(4));");
		
		}
		catch(Exception e)
		{
			Log.i("In SingleDatabase constructor", e.getMessage());
		}
		
	}
	public void insert()
	{
		db.execSQL("Insert into single_score values(0,0,0);");
	}
	
	public void addData(Player p,int time)
	{//
		
	//	db.execSQL("Drop table single_score");
		Cursor c = db.rawQuery("Select * from single_score", null);
	//Toast.makeText(context,"empty"+c.getCount(), Toast.LENGTH_LONG).show();
		if(c.getCount()==0)
		{
			try{
				if(time==10)
					
					db.execSQL("Insert into single_score values("+p.getPlayerScore()+",0,0);");
				else if(time==20)
					db.execSQL("Insert into single_score values(0,"+p.getPlayerScore()+",0);");
				else if(time==30)
					db.execSQL("Insert into single_score values(0,0,"+p.getPlayerScore()+");");
				}
				catch(Exception e)
				{
					Log.i("In SingleDatabase constructor", e.getMessage());
				}
			
		}
		else if(c.getCount()==1)
		{
		try{
		if(time==10)
			
		db.execSQL("update single_score set ten="+p.getPlayerScore()+";");
		else if(time==20)
			db.execSQL("update single_score set twenty="+p.getPlayerScore()+";");
		else if(time==30)
			
			db.execSQL("update single_score set thirty="+p.getPlayerScore()+";");
		
		
		}
		catch(Exception e)
		{
			Log.i("In SingleDatabase constructor", e.getMessage());
		}
		}
	}
	
	public int getData(int time){
		Cursor c;
		int temp=-1;
			if(time==10){
				try{
			c=db.rawQuery("Select ten from single_score", null);
			c.moveToFirst();
			
			temp=c.getInt(c.getColumnIndex("ten"));
				}catch(Exception e)
				{
					Log.i("In SingleDatabase get 10sec", e.getMessage());
					temp=0;
				}
			}
		else if(time==20){
			try{
			c=db.rawQuery("Select twenty from single_score", null);
			c.moveToFirst();
			temp=c.getInt(c.getColumnIndex("twenty"));
				}catch(Exception e)
				{
					Log.i("In SingleDatabase get 10sec", e.getMessage());
					temp=0;
				}
			}
		else if(time==30){
				try{
			c=db.rawQuery("Select thirty from single_score", null);
			c.moveToFirst();
			temp=c.getInt(c.getColumnIndex("thirty"));
				}catch(Exception e)
				{
					Log.i("In SingleDatabase get 10sec", e.getMessage());
					temp=0;
				}
			}
			return temp;
	}
	
	public void delete()
	{
		db.execSQL("delete from single_score");
	}
	
	
}
