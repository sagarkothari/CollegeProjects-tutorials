package com.example.test1;

import com.facebook.*;
import com.facebook.model.*;
import com.facebook.widget.FacebookDialog;
import com.facebook.widget.LoginButton;
import com.facebook.widget.WebDialog;
import com.facebook.FacebookException;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;

import beans.DoubleDatabase;
import beans.Player;
import beans.SingleDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class WinnerActivity extends Activity {

	Boolean single;
	TextView tv;
	private static final Uri M_FACEBOOK_URL = Uri.parse("http://m.facebook.com");
	private UiLifecycleHelper fbUiLifecycleHelper;
	WebDialog dialog;
	GraphUser currentFBUser;
	String dialogAction;
	Bundle dialogParams;
	int time;
	Button b,b2;
	LoginButton loginButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_winner);
		tv=(TextView)findViewById(R.id.tv1);
		 b=(Button)findViewById(R.id.button1);
		 b2=(Button)findViewById(R.id.button2);
		final Toast t=Toast.makeText(this, "Network Error", Toast.LENGTH_SHORT);
		loginButton = (LoginButton) findViewById(R.id.loginButton);
		if (loginButton != null) {
		  loginButton.setOnErrorListener(new LoginButton.OnErrorListener() {
		    @Override
		    public void onError(FacebookException error) {
		      if (error != null && !(error instanceof FacebookOperationCanceledException)) {
		        t.show();
		      }
		    }
		  });
		}
		
		SharedPreferences w=PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
		String a1=w.getString("sync_frequency","30" );
		time=Integer.parseInt(a1);
		
		
		fbUiLifecycleHelper = new UiLifecycleHelper(this, new Session.StatusCallback() {
		    @Override
		    public void call(Session session, SessionState state, Exception exception) {
		        // Add code here to accommodate session changes

		    	if (session.isOpened()) {
		            


//		    			    tv.setText("Hello "+ "!");
		    				  
		    			
		    	}
		    }
		});
		fbUiLifecycleHelper.onCreate(savedInstanceState);
		b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				sendChallenge();
