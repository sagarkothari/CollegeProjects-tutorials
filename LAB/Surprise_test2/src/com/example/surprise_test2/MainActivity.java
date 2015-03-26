package com.example.surprise_test2;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	Button cal,vi;
	EditText op1,op2,opr,ans;
	SQLiteDatabase db;
	Cursor c;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		cal=(Button)findViewById(R.id.button1);
		vi=(Button)findViewById(R.id.button2);
		op1=(EditText)findViewById(R.id.editText1);
		op2=(EditText)findViewById(R.id.editText2);
		opr=(EditText)findViewById(R.id.editText3);
		ans=(EditText)findViewById(R.id.editText4);
		
		creatdb();
		
		cal.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Double o1=Double.parseDouble(op1.getText().toString());
				Double o2=Double.parseDouble(op2.getText().toString());
				String a=opr.getText().toString();
				Double Temp;
				if(a.equals("+"))
				{
					Temp=o1+o2;
					ans.setText(Temp+"");
					insert(o1, o2, a, Temp);
				}
		else if(a.equals("-"))
		{
			Temp=o1-o2;
			ans.setText(Temp+"");
			insert(o1, o2, a, Temp);
		}
		else if(a.equals("*"))
		{
			Temp=o1*o2;
			ans.setText(Temp+"");
			insert(o1, o2, a, Temp);
		}
		else if(a.equals("/"))
		{
			Temp=o1/o2;
			ans.setText(Temp+"");
			insert(o1, o2, a, Temp);
		}
		else {
			ans.setText("Invalid operator");
		}
			}
		});
		
		vi.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				vie();
			}
		});
		
	}
	
	public void creatdb()
	{
		db=openOrCreateDatabase("dbtest", MODE_PRIVATE, null);
		db.execSQL("create table if not exists oprat(opr1 DOUBLE(4),opr2 DOUBLE(4),opt VARCHAR(1),ans DOUBLE(4));");
	}
	public void insert(double a,double b,String c,double an)
	{
		try{
			db.execSQL("Insert into oprat values("+a+","+b+",'"+c+"',"+an+");");
			//ans.setText("Inserted");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void vie()
	{
		String res="";
		try{
			c=db.rawQuery("Select * from oprat", null);
			c.moveToFirst();
			do{
				res+=c.getDouble(c.getColumnIndex("opr1"))+"\t"+c.getDouble(c.getColumnIndex("opr2"))+"\t"+c.getString(c.getColumnIndex("opt"))+"\t"+c.getDouble(c.getColumnIndex("ans"))+"\n";
				ans.setText("");
				ans.setText(ans.getText()+res);
			}while(c.moveToNext());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
