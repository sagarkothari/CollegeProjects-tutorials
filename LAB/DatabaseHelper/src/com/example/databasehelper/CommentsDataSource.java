package com.example.databasehelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class CommentsDataSource {
private SQLiteDatabase database;
private MySqlLiteHelper dbhelper;
private String[] allcolumns={MySqlLiteHelper.COLUMN_ID,MySqlLiteHelper.COLUMN_COMMENT};

public CommentsDataSource(Context context)
{
	dbhelper= new MySqlLiteHelper(context);

}

public void open() throws SQLException
{
	database=dbhelper.getWritableDatabase();
}

public void close()
{
	dbhelper.close();
}

public Comment createComment(String comment)
{
	ContentValues values=new ContentValues();
	values.put(MySqlLiteHelper.COLUMN_COMMENT, comment);
	long insertId=database.insert(MySqlLiteHelper.TABLE_COMMENTS)
}

}
