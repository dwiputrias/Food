package com.dwiputri.greatfood.WebService;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

class ControllerHasilLokasi {
    private DBHelper dbHelper;
    private SQLiteDatabase database;

    public static final String TABLE_NAME = "hasillocate";
    public static final String ID = "id";
    public static final String NAMA_MAKANAN = "nama_makanan";
    public static final String ASAL_MAKANAN = "asal_makanan";
    public static final String LOKASI = "lokasi";

    public static final String CREATE_HASILLOKASI = "CREATE TABLE " +TABLE_NAME+" "+
            "("+ID+" integer primary key, "+
            NAMA_MAKANAN+" TEXT, "+
            ASAL_MAKANAN+" TEXT, "+
            LOKASI+" TEXT)";

    private String[] TABLE_COLUMNS = {ID, NAMA_MAKANAN, ASAL_MAKANAN, LOKASI};

    public ControllerHasilLokasi(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public void deleteData() {
        database.delete(TABLE_NAME, null, null);
    }

    public void insertData(int id, String nama_makanan, String asal_makanan, String lokasi) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID, id);
        contentValues.put(NAMA_MAKANAN, nama_makanan);
        contentValues.put(ASAL_MAKANAN, asal_makanan);
        contentValues.put(LOKASI, lokasi);

        database.insert(TABLE_NAME, null, contentValues);
    }

    public ArrayList<ModelHasilLokasi> getData() {
        ArrayList<ModelHasilLokasi> allData = new ArrayList<ModelHasilLokasi>();
        Cursor cursor = null;

        cursor = database.query(TABLE_NAME, TABLE_COLUMNS, null, null, null, null, ID + " ASC");

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            allData.add(parseData(cursor));

            cursor.moveToNext();
        }

        cursor.close();
        return allData;
    }

    private ModelHasilLokasi parseData(Cursor cursor) {
        ModelHasilLokasi curData = new ModelHasilLokasi();

        curData.setId(cursor.getInt(0));
        curData.setNama_makanan(cursor.getString(1));
        curData.setAsal_makanan(cursor.getString(2));
        curData.setLokasi(cursor.getString(3));
        return curData;
    }
}
