package com.example.location_sample;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements LocationListener {

	Button b;
	LocationManager locmangr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        b=(Button) findViewById(R.id.button1);
        
        locmangr= (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locmangr.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0,this);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		double latitude=location.getLatitude();
		double longitude=location.getLongitude();
		Toast.makeText(getApplicationContext(),"Latitude: "+latitude+"/nLongitude :"+longitude,Toast.LENGTH_LONG).show();
		
	}


	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}
    
}