//				brag();
			}
		});
		
		b2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				brag();
				
			}
		});
		
		
	setScore();
	}
	

	public UiLifecycleHelper getFbUiLifecycleHelper() {
	    return fbUiLifecycleHelper;
	}

	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.winner, menu);
		return true;
	}
	
	public void setScore()
	{
		SharedPreferences s;
		try{
			
			 s=getSharedPreferences("PlayerType", MODE_PRIVATE);
			single=s.getBoolean("Single", true);
			if(single)
			{
				Player p=getIntent().getParcelableExtra("Sscore");

				tv.setText("Your Score is : "+p.getPlayerScore());
				
				SingleDatabase sd=new SingleDatabase(getApplicationContext());
				
				if(p.getPlayerScore()>sd.getData(time))
				{
				
				sd.addData(p, time);
				}
				b.setVisibility(0);
				b2.setVisibility(0);
				loginButton.setVisibility(0);
			}
			else
			{
				b.setVisibility(4);
				b2.setVisibility(4);
				loginButton.setVisibility(4);
				Player p=getIntent().getParcelableExtra("Winner");
				Player q=getIntent().getParcelableExtra("Loser");

				if(!getIntent().getBooleanExtra("Tie", false)){
					tv.setText("The Winner is "+p.getPlayerName()+" with score : "+p.getPlayerScore());
					
					DoubleDatabase d=new DoubleDatabase(getApplicationContext());
					d.addData(p, q, time);
					
				}

				else{
					tv.setText("You Both Are Equally Capable Lets Try Again.....");
				}
			}
		}catch(Exception e)
		{
			Log.i("In SetScore - winner acti", e.getMessage());
		}
	}
	
	
	
	public void brag()
	{
		
//		Bundle params = new Bundle();
//		params.putString("message", "I just smashed " +
//		    " friends! Can you beat it?");
//		showDialogWithoutNotificationBar("apprequests", params);
		Session s=Session.getActiveSession();
		if(s.isOpened())
		{
		    Bundle params = new Bundle();
		    params.putString("message", "I just smashed " +" friends! Can you beat it?");

		    WebDialog requestsDialog = (
		        new WebDialog.RequestsDialogBuilder(WinnerActivity.this,
		            Session.getActiveSession(),
		            params))
		            .setOnCompleteListener(new WebDialog.OnCompleteListener() {

		                @Override
		                public void onComplete(Bundle values,
		                    FacebookException error) {
		                    if (error != null) {
		                        if (error instanceof FacebookOperationCanceledException) {
		                            Toast.makeText(WinnerActivity.this.getApplicationContext(), 
		                                "Request cancelled", 
		                                Toast.LENGTH_SHORT).show();
		                        } else {
		                            Toast.makeText(WinnerActivity.this.getApplicationContext(), 
		                                "Network Error", 
		                                Toast.LENGTH_SHORT).show();
		                        }
		                    } else {
		                        final String requestId = values.getString("request");
		                        if (requestId != null) {
		                            Toast.makeText(WinnerActivity.this.getApplicationContext(), 
		                                "Request sent",  
		                                Toast.LENGTH_SHORT).show();
		                        } else {
		                            Toast.makeText(WinnerActivity.this.getApplicationContext(), 
		                                "Request cancelled", 
		                                Toast.LENGTH_SHORT).show();
		                        }
		                    }   
		                }

		            })
		            .build();
		    requestsDialog.show();
		}
		else
			Toast.makeText(this, "Please Log in first", Toast.LENGTH_LONG).show();
		
		
	}
	
	public void sendChallenge()
	{
		//This function will invoke the Feed Dialog to post to a user's Timeline and News Feed
		// It will attempt to use the Facebook Native Share dialog
		// If that's not supported we'll fall back to the web based dialog.
		
		
		final Session session = Session.getActiveSession();
		if(session.isOpened())
		{
		Request meRequest = Request.newMeRequest(session, new Request.GraphUserCallback() {

	        @Override
	        public void onCompleted(GraphUser user, Response response) {
	            FacebookRequestError error = response.getError();
	            if (error != null) {
	                Log.e("FaceBook user error", error.toString());
	                
	            } else if (session == Session.getActiveSession()) {
	                // Set the currentFBUser attribute
	            	 currentFBUser = user;
	            }
	        }
	    });
		
		
		

		// This first parameter is used for deep linking so that anyone who clicks the link will start smashing this user
		// who sent the post
		String link = "https://play.google.com/store";
		
		Player p=getIntent().getParcelableExtra("Sscore");
		// Define the other parameters
		String name = "I just Scored " +p.getPlayerScore()+ " in just "+time+" Seconds!! Can You Beat My Score?";
		String caption = "Checkout My FootBall Clicker - Score Speed!";
		String description = "I just Scored " +p.getPlayerScore()+ " in just "+time+" Seconds!! Can You Beat My Score?";
		String picture = "https://fbcdn-sphotos-a-a.akamaihd.net/hphotos-ak-frc1/q77/s720x720/580748_10203435034175651_1011641520_n.jpg";

		if (FacebookDialog.canPresentShareDialog(WinnerActivity.this, FacebookDialog.ShareDialogFeature.SHARE_DIALOG)) {

		    // Create the Native Share dialog
		    FacebookDialog shareDialog = new FacebookDialog.ShareDialogBuilder(WinnerActivity.this)
		    .setLink(link)
		    .setName(name)
		    .setCaption(caption)
		    .setPicture(picture)
		    .build();

		    // Show the Native Share dialog
		    WinnerActivity.this.getFbUiLifecycleHelper().trackPendingDialogCall(shareDialog.present());
		} else {

		    // Prepare the web dialog parameters
		    Bundle params = new Bundle();
		    params.putString("link", link);
		    params.putString("name", caption);
		    params.putString("caption", caption);
		    params.putString("description", description);
		    params.putString("picture", picture);

		    // Show FBDialog without a notification bar
		    showDialogWithoutNotificationBar("feed", params);
		}
		}
		else
			Toast.makeText(this, "Please Log in first", Toast.LENGTH_LONG).show();

	}
	
	private void showDialogWithoutNotificationBar(String action, Bundle params) {
		// TODO Auto-generated method stub
		dialog = new WebDialog.Builder(WinnerActivity.this, Session.getActiveSession(), action, params).
			    setOnCompleteListener(new WebDialog.OnCompleteListener() {
			    @Override
			    public void onComplete(Bundle values, FacebookException error) {
			        if (error != null && !(error instanceof FacebookOperationCanceledException)) {
			            
			        }
			        dialog = null;
			        dialogAction = null;
			        dialogParams = null;
			    }
			}).build();

			Window dialog_window = dialog.getWindow();
			dialog_window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
			    WindowManager.LayoutParams.FLAG_FULLSCREEN);

		 dialogAction = action;
			dialogParams = params;

			dialog.show();
		
			
	}


	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
	  super.onActivityResult(requestCode, resultCode, data);
	  fbUiLifecycleHelper.onActivityResult(requestCode, resultCode, data);
	 // Session.getActiveSession().onActivityResult(this, requestCode, resultCode, data);
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		fbUiLifecycleHelper.onResume();

	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		fbUiLifecycleHelper.onPause();
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		fbUiLifecycleHelper.onSaveInstanceState(outState);
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		fbUiLifecycleHelper.onDestroy();
		
	}
		
}
