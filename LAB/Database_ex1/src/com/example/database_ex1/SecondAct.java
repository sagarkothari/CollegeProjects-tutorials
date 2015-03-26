package com.example.database_ex1;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondAct extends Activity {

	
	EditText first,last,rno,mno,ono;
	Button viu,upd,del;
	static SQLiteDatabase db;
	TextView ans;
	Cursor c;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		first=(EditText) findViewById(R.id.editText1);
		last=(EditText) findViewById(R.id.editText2);
		rno=(EditText) findViewById(R.id.editText3);
		mno=(EditText) findViewById(R.id.editText4);
		ono=(EditText) findViewById(R.id.editText5);
		viu=(Button) findViewById(R.id.button1);
		upd=(Button) findViewById(R.id.button2);
		del=(Button) findViewById(R.id.button3);
		ans=(TextView) findViewById(R.id.textView6);
		
		
		db=SQLiteDatabase.openDatabase("/data/data/com.example.database_ex1/databases/mydb1", null, SQLiteDatabase.CREATE_IF_NECESSARY );
	
		//first.setEnabled(false);
		//last.setEnabled(false);
		
		viu.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Vie();
			}
		});
		
		upd.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Update();
			}
		});
		del.setOnClickListener(new View.OnClickListener() {
	
			@Override
			public void onClick(View v) {
		// TODO Auto-generated method stub
				Delete();
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}
	
	public void Update()
	{
		int mobn=Integer.parseInt(mno.getText().toString());
		int resn=Integer.parseInt(rno.getText().toString());
		int offn=Integer.parseInt(ono.getText().toString());
		
		String fname=first.getText().toString();
		String lname=last.getText().toString();
		try{
			db.execSQL("Update emp_info set resino="+resn+" , mobino="+mobn+" , officno="+offn+" where fname='"+fname+"' and lname='"+lname+"';");
			ans.setText("Updated");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			ans.setText("update failed"+e);
		}
		
	}
	public void Delete()
	{
		String fname=first.getText().toString();
		String lname=last.getText().toString();
		
		try{
			db.execSQL("Delete from emp_info where fname='"+fname+"' and lname='"+lname+"';");
			ans.setText("Deleted");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			ans.setText(" Delete Failed"+e);
		}
		
	}
	public void Vie()
	{
		String res="";
		try{
			c=db.rawQuery("Select * from emp_info", null);
			c.moveToFirst();
			do{
				res+=c.getString(c.getColumnIndex("fname"))+"\t"+c.getString(c.getColumnIndex("lname"))+"\t"+c.getInt(c.getColumnIndex("resino"))+"\t"+c.getInt(c.getColumnIndex("mobino"))+"\t"+c.getInt(c.getColumnIndex("officno"))+"\n";
				ans.setText(res);
			}while(c.moveToNext());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			ans.setText("View Failed"+e);
		}
	}

}
