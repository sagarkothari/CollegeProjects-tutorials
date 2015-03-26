package com.example.sampleapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class CustomListViewAdapter extends BaseAdapter {

	Context context;
	String[] str_arr_txt;
	Button b;
	TextView tv;
	
	public CustomListViewAdapter(Context context, String[] str_arr_txt) {
		this.context = context;
		this.str_arr_txt = str_arr_txt;
		
	}
	
	@Override	
	public int getCount() {
		// TODO Auto-generated method stub
		return str_arr_txt.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public long getItemId(int arg0) {
		// 
		return 0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
	final	LayoutInflater infla=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		final View v=infla.inflate(R.layout.list_layout,arg2,false);
		
		 tv =(TextView) v.findViewById(R.id.textView12);
		b=(Button) v.findViewById(R.id.button12);
		b.setTag(arg0);
		
		tv.setText(str_arr_txt[arg0]);
		
		
		
		//final int q=arg0;
	//	final View w=arg1;
		final ViewGroup e=arg2;
		View.OnClickListener myhandler1 = new View.OnClickListener() {
		    public void onClick(View v) {
		      // it was the 1st button
		    	str_arr_txt[(Integer) v.getTag()]=null;
		    	 notifyDataSetChanged();
		    	
	     }
		};
		b.setOnClickListener(myhandler1);
		
		
		
	//	 b.setOnClickListener(new View.OnClickListener() {
      //      public void onClick(View vi) {
       //         str_arr_txt[(Integer) vi.getTag()]=null;
               
                
        //    }
       // });
		
		return v;
	}

	

}
