package com.example.exercise_listview;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ImageView;

public class ImgActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_img);
		String a=getIntent().getStringExtra("image");
		ImageView iv=(ImageView) findViewById(R.id.imageView1);
		
		
	if(a.equals("Android"))
	{
		iv.setImageResource(R.drawable.and);
	}
	else if(a.equals("iphone"))
	{
		iv.setImageResource(R.drawable.ip);
	}
	else if(a.equals("windowsPhone"))
	{
		iv.setImageResource(R.drawable.jerry);
	}
	else if(a.equals("Blackberry"))
	{
		iv.setImageResource(R.drawable.awesomeee);
	}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.img, menu);
		return true;
	}

}
