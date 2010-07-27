package com.example;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBAdapter extends Activity {
	private static final String DATABASE_NAME = "database";
	private static final int DATABASE_VERSION = 3;
	public static Context context;
	private DBHelper mDBHelper;
	private SQLiteDatabase db;
	
	
	public DBAdapter() {
		mDBHelper = new DBHelper(context);
		
	}

	public class DBHelper extends SQLiteOpenHelper {

		public DBHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			
			
		}
		
		@Override
		public void onCreate(SQLiteDatabase db) {

		//	db.execSQL(Gameids.CREATE_QUERY);
			db.execSQL(ids.CREATE_QUERY);
			try {

			} catch (SQLException se) {
				Log.v("DBAdapter","OnCreateError");
				se.printStackTrace();
			}
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

		}

	}

	protected Cursor selectQuery(String sql, String[] args) {
		Cursor cursor = null;
	//	String[] argv = (String[]) args;
		try {
			db = mDBHelper.getWritableDatabase();
			Log.v("Select Query", "" + sql);
			
			cursor = db.rawQuery(sql,args);
			Log.v("Select Query Cursor Count", "" + cursor.getCount());

			db.close();

		} catch (Exception e) {
			Log.v("DBAdapter","selectQuery");			
			e.printStackTrace();
		}

		return cursor;

	}

	protected void Query(String sql, Object[] bindArgs) {
		try {
			db = mDBHelper.getWritableDatabase();
			db.execSQL(sql, bindArgs);
			db.close();
		} catch (Exception e) {
			Log.v("DBAdapter","Query");			
			e.printStackTrace();
		}
	}
	
	public void closeDatabase() {
		db.close();
		
	}
	public void deleteQuery(String sql)
	{
		try {
			db = mDBHelper.getWritableDatabase();
			db.execSQL(sql);
			db.close();
		} catch (Exception e) {
			Log.v("DBAdapter","deleteQuery");			
			e.printStackTrace();
		}
	}

}// end DBAdapter