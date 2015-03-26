package com.example.context_menu_application;

import android.os.Bundle;
import android.app.Activity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button b=(Button) findViewById(R.id.button1);
        registerForContextMenu(b);
        
    }
    
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
    		ContextMenuInfo menuInfo) {
    	// TODO Auto-generated method stub
    	super.onCreateContextMenu(menu, v, menuInfo);
    	menu.setHeaderTitle("Context Menu");
    	menu.add(0,v.getId(),0,"Despicable me");
    	menu.add(0,v.getId(),0,"Croods");
    }
    
    @Override
    public boolean onContextItemSelected(MenuItem item) {
    	// TODO Auto-generated method stub
    	if(item.getTitle()=="Despicable me")
    	{
    		Toast.makeText(this,"Despicable me is a goood movie",Toast.LENGTH_LONG).show();
    	}
    	else if(item.getTitle()=="Croods")
    	{
    		Toast.makeText(this,"Croods is an awesome movie",Toast.LENGTH_LONG).show();
    	}
    	return super.onContextItemSelected(item);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
