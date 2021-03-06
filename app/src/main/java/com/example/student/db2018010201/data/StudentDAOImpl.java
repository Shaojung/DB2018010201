package com.example.student.db2018010201.data;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by student on 2018/1/2.
 */

public class StudentDAOImpl implements StudentDAO {
    public static ArrayList<Student> mylist = new ArrayList();
    @Override
    public boolean add(Student s)
    {
        boolean isAdd = true;
        for (Student tmp : mylist)
        {
            if (tmp.id == s.id)
            {
                isAdd = false;
                break;
            }
        }
        if (isAdd)
        {
            mylist.add(s);
        }
        return isAdd;
    }
    public void printOut()
    {
        for (Student t : mylist)
        {
            Log.d("DATA", t.toString());
        }
    }

    @Override
    public ArrayList<Student> getList()
    {
        return mylist;
    }

    @Override
    public Student getStudent(int id) {
        for (Student s : mylist)
        {
            if (s.id == id)
                return s;
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        int i;
        for (i=mylist.size()-1;i>=0;i--)
        {
            if (mylist.get(i).id == id)
            {
                mylist.remove(i);
            }
        }
        return false;
    }

    @Override
    public void update(Student s) {
        for (Student t : mylist)
        {
            if (t.id == s.id)
            {
                t.name = s.name;
                t.score = s.score;
                break;
            }
        }
    }
}
