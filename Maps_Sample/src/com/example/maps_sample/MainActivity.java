package com.example.maps_sample;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends FragmentActivity {

	GoogleMap gMap;
	double latitude=22.312907;
	double longitude=73.160386;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
       try{
    	   initializeMap();
       }
       catch(Exception e)
       {
    	   e.printStackTrace();
       }
    }

    public void initializeMap()
    {
    	if(gMap==null)
    	{
    		 SupportMapFragment fm = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
    			
    			// Getting GoogleMap object from the fragment
    			gMap = fm.getMap();
    			
    			
    	      if(gMap==null)
    	    	  Toast.makeText(this, "Sorry not found", Toast.LENGTH_LONG);
    	      MarkerOptions mar=new MarkerOptions().position(new LatLng(latitude, longitude)).title("My house");
    	      gMap.addMarker(mar);
    	}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
