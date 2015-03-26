package com.example.database_ex1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText first,last,rno,mno,ono;
	Button reg;
	public SQLiteDatabase db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		first=(EditText) findViewById(R.id.editText1);
		last=(EditText) findViewById(R.id.editText2);
		rno=(EditText) findViewById(R.id.editText3);
		mno=(EditText) findViewById(R.id.editText4);
		ono=(EditText) findViewById(R.id.editText5);
		reg=(Button) findViewById(R.id.button1);
		createDB();
		reg.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				try{
					register();
					
				}
				catch(Exception e)
				{
					
				}
				
			}
		});
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void register()
	{
		int reno=Integer.parseInt(rno.getText().toString());
		int mono=Integer.parseInt(mno.getText().toString());
		int ofno=Integer.parseInt(ono.getText().toString());
		String fname = first.getText().toString();
		String lname = last.getText().toString();
		try{
			db.execSQL("Insert into emp_info values('"+fname+"','"+lname+"',"+reno+","+mono+","+ofno+");");
			Intent i =new Intent(this, SecondAct.class);
			startActivity(i);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Toast.makeText(this, "Invalid registration some error with ", Toast.LENGTH_LONG).show();
		}
	}
	
	public void createDB()
	{
		
		db=openOrCreateDatabase("mydb1", MODE_PRIVATE, null);
		db.execSQL("create table if not exists emp_info( fname VARCHAR, lname VARCHAR, resino INT(10), mobino INT(10), officno INT(10));");
		
		
	}

}


