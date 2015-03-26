package beans;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;



public class DoubleDatabase extends SQLiteOpenHelper {

	//database version
	private static final int DATABASE_VERSION = 1;
	
	//database name
	private static final String DATABASE_NAME = "FCDB.db";
	
	//database table name
	private static final String TABLE_NAME = "double_score";
	
	//database columns;
	private static final String ID = "id";
	private static final String PLAYER1_NAME = "player1_name";
	private static final String PLAYER2_NAME = "player2_name";
	private static final String PLAYER1_SCORE = "player1_score";
	private static final String PLAYER2_SCORE = "player2_score";
	private static final String TIME_TYPE = "time_type";

	public DoubleDatabase(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		Log.i("Test", "---------------onCreate--------------------");

		String CREATE_TABLE_STAT = "CREATE TABLE " + TABLE_NAME + "(" + 
						ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
						PLAYER1_NAME + " TEXT," +
						PLAYER2_NAME + " TEXT," +
						PLAYER1_SCORE + " INTEGER," +
						PLAYER2_SCORE + " INTEGER," +
						TIME_TYPE + " TEXT)";
		
		/*CREATE TABLE track(
				  trackid     INTEGER, 
				  trackname   TEXT, 
				  trackartist INTEGER,
				  FOREIGN KEY(trackid) REFERENCES artist(EMP_ID)
				);*/
		
		db.execSQL(CREATE_TABLE_STAT);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		Log.i("Test", "---------------onUpgrade--------------------");

		if(newVersion > oldVersion) 
		{
			db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
			onCreate(db);
		}
		
	}
	
	public void addData(Player win, Player lose, int time) {
		SQLiteDatabase db = this.getWritableDatabase();
		 
	    ContentValues values = new ContentValues();
	    values.put(PLAYER1_NAME, win.getPlayerName());
	    values.put(PLAYER2_NAME, lose.getPlayerName());
	    values.put(PLAYER1_SCORE, win.getPlayerScore());
	    values.put(PLAYER2_SCORE, lose.getPlayerScore());
	    values.put(TIME_TYPE, time);
	 
	    db.insert(TABLE_NAME, null, values);
	    db.close();
	}
	
	public ArrayList<Player> getData(int time) {
	
		ArrayList<Player> List = new ArrayList<Player>();
		
		String selectQuery = "SELECT  * FROM " + TABLE_NAME +" WHERE "+TIME_TYPE+"="+time;
		Log.i("query", selectQuery);
		
		SQLiteDatabase db = this.getReadableDatabase();
		
		Cursor c = db.rawQuery(selectQuery, null);
		 
		Log.i("cntt", String.valueOf(c.getCount()));
		if(c.getCount()>0)
		{

	    if (c.moveToFirst()) {
	    	
	        do {

		        	Player win=new Player();
		        	win.setPlayerName(c.getString(c.getColumnIndex(PLAYER1_NAME)));
		        	win.setPlayerScore(c.getInt(c.getColumnIndex(PLAYER1_SCORE)));
		        	
		        	Player lose=new Player();
		        	lose.setPlayerName(c.getString(c.getColumnIndex(PLAYER2_NAME)));
		        	lose.setPlayerScore(c.getInt(c.getColumnIndex(PLAYER2_SCORE)));
		        	
		        	List.add(win);
		        	List.add(lose);
	        } while (c.moveToNext());
	    }
	    }
		c.close();
		db.close();
		
		return List;
	}

		
	public void delete() {
	    SQLiteDatabase db = this.getWritableDatabase();
	    db.delete(TABLE_NAME, null, null);
	   
	    db.close();
	}
	
}