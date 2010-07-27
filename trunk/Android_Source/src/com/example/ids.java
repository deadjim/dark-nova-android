package com.example;

import android.database.Cursor;
import android.util.Log;

import com.example.SCgame;

public class ids extends DBAdapter {

	public static final String CREATE_QUERY = "CREATE TABLE Variablesidtable(gamename varchar,name varchar);";

	public ids() {
		super();
	}

	public void savegame(SCgame scgame) {
		
		String insertQuery = "Insert INTO Variablesidtable (gamename,name) VALUES( ?, ?)";
		Object[] args = { scgame.getName1(),scgame.getName() };
		this.Query(insertQuery, args);

	};

	public Cursor Selectgame() {

		String selectQuery = "Select * from Variablesidtable";
		Cursor cursor = this.selectQuery(selectQuery, null);
		
		if (cursor != null) {
			cursor.moveToFirst();
			do {
				Log.v("Value From Cursor", "" + cursor.getString(1));
			} while (cursor.moveToNext());
		}
		return cursor;
	}
	
	public Cursor SelectgameName() {

		String selectQuery = "Select * from Variablesidtable";
		Cursor cursor = this.selectQuery(selectQuery, null);
		
	//	if (cursor != null) {
	//		cursor.moveToFirst();
	//		do {
				Log.v("Value From Cursor", "" + cursor.getString(1));
	//		} while (cursor.moveToNext());
	//	}
		return cursor;
	}
	
}
