package com.example.nisha.inventorymanagement;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.nisha.inventorymanagement.data.Product;
import com.example.nisha.inventorymanagement.data.ProductContract;
import com.example.nisha.inventorymanagement.data.ProductDatabaseHelper;

import static com.example.nisha.inventorymanagement.data.ProductContract.ProductEntry;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private ProductDatabaseHelper productDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        productDatabaseHelper = new ProductDatabaseHelper(this);


        Product product1  = new Product("Lipstick",500,100,"/lipstick.png","Nisha","nisha@gmail.com","1234567891");

        Product product2 = new Product("Foundation",355.5,150,"/foundation.png","Pradip","pradip@gmail.com","7894561230");

        //Insert dummy data
        insertProduct(product1);
        insertProduct(product2);

        //Read dummy data
        Cursor cursor = readProducts();
        displayProductDetails(cursor);
    }

    /* Display Product details using Log */
    private void displayProductDetails(Cursor cursor) {
        if(cursor!=null) {
            while (cursor.moveToNext()) {
                String productName = cursor.getString(
                        cursor.getColumnIndexOrThrow(ProductEntry.COLUMN_NAME_PRODUCT_NAME));
                double price = cursor.getDouble(cursor.getColumnIndexOrThrow(ProductEntry.COLUMN_NAME_PRICE));
                int quantity = cursor.getInt(cursor.getColumnIndexOrThrow(ProductEntry.COLUMN_NAME_QUANTITY));
                String image = cursor.getString(cursor.getColumnIndexOrThrow(ProductEntry.COLUMN_NAME_IMAGE));
                String supplierName = cursor.getString(cursor.getColumnIndexOrThrow(ProductEntry.COLUMN_NAME_SUPPLIER_NAME));
                String supplierEmail = cursor.getString(cursor.getColumnIndexOrThrow(ProductEntry.COLUMN_NAME_SUPPLIER_EMAIL));
                String supplierPhoneNumber = cursor.getString(cursor.getColumnIndexOrThrow(ProductEntry.COLUMN_NAME_SUPPLIER_PHONE_NUMBER));

                Log.d(TAG,"--------------------------------------------------------------------------");
                Log.d(TAG,"Product Name : "+productName);
                Log.d(TAG,"Price : "+price);
                Log.d(TAG,"Quantity : "+quantity);
                Log.d(TAG,"Image :"+image);
                Log.d(TAG,"Supplier Name : "+supplierName);
                Log.d(TAG,"Supplier Email : "+supplierEmail);
                Log.d(TAG,"Supplier Phone Number : "+supplierPhoneNumber);
            }
        }
        cursor.close();
    }

    /* Read the Product Details */
    private Cursor readProducts() {

        SQLiteDatabase db = productDatabaseHelper.getReadableDatabase();
        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                ProductEntry._ID,
                ProductEntry.COLUMN_NAME_PRODUCT_NAME,
                ProductEntry.COLUMN_NAME_PRICE,
                ProductEntry.COLUMN_NAME_QUANTITY,
                ProductEntry.COLUMN_NAME_IMAGE,
                ProductEntry.COLUMN_NAME_SUPPLIER_NAME,
                ProductEntry.COLUMN_NAME_SUPPLIER_EMAIL,
                ProductEntry.COLUMN_NAME_SUPPLIER_PHONE_NUMBER
        };


        Cursor cursor = db.query(
                ProductEntry.TABLE_NAME,                     // The table to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );

        return  cursor;
    }

    /* Inserts Product Details */
    private void insertProduct(Product product) {


        //Get writable database because we want to write in database
        SQLiteDatabase database = productDatabaseHelper.getWritableDatabase();

        //Create content values to put product details in key value fashion
        ContentValues contentValues = new ContentValues();
        contentValues.put(ProductEntry.COLUMN_NAME_PRODUCT_NAME,product.getProductName());
        contentValues.put(ProductEntry.COLUMN_NAME_PRICE,product.getPrice());
        contentValues.put(ProductEntry.COLUMN_NAME_QUANTITY,product.getQuantity());
        contentValues.put(ProductEntry.COLUMN_NAME_IMAGE,product.getImagePath());
        contentValues.put(ProductEntry.COLUMN_NAME_SUPPLIER_NAME,product.getSupplierName());
        contentValues.put(ProductEntry.COLUMN_NAME_SUPPLIER_EMAIL,product.getSupplierEmail());
        contentValues.put(ProductEntry.COLUMN_NAME_SUPPLIER_PHONE_NUMBER,product.getSupplierPhoneNumber());

        long rowsInserted = database.insert(ProductContract.ProductEntry.TABLE_NAME,null,contentValues);

        if(rowsInserted>0){
            //That means row inserted successfully
            Log.d(TAG,rowsInserted + " rows inserted successfully :)");
        }else {
            Log.d(TAG,"Sorry! Product insertion failed :(");
        }
    }
}
