package com.example.spineercolour;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends Activity implements OnItemSelectedListener {

	Spinner s;
	View root;
	View vl;
	Button b;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s=(Spinner) findViewById(R.id.spinner1);
        s.setOnItemSelectedListener(this);
        vl=findViewById(R.id.rel);
        root=vl.getRootView();
        b=(Button) findViewById(R.id.button1);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		b.setBackgroundColor(Color.parseColor(s.getSelectedItem().toString()));
		root.setBackgroundColor(Color.parseColor(s.getSelectedItem().toString()));
		s.setBackgroundColor(Color.parseColor(s.getSelectedItem().toString()));
		
		
	}


	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
    
}
