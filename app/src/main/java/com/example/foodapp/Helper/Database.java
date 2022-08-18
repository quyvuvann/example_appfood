package com.example.foodapp.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.foodapp.Doman.Account;

public class Database extends SQLiteOpenHelper {
    public static String DATABASE_NAME = "doctruyen";

    public static String TABLE_TAIKHOAN = "taikhoan";
    public static String ID_TAIKHOAN = "idtaikhoan";
    public static String NAME_TAIKHOAN = "nametaikhoan";
    public static String PASSWORD = "password";
    public static String EMAIL = "email";
    public static String PHANQUYEN = "phanquyen";
    public static int VERSION = 1;
    Context context;

    public String SQLquery = "CREATE TABLE " + TABLE_TAIKHOAN +" ( "
            + ID_TAIKHOAN +" INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NAME_TAIKHOAN + " TEXT UNIQUE, "+
            PASSWORD + " TEXT, "+  EMAIL + " TEXT, " + PHANQUYEN + " INTEGER) ";

    public String SQLquery2 = "INSERT INTO taikhoan VALUES (null,'admin','admin','admin@gmail.com',2)";
    public String SQLquery3 = "INSERT INTO taikhoan VALUES (null,'quy','quy123','quy@gmail.com',1)";

    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLquery);
        db.execSQL(SQLquery2);
        db.execSQL(SQLquery3);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public Cursor getdata(){
        SQLiteDatabase sqLiteDatabase =this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " +TABLE_TAIKHOAN,null);
        return cursor;
    }
    public void addUsername(Account account){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME_TAIKHOAN,account.getUser());
        contentValues.put(PASSWORD,account.getPassword());
        contentValues.put(EMAIL,account.getEmail());
        contentValues.put(PHANQUYEN,account.getPhanquyen());
        sqLiteDatabase.insert(TABLE_TAIKHOAN,null,contentValues);
        sqLiteDatabase.close();
    }

}
