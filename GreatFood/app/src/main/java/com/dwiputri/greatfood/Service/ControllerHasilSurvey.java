package com.dwiputri.greatfood.Service;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;


import java.util.ArrayList;

public class ControllerHasilSurvey {
    private DBHelp dbHelper;
    private SQLiteDatabase database;

    public static final String TABLE_NAME = "hasilsurvei";
    public static final String ID_SURVEY = "id_survey";
    public static final String NAMA = "nama";
    public static final String PERSEN = "persen";

    public static final String CREATE_HASILSURVEY = "CREATE TABLE " +TABLE_NAME+" "+
            "("+ID_SURVEY+" integer primary key, "+
            NAMA+" TEXT, "+
            PERSEN+" TEXT)";

    private String[] TABLE_COLUMNS = {ID_SURVEY, NAMA, PERSEN};

    public ControllerHasilSurvey(Context context) {
        dbHelper = new DBHelp(context);
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

    public void insertData(int id_survey, String nama, String persen) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID_SURVEY, id_survey);
        contentValues.put(NAMA, nama);
        contentValues.put(PERSEN, persen);

        database.insert(TABLE_NAME, null, contentValues);
    }

    public ArrayList<ModelHasilSurvey> getData() {
        ArrayList<ModelHasilSurvey> allData = new ArrayList<ModelHasilSurvey>();
        Cursor cursor = null;

        cursor = database.query(TABLE_NAME, TABLE_COLUMNS, null, null, null, null, ID_SURVEY + " ASC");

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            allData.add(parseData(cursor));

            cursor.moveToNext();
        }

        cursor.close();
        return allData;
    }

    private ModelHasilSurvey parseData(Cursor cursor) {
        ModelHasilSurvey curData = new ModelHasilSurvey();

        curData.setId_survey(cursor.getInt(0));
        curData.setNama(cursor.getString(1));
        curData.setPersen(cursor.getString(2));
        return curData;
    }
}
