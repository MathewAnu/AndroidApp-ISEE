package com.example.manishrchandran.AndroidApp;
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
    //public static final String COL3="category";
    public static final String COL4="date";
    public static final String COL5="description";
    //public static final String COL6="color";
    public static final String COL6="time";
    public static final String COL7="duration";


    public DatabaseHelper(@Nullable Context context) {
        //create our database
        super(context,DATABASE_Name, null,1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       // db.execSQL("create table "+ TABLE_NAME +"(ID INTEGER PRIMARY KEY AUTOINCREMENT, activity TEXT, category TEXT, date TEXT, description TEXT, color TEXT, time TEXT, duration TEXT, repeatvalue TEXT)");
       // db.execSQL("create table "+ TABLE_NAME +"(ID INTEGER PRIMARY KEY AUTOINCREMENT, category TEXT, activity TEXT, date TEXT, description TEXT, time TEXT, duration TEXT)");

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

    //public boolean insertData (String activity, String category, String date,  String description, String color,String time,String duration, String enddate )
    public boolean insertData (String category, String activity, String date,  String description, String time,String duration)
    {
        //insert data to the database
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2,category);
        contentValues.put(COL3,activity);
        //contentValues.put(COL3,category);
        contentValues.put(COL4,date);
        contentValues.put(COL5,description);
        //contentValues.put(COL6,color);
        contentValues.put(COL6,time);
        contentValues.put(COL7,duration);
//        contentValues.put(COL9,repeat);
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
        //get data from database
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

    /*

    //public boolean updateData(String activity, String category, String date,  String description, String color,String time,String duration, String enddate) {
    public boolean updateData(String category, String activity,  String date,  String description, String time,String duration) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
//        contentValues.put(COL1,id);
        contentValues.put(COL2,category);
        contentValues.put(COL3,activity);
       // contentValues.put(COL3,category);
        contentValues.put(COL4,date);
        contentValues.put(COL5,description);
        //contentValues.put(COL6,color);
        contentValues.put(COL6,time);
        contentValues.put(COL7,duration);
        db.update(TABLE_NAME, contentValues, "ID = ?",new String[] { activity});
        return true;
    }

     */
}
