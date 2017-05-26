package budgetproject.budget;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.StrictMode;

/**
 * Created by Win10 on 26/5/2560.
 */

public class BudgetTable {
    private DBhelper dbHelper ;
    private SQLiteDatabase writeSQLite , readSQLite ;
    private double expense ;
    private String date ;


    public static final String TABLE_BUDGET = "budgetTABLE" ;
    public static final String COLUMN_ID = "_id" ;
    public static final String COLUMN_DATE = "Date" ;
    public static final String COLUMN_EXPENSE = "Expense" ;


    public BudgetTable(Context context) {
        dbHelper = new DBhelper(context) ;
        writeSQLite = dbHelper.getWritableDatabase();
        readSQLite = dbHelper.getReadableDatabase();

    }
    public Cursor readAllData(){
        Cursor cursor = readSQLite.query(TABLE_BUDGET, new String[]{COLUMN_ID,COLUMN_DATE,COLUMN_EXPENSE},null,null,null,null,null);
        if(cursor != null){
            cursor.moveToFirst();

        }
        return cursor ;
    }
    public double currentBudget(){
        Cursor cursor =  readSQLite.query(TABLE_BUDGET, new String[] {COLUMN_ID,COLUMN_DATE,COLUMN_EXPENSE} ,null,null,null,null,null );
        if(cursor!=null){
            cursor.moveToLast();
            expense = cursor.getDouble(cursor.getColumnIndex(COLUMN_EXPENSE));
        }
        return expense ;
    }
    public String currentDate(){
        Cursor cursor =  readSQLite.query(TABLE_BUDGET, new String[] {COLUMN_ID,COLUMN_DATE,COLUMN_EXPENSE} ,null,null,null,null,null );
        if(cursor!=null){
            cursor.moveToLast();
            date = cursor.getString(cursor.getColumnIndex(COLUMN_DATE));
        }
        return date ;
    }


    public long addValToSQLite(String date , double expense){
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_DATE,date);
        contentValues.put(COLUMN_EXPENSE,expense);
        return writeSQLite.insert(TABLE_BUDGET,null,contentValues) ;
    }
}
