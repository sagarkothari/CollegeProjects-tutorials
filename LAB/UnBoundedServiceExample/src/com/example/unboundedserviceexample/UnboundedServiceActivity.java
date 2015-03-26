package com.example.unboundedserviceexample;

import com.example.service.UnboundedAudioPlayerService;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class UnboundedServiceActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_unbounded_service);
		
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.unbounded, menu);
        return true;
    }

    public void playAudio(View view) {
        Intent serviceIntent = new Intent(this, UnboundedAudioPlayerService.class);
        startService(serviceIntent);
    }

    public void stopAudio(View view) {
        Intent serviceIntent = new Intent(this, UnboundedAudioPlayerService.class);
        stopService(serviceIntent);   
    }
}
