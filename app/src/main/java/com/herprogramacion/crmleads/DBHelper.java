package com.herprogramacion.crmleads;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by veronica on 04/08/2016.
 */
public class DBHelper extends SQLiteOpenHelper {

    static final String DBNAME = "CursoUPIICSA.db";
    static final int DBVERSION = 1;
    public static final String TABLE_NAME = "CURSO";
    public static final String _ID = "id";

    String sqliteCreate = "CREATE TABLE "
            + TABLE_NAME
            + " ( "
            + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "nombre TEXT, " +
            "descripcion TEXT, " +
            "fechaIni DATE  );";



    public DBHelper(Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqliteCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int currentVersion) {
        db.execSQL("DROP TABLE IF EXIST CURSO");
        db.execSQL(sqliteCreate);
    }
}