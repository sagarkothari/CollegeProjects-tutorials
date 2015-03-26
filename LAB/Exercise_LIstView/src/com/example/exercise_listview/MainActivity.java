package com.example.exercise_listview;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        String[] val={"Android","iphone","windowsPhone","Blackberry"};
        ArrayAdapter<String> adpt= new ArrayAdapter<String>(this,R.layout.activity_main,R.id.textView1,val);
        setListAdapter(adpt);
     }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
    	// TODO Auto-generated method stub
    	super.onListItemClick(l, v, position, id);
    	String item=(String) getListAdapter().getItem(position);
    	Toast.makeText(this, item+"is on"+position, Toast.LENGTH_LONG).show();
    	Intent i=new Intent(this,ImgActivity.class);
    	i.putExtra("image", item);
    	startActivity(i);
    	
    	
    	
    }
    
}
