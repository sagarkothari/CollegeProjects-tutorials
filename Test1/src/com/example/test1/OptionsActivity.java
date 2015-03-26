package com.example.test1;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Typeface;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

public class OptionsActivity extends Activity {
Spinner time;
ToggleButton sound;
TextView a,b;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_options);
		
		sound=(ToggleButton) findViewById(R.id.toggleButton1);
		time=(Spinner) findViewById(R.id.spinner1);
		a = (TextView)findViewById(R.id.textView1);
		b = (TextView)findViewById(R.id.textView2);
		
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.TimeValues, android.R.layout.simple_spinner_item);
		
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		time.setAdapter(adapter);
		
Typeface titleFont = Typeface.createFromAsset(this.getAssets(),"ROBOTOCONDENSED-REGULAR.TTF");
		
		a.setTypeface(titleFont);
		b.setTypeface(titleFont);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.options, menu);
		return true;
	}

}
