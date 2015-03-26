package com.example.sampleapplication;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class SampleActivity extends Activity {
	
	//Button btn_click;
	ListView lv;
	String[] str_arr={"Android","BB","Nokia","Windows","Apple","samsung","Sice",":P","als",":)"};
	
	//ArrayAdapter<String> adpt;
	CustomListViewAdapter adpt;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        
     //   btn_click =(Button) findViewById(R.id.button1);
        
        lv=(ListView) findViewById(R.id.listView1);
        
        adpt=new CustomListViewAdapter(getApplicationContext(), str_arr);
        lv.setAdapter(adpt);
        
        
      //  btn_click.setOnClickListener(this);
    }

//	@Override
	//public void onClick(View arg0) {
	//	// TODO Auto-generated method stub
//		Toast.makeText(this,"Button Clicked", Toast.LENGTH_LONG).show();
//	}
    
    
    
}
