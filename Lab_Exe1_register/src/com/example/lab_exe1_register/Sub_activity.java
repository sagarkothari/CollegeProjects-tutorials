package com.example.lab_exe1_register;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Sub_activity extends Activity implements OnClickListener {
	Button b;
	String a[];
	EditText et1,et2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sub_activity);
		b= (Button) findViewById(R.id.button2);
		b.setOnClickListener(this);
		et1=(EditText) findViewById(R.id.editText21);
		et2=(EditText) findViewById(R.id.editText12);
		 a=getIntent().getStringArrayExtra("Values");
	}

	@Override
	public void onClick(View arg0) {
		
		// TODO Auto-generated method stub
		if (a[1].contentEquals(et2.getText().toString()) && a[0].equalsIgnoreCase(et1.getText().toString())) {
			Toast.makeText(getApplicationContext(), "Welcome.. "+et2.getText().toString(), Toast.LENGTH_LONG).show();
		}
		else
			Toast.makeText(getApplicationContext(), "Invalid Username or password", Toast.LENGTH_LONG).show();	
	
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sub_activity, menu);
		return true;
	}

}
