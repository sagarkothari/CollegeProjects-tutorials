package com.example.test1;

import java.util.Timer;
import java.util.TimerTask;

import beans.Player;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Game extends Activity {

	Button p1,p2;
	TextView singlescore,multi1,multi2,timer;
	int time=31,sscore=0,db1score=0,db2score=0;
	Timer t;
	Boolean single;
	String P1name,P2name;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
//                                WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_game);
		
		SharedPreferences w=PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
		String a1=w.getString("sync_frequency","30" );
		time=Integer.parseInt(a1)+1;
		
		p1=(Button)findViewById(R.id.p1);
		p2=(Button)findViewById(R.id.p2);
		singlescore=(TextView) findViewById(R.id.textView1);
		multi1=(TextView) findViewById(R.id.textView2);
		multi2=(TextView) findViewById(R.id.textView3);
		timer=(TextView) findViewById(R.id.textView4);
		
		getval();
		starttimer();
		p1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				b1click();
				
			}
		});
		p2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				b2click();
			}
		});
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}
	
	public void winner()
	{
		Intent i=new Intent(Game.this, WinnerActivity.class);
		if(single)
		{
			Player p=new Player("single", sscore);
			i.putExtra("Sscore", p);
		}
		else{
			Player p = new Player(P1name, db1score);
			Player q = new Player(P2name, db2score);
			if(db1score>db2score){
				
				i.putExtra("Winner", p);
				i.putExtra("Loser",q);
			}else if(db2score>db1score)
			{
				
				i.putExtra("Loser",p);
				i.putExtra("Winner", q);
			}
			else
			{
				i.putExtra("Tie", true);
				
			}
		}
		startActivity(i);
	}
	
	public void b1click(){
		
		if(single)
		{
			sscore++;
			singlescore.setText(String.valueOf(sscore));
			
		}
		else{
			db1score++;
			multi1.setText(String.valueOf(db1score));
		}
	}
	
	public void b2click(){
		
		if(single)
		{
			sscore++;
			singlescore.setText(String.valueOf(sscore));
			
		}
		else{
			db2score++;
			multi2.setText(String.valueOf(db2score));
		}
	}
	
	public void starttimer()
	{
		try{
			 t=new Timer();
			 
			t.scheduleAtFixedRate(new TimerTask(){

		    @Override
		    public void run() {
		    	if(time==0)
	    	    {
		    		//p1.setEnabled(false); not working.
	    	    	this.cancel();
	    	    	winner();
	    	    	
	    	    }
		    	runOnUiThread(new Runnable() {

		    	    @Override
		    	    public void run() {
		    	        
		    	        timer.setText(String.valueOf(time));
		    	        time -= 1;
		    	    }
		    	    
		    	    
		    	     
		    	});
		        
		    }
		         
		},
		//Set how long before to start calling the TimerTask (in milliseconds)
		0,
		//Set the amount of time between each execution (in milliseconds)
		1000);
			
			
			
		}catch(Exception e)
		{
			Log.i("Timer", e.getMessage());
		}
	}
	
	public void getval()
	{
		SharedPreferences sh=getSharedPreferences("PlayerType", MODE_PRIVATE);
		
		single=sh.getBoolean("Single", true);
		if(!single){
			sh=getSharedPreferences("PlayerName", MODE_PRIVATE);
			P1name=sh.getString("Player1", "Player1");
			P2name=sh.getString("Player2", "Player2");
			if(P1name.equals(""))
				P1name="Player1";
			if(P2name.equals(""))
				P2name="Player2";
			p1.setText(P1name);
			p2.setText(P2name);
			singlescore.setVisibility(4);
		}else
		{
			p1.setText("Left");
			p2.setText("Right");
			multi1.setVisibility(4);
			multi2.setVisibility(4);
		}
		
		
		
	}
	
	

}
