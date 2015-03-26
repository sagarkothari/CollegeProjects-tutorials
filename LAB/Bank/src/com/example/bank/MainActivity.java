package com.example.bank;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	Button dep,wid;
	EditText id,name,acc_no,bal,amt;
	double ba=1000.00;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		id=(EditText) findViewById(R.id.editText1);
		name=(EditText) findViewById(R.id.editText2);
		acc_no=(EditText) findViewById(R.id.editText3);
		bal=(EditText) findViewById(R.id.editText4);
		amt=(EditText) findViewById(R.id.editText5);
		
		bal.setText(""+ba);
	final	AlertDialog.Builder al=new AlertDialog.Builder(MainActivity.this);
		
		wid=(Button) findViewById(R.id.button1);
		dep=(Button) findViewById(R.id.button2);
		
		wid.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				double temp=Double.parseDouble(amt.getText().toString());
				if(ba-temp>1000)
				{
					ba-=temp;
					bal.setText(""+ba);
					amt.setText("");
				}
				else
				{
					
				al.setNeutralButton("OK", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						amt.setText("");
					}
				});
				al.setTitle("Insufficient Funds!! ");
				al.show();
				}
			}
		});
		
		dep.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				double temp=Double.parseDouble(amt.getText().toString());
				ba+=temp;
				bal.setText(""+ba);
				amt.setText("");
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
