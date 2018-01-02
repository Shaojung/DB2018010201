package com.example.student.db2018010201.data;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by student on 2018/1/2.
 */

public class StudentDAOImpl {
    public static ArrayList<Student> mylist = new ArrayList();
    public void add(Student s)
    {
        mylist.add(s);
    }
    public void printOut()
    {
        for (Student t : mylist)
        {
            Log.d("DATA", t.toString());
        }
    }
}
