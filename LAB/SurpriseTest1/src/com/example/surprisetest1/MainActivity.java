package com.example.surprisetest1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	EditText usr,pass;
	Button b;
	String us,pas;
	Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usr=(EditText) findViewById(R.id.editText2);
        pass=(EditText) findViewById(R.id.editText1);
        
        b=(Button) findViewById(R.id.button1);
        
        
        
        b.setOnClickListener(this);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onClick(View arg0) {
		us=usr.getText().toString();
		pas=pass.getText().toString();
		i=new Intent(this, SecondActivity.class);
		
		if(us.equals("sagar") && pas.equals("12345"))
		{
			startActivity(i);
			
		}
		else
			Toast.makeText(this, "Invalid username or password", Toast.LENGTH_LONG).show();
		
	}
    
}
