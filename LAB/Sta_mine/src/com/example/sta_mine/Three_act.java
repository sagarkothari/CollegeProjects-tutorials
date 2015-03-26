package com.example.sta_mine;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Three_act extends Activity {

	Boolean fff,phaff,apf,flipf,ans=false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_three_act);
		Toast.makeText(this, "Hey", Toast.LENGTH_LONG).show();
		
		
		fff=(Boolean) getIntent().getBooleanExtra("50f", false);
		 phaff=(Boolean) getIntent().getBooleanExtra("pf", false);
	 apf=(Boolean) getIntent().getBooleanExtra("af", false);
		flipf=(Boolean) getIntent().getBooleanExtra("ff", false);
		
		  Button ff=(Button) findViewById(R.id.button21);
	        Button phaf=(Button) findViewById(R.id.button22);
	        Button ap=(Button) findViewById(R.id.button24);
	        Button flip=(Button) findViewById(R.id.button23);
	        
	        if(fff)
	        {
	        	ff.setEnabled(false);
	        }
	         if(phaff)
	        {
	        	phaf.setEnabled(false);
	        }
	         if(apf)
	        {
	        	ap.setEnabled(false);
	        }
	         if(flipf)
	        {
	        	flip.setEnabled(false);
	        }
	        
	        final Toast t2=Toast.makeText(this, "Incorrect answer \n Application will exit \n You Won : 100000rs ", Toast.LENGTH_LONG);
	        final   Intent i2 = new Intent(this,Winner.class);
	         final RadioGroup rg=(RadioGroup) findViewById(R.id.radioGroup21);
	          rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
	  			
	  			@Override
	  			public void onCheckedChanged(RadioGroup arg0, int arg1) {
	  				// TODO Auto-generated method stub
	  				
	  				if(arg1!=-1)
	  				{
	  					RadioButton b=(RadioButton) findViewById(arg1);
	  					if(b.getText().toString().equals("Violet") || b.getText().toString().equals("Swiss Franc"))
	  					{
	  						ans=true;
	  						System.out.println("selected correct ans");
	  						i2.putExtra("fpf", fff);
	  						i2.putExtra("appf", apf);
	  						i2.putExtra("fppf", flipf);
	  						i2.putExtra("ppf", phaff);
	  						
	  						startActivity(i2);
	  					}
	  					else
	  					{
	  						t2.show();
	  						finish();
	  					}
	  				}
	  			}
	  		});
	          
	          
	          
	          
	        final Intent call= new Intent();
	          
	          ff.setOnClickListener(new View.OnClickListener() {
	  			
	  			@Override
	  			public void onClick(View arg0) {
	  				// TODO Auto-generated method stub
	  				System.out.println("onclick listner");

	  				fff=true;
	  				RadioButton r=(RadioButton) rg.findViewById(R.id.radio22);
	  				r.setEnabled(false);
	  				RadioButton r1=(RadioButton) rg.findViewById(R.id.radio21);
	  				r1.setEnabled(false);
	  				arg0.setEnabled(false);
	  			}
	  		});
	          
	          phaf.setOnClickListener(new View.OnClickListener() {
	  			
	  			@Override
	  			public void onClick(View v) {
	  			phaff=true;
	  			v.setEnabled(false);
	  			// TODO Auto-generated method stub
	  				call.setAction(android.content.Intent.ACTION_DIAL).setData(null);
	  				startActivity(call);
	  			}
	  		});
	          
	         final Toast t=Toast.makeText(this, "Pratibha Patil -> 35% \n Manmohan Singh -> 15% \n Pranab Mukherjee -> 40% \n A.k.Anthony -> 10%", Toast.LENGTH_LONG);
	         final Toast t1=Toast.makeText(this, "Swiss Franc -> 45% \n Swiss Dollar -> 15% \n Euro -> 30% \n Pound -> 10%", Toast.LENGTH_LONG);        
	          ap.setOnClickListener(new View.OnClickListener() {
	  			
	  			@Override
	  			public void onClick(View v) {
	  				// TODO Auto-generated method stub
	  				apf=true;
	  				v.setEnabled(false);
	  				if(flipf==false)
	  				t.show();
	  				else
	  					t1.show();
	  			}
	  		});
	          
	          flip.setOnClickListener(new View.OnClickListener() {
	  			
	  			@Override
	  			public void onClick(View v) {
	  				flipf=true;
	  				v.setEnabled(false);
	  				TextView t=(TextView) findViewById(R.id.textView21);
	  				t.setText(R.string.que);
	  				RadioButton r=(RadioButton) rg.findViewById(R.id.radio22);
	  				r.setText(R.string.op3);
	  				RadioButton r1=(RadioButton) rg.findViewById(R.id.radio20);
	  				r1.setText(R.string.op1);
	  				RadioButton r2=(RadioButton) rg.findViewById(R.id.radio21);
	  				r2.setText(R.string.op2);
	  				RadioButton r4=(RadioButton) rg.findViewById(R.id.radio23);
	  				r4.setText(R.string.op4);
	  				// TODO Auto-generated method stub
	  				
	  			}
	  		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.three_act, menu);
		return true;
	}

}
