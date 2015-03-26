package com.example.test1;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class PlayerNames extends Activity implements OnItemSelectedListener {
	
	Spinner s;
	SharedPreferences sh;
	SharedPreferences.Editor e;
	TextView p1,p2;
	EditText plr1,plr2;
	Button b;
	Boolean single=true;
	Intent i;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_player_names);
		
		
		
		s=(Spinner)findViewById(R.id.spinner1);
		s.setOnItemSelectedListener(this);
		p1=(TextView)findViewById(R.id.p1);
		p2=(TextView)findViewById(R.id.p2);
		plr1=(EditText)findViewById(R.id.e1);
		plr2=(EditText)findViewById(R.id.e2);
		b=(Button)findViewById(R.id.pla);
		i=new Intent(this,Game.class);
		b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(!single)
				{
					try{
					sh=getSharedPreferences("PlayerName", MODE_PRIVATE);
					e=sh.edit();
					
					e.putString("Player1",plr1.getText().toString() );
					e.putString("Player2",plr2.getText().toString() );
					e.commit();
					}catch(Exception e)
					{
						Log.i("in Playernames on click", e.getMessage());
					}
				}
				
				
				//intent
				try{
				sh=getSharedPreferences("PlayerType",MODE_PRIVATE);
				e=sh.edit();
				e.putBoolean("Single", single );
				e.commit();
				startActivity(i);
				}
				catch(Exception e)
				{
					Log.i("in Playernames on click-> intent", e.getMessage());
				}
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.player_names, menu);
		return true;
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		
		if(s.getSelectedItem().toString().equals("Single Player"))
		{
			single=true;
			p1.setVisibility(4);
			p2.setVisibility(4);
			plr1.setVisibility(4);
			plr2.setVisibility(4);
			
		
		}
		else
		{
			single=false;
			p1.setVisibility(0);
			p2.setVisibility(0);
			plr1.setVisibility(0);
			plr2.setVisibility(0);
		}
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}

}
