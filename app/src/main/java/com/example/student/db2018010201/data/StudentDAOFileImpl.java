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

public class StudentDAOFileImpl {
    public static ArrayList<Student> mylist = new ArrayList();
    Context context;
    public StudentDAOFileImpl(Context context)
    {
        this.context = context;
        loadFile();
    }
    public void add(Student s)
    {
        mylist.add(s);
        saveFile();
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
    public ArrayList<Student> getList()
    {
        return mylist;
    }
}
