package com.example.controls_autocomplete;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends Activity {

	//private final String[] COLOURS ={"Blue","Green","Yellow","Orange","Violet","Magenta","Brown","Red","Maroon"};
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ArrayAdapter<String> adapt=new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,getResources().getStringArray(R.array.CLR));
        AutoCompleteTextView at=(AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        at.setAdapter(adapt);
        
        RatingBar rate = (RatingBar) findViewById(R.id.ratingBar1);
        rate.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
			
			@Override
			public void onRatingChanged(RatingBar ratingBar, float rating,
					boolean fromUser) {
				((TextView)findViewById(R.id.rate_text)).setText("Rating :"+rating);
				// TODO Auto-generated method stub
				
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
