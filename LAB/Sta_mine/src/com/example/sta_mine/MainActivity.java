package com.example.sta_mine;

import android.R.bool;
import android.opengl.Visibility;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	Boolean ans=false,fff=false,phaff=false,apf=false,flipf=false; //flags for all the lifelines 
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final Toast t2=Toast.makeText(this, "Incorrect answer \n Application will exit \n You Won : Nothing ", Toast.LENGTH_LONG);
      final   Intent i = new Intent(this,Second_activity.class);
       final RadioGroup rg=(RadioGroup) findViewById(R.id.radioGroup1);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				// TODO Auto-generated method stub
				
				if(arg1!=-1)
				{
					RadioButton b=(RadioButton) findViewById(arg1);
					if(b.getText().toString().equals("Dhaka") || b.getText().toString().equals("Swiss Franc"))
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
        
        
        Button ff=(Button) findViewById(R.id.button1);
        Button phaf=(Button) findViewById(R.id.button2);
        Button ap=(Button) findViewById(R.id.button4);
        Button flip=(Button) findViewById(R.id.button3);
        Button next=(Button) findViewById(R.id.button5);
       final Intent call= new Intent();
        
        ff.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				System.out.println("onclick listner");

				fff=true;
				RadioButton r=(RadioButton) rg.findViewById(R.id.radio2);
				r.setVisibility(8);
				RadioButton r1=(RadioButton) rg.findViewById(R.id.radio3);
				r1.setVisibility(8);
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
        
       final Toast t=Toast.makeText(this, "Delhi -> 35% \n Dhaka -> 45% \n Sri Lanka -> 10% \n Nepal City -> 10%", Toast.LENGTH_LONG);
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
				TextView t=(TextView) findViewById(R.id.textView1);
				t.setText(R.string.que);
				RadioButton r=(RadioButton) rg.findViewById(R.id.radio2);
				r.setText(R.string.op3);
				RadioButton r1=(RadioButton) rg.findViewById(R.id.radio0);
				r1.setText(R.string.op1);
				RadioButton r2=(RadioButton) rg.findViewById(R.id.radio1);
				r2.setText(R.string.op2);
				RadioButton r4=(RadioButton) rg.findViewById(R.id.radio3);
				r4.setText(R.string.op4);
				// TODO Auto-generated method stub
				
			}
		});
        
        next.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
