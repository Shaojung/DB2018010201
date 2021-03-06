package com.example.student.db2018010201.data;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by student on 2018/1/2.
 */

public class StudentDAOFileImpl implements StudentDAO {
    public static ArrayList<Student> mylist = new ArrayList();
    Context context;
    public StudentDAOFileImpl(Context context)
    {
        this.context = context;
        loadFile();
    }
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
            saveFile();
        }
        return isAdd;
    }
    public void loadFile()
    {
        File f = new File(context.getFilesDir(), "mydata.txt");
        FileReader fr = null;
        try {
            fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String str = br.readLine();
            Gson gson = new Gson();
            mylist = gson.fromJson(str, new TypeToken<ArrayList<Student>>(){}.getType());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public void saveFile()
    {
        File f = new File(context.getFilesDir(), "mydata.txt");
        FileWriter fw = null;
        try {
            fw = new FileWriter(f);
            Gson gson = new Gson();
            String str = gson.toJson(mylist);
            fw.write(str);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void printOut()
    {
        for (Student t : mylist)
        {
            Log.d("DATA", t.toString());
        }
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
        saveFile();
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
        saveFile();
    }

    @Override
    public ArrayList<Student> getList()
    {
        return mylist;
    }

}
