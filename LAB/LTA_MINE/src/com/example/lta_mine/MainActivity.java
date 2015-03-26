package com.example.lta_mine;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	Button login;
	TextView reg;
	EditText un,pw;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		login=(Button)findViewById(R.id.button1);
		reg=(TextView)findViewById(R.id.textView3);
		un=(EditText) findViewById(R.id.editText1);
		pw=(EditText) findViewById(R.id.editText2);
		
		reg.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				reg();
			}
		});
		
		login.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String u=un.getText().toString();
				String p=pw.getText().toString();
				
			}
		});
	}
	
	
	public void reg()
	{
		Intent i=new Intent(this, RegisterAct.class);
		startActivity(i);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
