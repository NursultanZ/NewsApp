package com.example.acer.newsapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.acer.newsapp.news_fragments.News24Fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Acer on 27.06.2016.
 */
public class NewsDataBase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "newsApp";
    final String LOG_TAG = "NewsDataBase";
    private static final int DATABASE_VERSION = 1;

    public NewsDataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d(LOG_TAG, "Вызов конструктора");
        Log.d(LOG_TAG, "Создание Базы Данных");
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(LOG_TAG, "Функция onCreate создание таблиц БД");
        String sQuery = "CREATE TABLE NEWS (id integer primary key autoincrement, news_title text," +
                "news_date text, news_desc text, news_image text, news_category text, news_link text, news_source text);";
        db.execSQL(sQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void addNews(News n) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("news_title", n.getNews_title());
        cv.put("news_date", n.getNews_date());
        cv.put("news_category", n.getNews_category());
        cv.put("news_desc", n.getNews_desc());
        cv.put("news_image", n.getNews_image());
        cv.put("news_source", n.getNews_source());
        db.insert("NEWS", null, cv);
        Log.d("Add note", n.toString());
        db.close();
    }
    public List<News> getAllNews() {
        List<News> noteList = new ArrayList<News>();
        String selectQuery = "SELECT * FROM NEWS ORDER BY id DESC";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                News note = new News();
                note.setNews_id(Integer.valueOf(cursor.getString(0)));
                note.setNews_title(cursor.getString(1));
                note.setNews_date(cursor.getString(2));
                note.setNews_image(cursor.getString(3));
                note.setNews_desc(cursor.getString(4));
                note.setNews_category(cursor.getString(5));
                note.setNews_source(cursor.getString(6));
                Log.d(LOG_TAG, note.toString());
                noteList.add(note);
            } while (cursor.moveToNext());
        }
        db.close();
        return noteList;
    }
}
