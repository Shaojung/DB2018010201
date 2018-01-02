package com.example.student.db2018010201;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.student.db2018010201.data.Student;
import com.example.student.db2018010201.data.StudentDAOImpl;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StudentDAOImpl dao = new StudentDAOImpl();
        Student s1 = new Student(1, "Bob", 95);
        Student s2 = new Student(2, "Mary", 90);
        Student s3 = new Student(3, "Peter", 98);
        dao.add(s1);
        dao.add(s2);
        dao.add(s3);
        dao.printOut();
    }
}
