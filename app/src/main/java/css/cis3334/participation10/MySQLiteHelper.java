package css.cis3334.participation10;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by akadijevic on 3/31/2017.
 */

public class MySQLiteHelper extends SQLiteOpenHelper{
    // value that stores all the comments
    public static final String TABLE_COMMENTS = "comments";
    //ID given to the each comment entered
    public static final String COLUMN_ID = "_id";
    //value of the specific comment entered
    public static final String COLUMN_COMMENT = "comment";
    public static final String COLUMN_RATING = "rating";
    //value that stores the name of the database that will be created
    private static final String DATABASE_NAME = "commments.db";
    //versio of the created database
    private static final int DATABASE_VERSION = 2;

    // Database creation sql statement
    //CREATE TABLE table_name ( column1 datatype, column2 datatype, column3 datatype,....);
    private static final String DATABASE_CREATE = "create table "
            + TABLE_COMMENTS + "( " + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_COMMENT
            + " text not null,"+ COLUMN_RATING + " text value 1-5);";

    //Assigns a database name and database version that we have declared above
    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    //Called when database created for the first time
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    //Deletes all existing data and recreate the table
    //Defines constants for the table name and table columns
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMMENTS);
        onCreate(db);
    }

}

