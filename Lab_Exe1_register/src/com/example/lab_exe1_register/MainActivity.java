package com.example.lab_exe1_register;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {

	Button b;
	String [] a=new String[2];
	EditText et1,et2;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=(Button) findViewById(R.id.button1);
        b.setOnClickListener(this); 
			
		
        
    }
    
    	@Override
    	public void onClick(View arg0) {
    		// TODO Auto-generated method stub
    	et1=(EditText) findViewById(R.id.editText4);
    	et2=(EditText) findViewById(R.id.editText5);
    	
    	a[0]=et1.getText().toString();
    	a[1]=et2.getText().toString();
    	
    	Intent i=new Intent(this,Sub_activity.class);
    	i.putExtra("Values", a);
    	startActivity(i);
    	
    	}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
