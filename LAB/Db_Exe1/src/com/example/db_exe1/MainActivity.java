package com.example.db_exe1;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	Button ins,up,del,ret,clr,viu;
	
	EditText eid,enam;
	
	TextView ans;
	
	SQLiteDatabase db;
	
	Cursor c;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ins=(Button) findViewById(R.id.button1);
		up=(Button) findViewById(R.id.button2);
		del=(Button) findViewById(R.id.button3);
		clr=(Button) findViewById(R.id.button4);
		viu=(Button) findViewById(R.id.button5);
		ret=(Button) findViewById(R.id.button6);
		eid=(EditText) findViewById(R.id.editText1);
		enam=(EditText) findViewById(R.id.editText2);
		ans=(TextView) findViewById(R.id.textView3);
		createDB();
		
		ins.setOnClickListener(this);
		up.setOnClickListener(this);
		del.setOnClickListener(this);
		clr.setOnClickListener(this);
		viu.setOnClickListener(this);
		ret.setOnClickListener(this);
		
		
		
	}
	
	public void createDB()
	{
		db=openOrCreateDatabase("mydb", MODE_PRIVATE, null);
		db.execSQL("create table if not exists emp_info(id INT(2),name VARCHAR);");
		
		
	}
	
	public void Insert()
	{
		int id=Integer.parseInt(eid.getText().toString());
		String name = enam.getText().toString();
		try{
			db.execSQL("Insert into emp_info values("+id+",'"+name+"');");
			ans.setText("Inserted");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public void Update()
	{
		int id=Integer.parseInt(eid.getText().toString());
		String name = enam.getText().toString();
		try{
			db.execSQL("Update emp_info set name='"+name+"' where id="+id+";");
			ans.setText("Updated");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public void Delete()
	{
		int id=Integer.parseInt(eid.getText().toString());
		
		try{
			db.execSQL("Delete from emp_info where id="+id+";");
			ans.setText("Delete");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public void Retrve()
	{
		int id=Integer.parseInt(eid.getText().toString());
		String res="";
		try{
			c=db.rawQuery("Select name from emp_info where id="+id, null);
			c.moveToFirst();
			do{
				res+=c.getString(c.getColumnIndex("name"))+"\n";
				ans.setText(res);
				enam.setText(res);
			}while(c.moveToNext());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public void Vie()
	{
		String res="";
		try{
			c=db.rawQuery("Select * from emp_info", null);
			c.moveToFirst();
			do{
				res+=c.getInt(c.getColumnIndex("id"))+c.getString(c.getColumnIndex("name"))+"\n";
				ans.setText(res);
			}while(c.moveToNext());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void Clear()
	{
		eid.setText("");
		enam.setText("");
		ans.setText("");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId())
		{
		case R.id.button1:Insert();
			break;
		case R.id.button2:Update();
		break;
		case R.id.button3:Delete();
		break;
		case R.id.button5:Vie();
		break;
		case R.id.button6:Retrve();
		break;
		case R.id.button4:Clear();
			break;
		}
	}

}
