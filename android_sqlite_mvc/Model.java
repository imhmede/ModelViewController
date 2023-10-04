/**
 * This is the model, and it stores and retrieves data from/into SQLite database.
 * It acts as a model for the app.
 * @author  Essa Imhmed
 * Oct 2, 2023
 */

package com.example.helloworldsqllite;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Overriding SQLiteOpenHelper, which is responsible for database creation and
 * version management.
 */
public class Model extends SQLiteOpenHelper {
    /**
     * Class data members used to create a database including tables if
     * it doesn't exist
     */
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "universityDirectory";
    private static final String TABLE_CONTACTS = "contacts";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String TITLE = "title";
    private static final String PHONE = "phone";
    private static final String OFFICE = "office";
    private static final String STATION = "station";

    /**
     * This is the SQLiteOpenHelper's constructor, defining where/when the database
     * exists.
     * @param context the ActivityName.this
     */
    public Model(Context context) {
        // Create a helper object to create, open, and/or manage a database.
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * This function create a table
     * @param sqLiteDatabase a database object to create, delete, execute SQL commands
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + ID + " INTEGER PRIMARY KEY," + NAME + " TEXT,"
                + TITLE + " TEXT," + PHONE + " TEXT, "
                + OFFICE + " TEXT," + STATION + " TEXT" +")";
        Log.d("name", CREATE_CONTACTS_TABLE );
        sqLiteDatabase.execSQL(CREATE_CONTACTS_TABLE);
    }

    /**
     * This function writes the cashed database into the actual database
     * @param sqLiteDatabase a database object
     * @param oldVersion database old version
     * @param newVersion database new version
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase,  int oldVersion, int newVersion) {
        // Drop older table if existed
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        // Create tables again
        onCreate(sqLiteDatabase);

    }

    /**
     * This function adds a new user to the database
     * @param user user data structure object
     */
    void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME, user.getName()); // Contact Name
        values.put(TITLE, user.getTitle()); // Contact title
        values.put(PHONE, user.getPhone()); // Contact Phone
        values.put(OFFICE, user.getOffice()); // Contact office
        values.put(STATION, user.getStation()); // Contact station

        // Inserting Row
        Log.d("name", values.toString());
        db.insert(TABLE_CONTACTS, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    /**
     * This function retrieves all contacts from the database
     * @return  a list of objects containing contact information
     */
    public List<User> getAllContacts() {
        List<User> userList = new ArrayList<User>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                User contact = new User();
                contact.setID(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setTitle(cursor.getString(2));
                contact.setPhone(cursor.getString(3));
                contact.setOffice(cursor.getString(4));
                contact.setStation(cursor.getString(5));
                System.out.println("name: " + contact.getName());
                // Adding contact to list
                userList.add(contact);
            } while (cursor.moveToNext());
        }

        // return contact list
        return userList;
    }
}
