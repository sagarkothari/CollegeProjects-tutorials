package com.example.exercise_rating;

import android.os.Bundle;
import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class SecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		TextView tv=(TextView) findViewById(R.id.textView1);
		
		float a=getIntent().getFloatExtra("Rating",0);
		if(a>4.0)
		{
			tv.setText("The Rating is Excellent.."+a);
		}
		else if(a==3.0)
		{
			tv.setText("The Rating is Average.."+a);
		}
		else if(a<=2 && a>0)
		{
			tv.setText("The Rating is Poor.."+a);
		}
		else
		{
			tv.setText(""+a);
		}
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}

}
