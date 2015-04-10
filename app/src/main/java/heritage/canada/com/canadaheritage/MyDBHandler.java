package heritage.canada.com.canadaheritage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 3/20/15.
 */
class MyDBHandler extends SQLiteOpenHelper {

    // All Static variables
// Database Version


    private static final int DATABASE_VERSION = 1;
    // Database Name

    private static final String DATABASE_NAME = "location.db";
    private static final String TABLE="locations";
    private static final String DB_PATH_SUFFIX = "/databases/";
    protected static Context ctx;

    public MyDBHandler(Context context) {

        super(context,DATABASE_NAME, null, DATABASE_VERSION);
        ctx = context;

    }

   /* public void setDBname(String name){
        this.dbname = name;
    }*/



    // Getting single contact
    public Location_list Get_ContactDetails(int n) {
        SQLiteDatabase db = this.getReadableDatabase();


        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE, null);


        if (cursor != null && cursor.move(n)){
            Location_list cont = new  Location_list(cursor.getString(0), cursor.getString(1));
// return contact
            cursor.close();
            db.close();

            return cont;

        }
        return null;
    }

    public List Get_Name() {
        List names = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Location_list comment = cursorToComment(cursor);
            names.add(comment);  //add list
            cursor.moveToNext();
        }
// Make sure to close the cursor
        cursor.close();
        return names;
    }

    private Location_list cursorToComment(Cursor cursor) {
        Location_list comment = new Location_list();
        comment.setName(cursor.getString(0));
        comment.setZone(cursor.getString(1));
        return comment;
    }

    public void CopyDataBaseFromAsset() throws IOException{

        InputStream myInput = ctx.getAssets().open(DATABASE_NAME);

// Path to the just created empty db
        String outFileName = getDatabasePath();

// if the path doesn't exist first, create it
        File f = new File(ctx.getApplicationInfo().dataDir + DB_PATH_SUFFIX);
        if (!f.exists())
            f.mkdir();

// Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);

// transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }

// Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();

    }
    private  String getDatabasePath() {
        return ctx.getApplicationInfo().dataDir + DB_PATH_SUFFIX
                + DATABASE_NAME;
    }

    public SQLiteDatabase openDataBase() throws SQLException{
        File dbFile = ctx.getDatabasePath(DATABASE_NAME);

        if (!dbFile.exists()) {
            try {
                CopyDataBaseFromAsset();
                System.out.println("Copying sucess from Assets folder");
            } catch (IOException e) {
                throw new RuntimeException("Error creating source database", e);
            }
        }

        return SQLiteDatabase.openDatabase(dbFile.getPath(), null, SQLiteDatabase.NO_LOCALIZED_COLLATORS | SQLiteDatabase.CREATE_IF_NECESSARY);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// TODO Auto-generated method stub

    }
}
