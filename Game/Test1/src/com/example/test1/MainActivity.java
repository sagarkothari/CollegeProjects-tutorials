package com.example.test1;


import android.os.Build;
import android.os.Bundle;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	Button play,instructions,options,highscore,exit;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        play=(Button) findViewById(R.id.button1);
        instructions=(Button) findViewById(R.id.button2);
        options=(Button) findViewById(R.id.button3);
        highscore=(Button) findViewById(R.id.button4);
        exit=(Button) findViewById(R.id.button5);
        
        
       
        OnClickListener abc=new View.OnClickListener() {
		Intent pla = new Intent(getApplicationContext(), PlayerNames.class);
		Intent inst = new Intent(getApplicationContext(), SettingsActivity.class);
		Intent opt = new Intent(getApplicationContext(), SettingsActivity.class);
		Intent hs = new Intent(getApplicationContext(), ScoresActivity.class);
//		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId())
			{
			case R.id.button1:startActivity(pla);
							break;
			case R.id.button2:startActivity(inst);
			break;
			case R.id.button3:startActivity(opt);
			break;
			case R.id.button4:startActivity(hs);
			break;
			case R.id.button5:
				
				if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
				{
					
				}
				AlertDialog.Builder al = new AlertDialog.Builder(MainActivity.this);
				al.setTitle("Exit");
				al.setMessage("Quit, Are You Sure ?");
				
				al.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						MainActivity.this.finish();
					}
					
				});
				al.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
					}
				});
				
				al.create();
				al.show();
//				
			break;
				
			}
			
			
		}
	};  
        play.setOnClickListener(abc);
        instructions.setOnClickListener(abc);
        options.setOnClickListener(abc);
        highscore.setOnClickListener(abc);
        exit.setOnClickListener(abc);
//     
    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
