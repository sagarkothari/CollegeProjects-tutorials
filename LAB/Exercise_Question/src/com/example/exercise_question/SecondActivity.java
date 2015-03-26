package com.example.exercise_question;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class SecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		TextView t=(TextView) findViewById(R.id.textView11);
		
		String[] a=getIntent().getStringArrayExtra("first");
		
		
		if(a[0]==null && a[1]==null)
		{
			t.setText("Don't Be OverSmart and select 1 answer....");
		}
		else if(a[0].equalsIgnoreCase("Yes") && a[1].equalsIgnoreCase("France"))
		{
			t.setText("You are a Genius...");
		}
		else 
		{
			t.setText("You are too dumb...");
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}

}
