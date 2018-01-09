package com.example.nisha.inventorymanagement.data;

import android.provider.BaseColumns;

/**
 * Created by nisha on 09-Jan-18.
 */

public final class ProductContract {

    //Private constructor so that contract class will not be instantiated
    private ProductContract(){}



    public static class ProductEntry implements BaseColumns{

        //Table name constant
        public static String TABLE_NAME = "Product_Details";

        //Column name constants
        public static String COLUMN_NAME_PRODUCT_NAME = "product_name";
        public static String COLUMN_NAME_PRICE = "price";
        public static String COLUMN_NAME_QUANTITY = "quantity";
        public static String COLUMN_NAME_IMAGE = "image";
        public static String COLUMN_NAME_SUPPLIER_NAME = "supplier_name";
        public static String COLUMN_NAME_SUPPLIER_EMAIL = "supplier_email";
        public static String COLUMN_NAME_SUPPLIER_PHONE_NUMBER = "supplier_phone_number";
    }
}
