package com.example.databasehelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MySqlLiteHelper extends SQLiteOpenHelper {

	
	public static final String TABLE_COMMENTS="comments";
	public static final String COLUMN_ID="id";
	public static final String COLUMN_COMMENT="comment";
	
	private static final String DATABASE_NAME="comments_db";
	private static final int DATABASE_VERSION=1;
	
	private String DATABASE_CREATE="create table" + TABLE_COMMENTS + "(" +COLUMN_ID+" integer primary key autoincrement, "+ COLUMN_COMMENT+" text not null);";
	
	public MySqlLiteHelper(Context context) {
		
		super(context,DATABASE_NAME , null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub
		arg0.execSQL(DATABASE_CREATE);

	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		arg0.execSQL("drop table if exists "+TABLE_COMMENTS);
		onCreate(arg0);
	}

}
