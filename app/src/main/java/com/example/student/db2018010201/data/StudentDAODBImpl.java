package com.example.student.db2018010201.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by student on 2018/1/9.
 */

public class StudentDAODBImpl implements StudentDAO {
    Context context;
    public StudentDAODBImpl(Context context)
    {
        this.context = context;
    }
    @Override
    public boolean add(Student s) {
        MyHelper helper = new MyHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", s.name);
        cv.put("score", s.score);
        db.insert("phone", null, cv);
        return true;
    }

    @Override
    public ArrayList<Student> getList() {
        MyHelper helper = new MyHelper(context);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor c = db.query("phone", new String[] {"_id", "name", "score"}, null
        , null, null, null, null);
        ArrayList<Student> mylist = new ArrayList<>();
        if (c.moveToFirst())
        {
            Student s = new Student(c.getInt(0), c.getString(1), c.getInt(2));
            mylist.add(s);
            while(c.moveToNext())
            {
                Student s1 = new Student(c.getInt(0), c.getString(1), c.getInt(2));
                mylist.add(s1);
            }
        }
        return mylist;
    }

    @Override
    public void printOut() {

    }

    @Override
    public Student getStudent(int id) {
        MyHelper helper = new MyHelper(context);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor c = db.query("phone", new String[] {"_id", "name", "score"},
                "_id=?", new String[] {String.valueOf(id)}, null, null, null);
        c.moveToFirst();
        Student s = new Student(c.getInt(0), c.getString(1), c.getInt(2));
        return s;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public void update(Student s) {

    }
}
