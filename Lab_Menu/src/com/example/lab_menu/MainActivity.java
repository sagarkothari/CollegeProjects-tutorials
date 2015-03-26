package com.example.lab_menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static final int MENU_I_1=Menu.FIRST;
	private static final int MENU_I_2=Menu.FIRST+1;
	private static final int MENU_I_3=Menu.FIRST+2;
	Toast msg;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
      //  getMenuInflater().inflate(R.menu.main, menu);
        
        menu.add(Menu.NONE, MENU_I_1, Menu.NONE, "Click Me");
        menu.add(Menu.NONE, MENU_I_2, Menu.NONE, "Help");
        menu.add(Menu.NONE, MENU_I_3, Menu.NONE, "Exit");
        return (super.onCreateOptionsMenu(menu));
       // return true;
        
        
        
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	// TODO Auto-generated method stub
    	switch (item.getItemId())
    	{
    	case MENU_I_1: msg=Toast.makeText(MainActivity.this,item.getTitle() , Toast.LENGTH_LONG);msg.show(); break;
    	case MENU_I_2: msg=Toast.makeText(MainActivity.this,"I'm not in a mood to Help! :P " , Toast.LENGTH_LONG);msg.show(); break;
    	case MENU_I_3:finish();
    	
    		
    	}
    	return super.onOptionsItemSelected(item);
    }
    
}
