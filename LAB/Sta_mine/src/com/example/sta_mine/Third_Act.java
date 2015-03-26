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

public class Third_Act extends Activity {
	
	Boolean fff,phaff,apf,flipf,ans=false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_third_);
		
		 fff=(Boolean) getIntent().getBooleanExtra("fpf", false);
		 phaff=(Boolean) getIntent().getBooleanExtra("ppf", false);
	 apf=(Boolean) getIntent().getBooleanExtra("ppf", false);
		flipf=(Boolean) getIntent().getBooleanExtra("fppf", false);
		
		  Button ff=(Button) findViewById(R.id.button31);
	        Button phaf=(Button) findViewById(R.id.button32);
	        Button ap=(Button) findViewById(R.id.button34);
	        Button flip=(Button) findViewById(R.id.button33);
	        
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
	        
	        final Toast t2=Toast.makeText(this, "Incorrect answer \n Application will exit \n You Won : 1000000rs ", Toast.LENGTH_LONG);
	        final   Intent i = new Intent(this,Winner.class);
	         final RadioGroup rg=(RadioGroup) findViewById(R.id.radioGroup31);
	          rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
	  			
	  			@Override
	  			public void onCheckedChanged(RadioGroup arg0, int arg1) {
	  				// TODO Auto-generated method stub
	  				
	  				if(arg1!=-1)
	  				{
	  					RadioButton b=(RadioButton) findViewById(arg1);
	  					if(b.getText().toString().equals("OS") || b.getText().toString().equals("Swiss Franc"))
	  					{
	  						ans=true;
	  						System.out.println("selected correct ans");
	  						i.putExtra("fff", fff);
	  						i.putExtra("apf", apf);
	  						i.putExtra("flipf", flipf);
	  						i.putExtra("phaff", phaff);
	  						
	  						startActivity(i);
	  					}
	  					else
	  					{
	  						t2.show();
	  						finish();
	  					}
	  				}
	  			}
	  		});
	          
	          
	          
	          
	        /* final Intent call= new Intent();
	          
	          ff.setOnClickListener(new View.OnClickListener() {
	  			
	  			@Override
	  			public void onClick(View arg0) {
	  				// TODO Auto-generated method stub
	  				System.out.println("onclick listner");

	  				fff=true;
	  				RadioButton r=(RadioButton) rg.findViewById(R.id.radio32);
	  				r.setEnabled(false);
	  				RadioButton r1=(RadioButton) rg.findViewById(R.id.radio30);
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
	          
	         final Toast t=Toast.makeText(this, "Language -> 5% \n OS -> 75% \n variable -> 10% \n method -> 10%", Toast.LENGTH_LONG);
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
	  				TextView t=(TextView) findViewById(R.id.textView31);
	  				t.setText(R.string.que);
	  				RadioButton r=(RadioButton) rg.findViewById(R.id.radio32);
	  				r.setText(R.string.op3);
	  				RadioButton r1=(RadioButton) rg.findViewById(R.id.radio30);
	  				r1.setText(R.string.op1);
	  				RadioButton r2=(RadioButton) rg.findViewById(R.id.radio31);
	  				r2.setText(R.string.op2);
	  				RadioButton r4=(RadioButton) rg.findViewById(R.id.radio33);
	  				r4.setText(R.string.op4);
	  				// TODO Auto-generated method stub
	  				
	  			}
	  		});*/
	          
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.third_, menu);
		return true;
	}

}
