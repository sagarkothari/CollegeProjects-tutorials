package com.example.login_form;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	
	Button Reg_click;
	
	EditText et1,et2,et3,et4,et5;
	TextView tv1[];
	String a[]=new String[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Reg_click=(Button) findViewById(R.id.button1);
        Reg_click.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
    public void onClick(View arg0) {
    	// TODO Auto-generated method stub
    	et1=(EditText) findViewById(R.id.editText1);
    	et2=(EditText) findViewById(R.id.editText2);
    	et3=(EditText) findViewById(R.id.editText3);
    	et4=(EditText) findViewById(R.id.editText4);
    	et5=(EditText) findViewById(R.id.editText5);
    	
    	a[0]= et1.getText().toString();
   	a[1]= et2.getText().toString();
   	
   	
    	a[2]= et3.getText().toString();
    	a[3]= et4.getText().toString();
    	a[4]= et5.getText().toString();

    if(a[3].equalsIgnoreCase("male") || a[3].equalsIgnoreCase("female") )
    {
    	Intent i =new Intent(this, SubActivity.class);
    	i.putExtra("name", a);
   // et1.setText(a[3]);	
    	startActivity(i);
   }
    else 
    	et4.setText("Either Male or Female..!!");
   }
}
