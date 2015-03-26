package com.example.login_form;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class SubActivity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sub);
		
		String a[]=getIntent().getStringArrayExtra("name");
		
		TextView tv= (TextView) findViewById(R.id.view);
		tv.setText("Name :"+a[0]+"\nSex :"+a[3]+"\nAddress :"+a[2]+"\nEmail :"+a[1]+"\nPh no.:"+a[4]);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sub, menu);
		return true;
	}

}
