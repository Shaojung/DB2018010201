package com.example.student.db2018010201;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.student.db2018010201.data.Student;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Student> mylist = new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Student s1 = new Student(1, "Bob", 95);
        Student s2 = new Student(2, "Mary", 90);
        Student s3 = new Student(3, "Peter", 98);
        mylist.add(s1);
        mylist.add(s2);
        mylist.add(s3);
        for (Student t : mylist)
        {
            Log.d("DATA", t.toString());
        }
    }
}
