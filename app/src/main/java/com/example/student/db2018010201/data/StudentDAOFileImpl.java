package com.example.student.db2018010201.data;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by student on 2018/1/2.
 */

public class StudentDAOFileImpl {
    public static ArrayList<Student> mylist = new ArrayList();
    Context context;
    public StudentDAOFileImpl(Context context)
    {
        this.context = context;
    }
    public void add(Student s)
    {
        mylist.add(s);
    }
    public void saveFile()
    {
        File f = new File(context.getFilesDir(), "mydata.txt");

    }
    public void printOut()
    {
        for (Student t : mylist)
        {
            Log.d("DATA", t.toString());
        }
    }
    public ArrayList<Student> getList()
    {
        return mylist;
    }
}
