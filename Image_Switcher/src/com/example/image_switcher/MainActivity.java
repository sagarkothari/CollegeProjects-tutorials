package com.example.image_switcher;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnClickListener {

	
	Button b1,b2;
	Integer []a={R.drawable.a11651,R.drawable.jerry,R.drawable.nw12028,R.drawable.tomjerry5
			,R.drawable.tweety};
	int i=0;
	ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button) findViewById(R.id.button1);
        b2=(Button) findViewById(R.id.button2);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b2.setClickable(false);
iv=(ImageView) findViewById(R.id.imageView1);
        //a[0]=(Integer)findViewById(R.drawable.a11651);
       
    }

    @Override
    public void onClick(View arg0) {
    	// TODO Auto-generated method stub
    	switch(arg0.getId())
    	{
    	case R.id.button1:
    		i++;
    		iv.setImageResource(a[i]);
    		if(i==1)b2.setClickable(true);
    	if(i==4)
    		{	
    			b1.setClickable(false);
    		}
    	break;
    	
    	case R.id.button2:
    		/*Intent i=new Intent();
    		i.setAction(android.content.Intent.ACTION_CALL).setData(Uri.parse("tel:"+9234534));
    		startActivity(i);*/
    		i--;
    		iv.setImageResource(a[i]);
    		if(i==3)b1.setClickable(true);
    	if(i==0)
    		{	
    			b2.setClickable(false);
    		}
    	break;
    	
    	}
    	
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
