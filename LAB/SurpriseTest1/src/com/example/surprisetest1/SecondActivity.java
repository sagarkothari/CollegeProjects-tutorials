package com.example.surprisetest1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends Activity implements OnClickListener {

	Button b;
	EditText e;
	double sal,hra,da,gsal;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		e=(EditText) findViewById(R.id.editText11);
		
		b=(Button) findViewById(R.id.button2);
		b.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		sal=Double.parseDouble(e.getText().toString());
		da=0.05*sal;
		hra=0.15*sal;
		gsal=sal+(sal*hra)+(sal*da);
		
		Toast.makeText(this, "Gross Salary is :"+gsal, Toast.LENGTH_LONG).show();
	}

}
