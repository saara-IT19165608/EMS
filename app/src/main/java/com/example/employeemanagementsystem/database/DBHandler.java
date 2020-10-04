package com.example.employeemanagementsystem.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHandler extends SQLiteOpenHelper {

    public static final String DB_NAME="Employee.db";
    public static final int DB_VERSION= 1;


    public DBHandler( Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String EMPLOYEE_TABLE = "CREATE TABLE "+ Employee.EmpDetails.TABLE_NAME+ "(" +
                Employee.EmpDetails.COL_ID+"INTEGER PRIMARY KEY,"+
                Employee.EmpDetails.COL_NAME+" TEXT,"+
                Employee.EmpDetails.COL_NUMBER+" TEXT,"+
                Employee.EmpDetails.COL_DEPARTMENT+" TEXT )";

        db.execSQL(EMPLOYEE_TABLE);
    }
    //----------------------insert-------------

    public boolean addEmployee(int id ,String name ,String number,String department){
        SQLiteDatabase db =getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(Employee.EmpDetails.COL_ID,id);
        values.put(Employee.EmpDetails.COL_NAME,name);
        values.put(Employee.EmpDetails.COL_NUMBER,number);
        values.put(Employee.EmpDetails.COL_DEPARTMENT,department);

        long sid =db.insert(Employee.EmpDetails.TABLE_NAME,null,values);

        if (sid>0)
            return true;
        else
            return false;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
