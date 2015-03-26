package com.example.asynctaskexample;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

public class AsyncTaskExampleActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        new AsyncTaskExample().execute();
    }
    
    public class AsyncTaskExample extends AsyncTask<Void, Void, Void> {
    	
    	ProgressDialog dialog = new ProgressDialog(AsyncTaskExampleActivity.this);

		@Override
		protected Void doInBackground(Void... arg0) {
			for(int i=0;i<1000;i++) {
				Log.i("Test", "%%%%%%%%%%%%%%%%%%%%%%%%%%");
			}
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			
			if(this.dialog.isShowing()) {
				this.dialog.dismiss();
			}
		}

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			
			this.dialog.setMessage("Loading....");
			this.dialog.show();
		}
		
		
    	
    }
}