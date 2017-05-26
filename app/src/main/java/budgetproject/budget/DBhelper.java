package budgetproject.budget;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Win10 on 26/5/2560.
 */

public class DBhelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "budget_db.db";
    private static final int DATABASE_VERSION = 1 ;
    private static final String CREATE_TABLE = "create table budgetTABLE (_id integer primary key , Date Text , Expense double)" ;
    public  DBhelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION) ;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
