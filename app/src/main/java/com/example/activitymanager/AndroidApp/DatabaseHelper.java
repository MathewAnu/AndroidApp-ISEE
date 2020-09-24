package com.example.activitymanager.AndroidApp;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.support.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public Context context;
    public static final String DATABASE_Name="activity.db";
    public static final String TABLE_NAME="activity_table";
    public static final String COL1="ID";
    public static final String COL2="category";
    public static final String COL3="activity";
    public static final String COL4="date";
    public static final String COL5="description";
    public static final String COL6="time";
    public static final String COL7="duration";


    public DatabaseHelper(@Nullable Context context) {
        super(context,DATABASE_Name, null,1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COL1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL2 + " TEXT, " +
                COL3 + " TEXT, " +
                COL4 + " TEXT, " +
                COL5 + " TEXT, " +
                COL6 + " TEXT, " +
                COL7 + " TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData (String category, String activity, String date,  String description, String time,String duration)
    {   SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2,category);
        contentValues.put(COL3,activity);
        contentValues.put(COL4,date);
        contentValues.put(COL5,description);
        contentValues.put(COL6,time);
        contentValues.put(COL7,duration);
        long result = db.insert(TABLE_NAME,null,contentValues);

        if (result==-1)
        {
            return  false;
        }
        else{
            return  true;
        }
    }

    public Cursor getAllData()
    {
        Cursor res = null;
      SQLiteDatabase db = this.getWritableDatabase();

      if(db != null)
      {
        res = db.rawQuery("select * from "+ TABLE_NAME,null);
      }

      return res;
    }

    public void deleteData()
    {
        SQLiteDatabase db= this.getWritableDatabase();
        db.execSQL("delete from "+ TABLE_NAME);
    }
}
