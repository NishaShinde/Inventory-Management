package com.example.nisha.inventorymanagement.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static com.example.nisha.inventorymanagement.data.ProductContract.ProductEntry;
/**
 * Created by nisha on 09-Jan-18.
 */

public class ProductDatabaseHelper extends SQLiteOpenHelper {

    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "ProductDetails.db";
    private static final String TAG = ProductDatabaseHelper.class.getSimpleName();


    public ProductDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //CREATE TABLE query
    private static final String CREATE_TABLE_QUERY = "CREATE TABLE "+ ProductEntry.TABLE_NAME + "(" +
            ProductEntry._ID + " INTEGER PRIMARY KEY, "+ ProductEntry.COLUMN_NAME_PRODUCT_NAME + " TEXT, "+
            ProductEntry.COLUMN_NAME_PRICE + " REAL, "+ProductEntry.COLUMN_NAME_QUANTITY + " INTEGER,"+
            ProductEntry.COLUMN_NAME_IMAGE + " TEXT, "+ProductEntry.COLUMN_NAME_SUPPLIER_NAME + " TEXT,"+
            ProductEntry.COLUMN_NAME_SUPPLIER_EMAIL + " TEXT," + ProductEntry.COLUMN_NAME_SUPPLIER_PHONE_NUMBER + " TEXT);";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + ProductEntry.TABLE_NAME;

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG,CREATE_TABLE_QUERY);
        db.execSQL(CREATE_TABLE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
