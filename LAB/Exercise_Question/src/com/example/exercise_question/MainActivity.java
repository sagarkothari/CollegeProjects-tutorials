package com.example.exercise_question;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	   
	   String []a=new String[2];
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
   final   Intent i=new Intent(this, SecondActivity.class);
      
        
        RadioGroup group1=(RadioGroup) findViewById(R.id.radioGroup1);
        group1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				// TODO Auto-generated method stub
			if(arg1!=-1)
			{
				RadioButton b=(RadioButton)findViewById(arg1);
				if(b!=null)
					a[0]=b.getText().toString();
			}
			}
		});
        
        
        RadioGroup group2=(RadioGroup) findViewById(R.id.radioGroup2);
        group2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				if(checkedId!=-1)
				{
					RadioButton b=(RadioButton)findViewById(checkedId);
					if(b!=null)
						a[1]=b.getText().toString();
				}
			}
		});
        
        
        
        i.putExtra("first", a);
       
        Button c=(Button) findViewById(R.id.button1);
        c.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			
				startActivity(i);
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
