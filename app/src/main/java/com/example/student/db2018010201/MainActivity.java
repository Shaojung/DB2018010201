package com.example.student.db2018010201;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.student.db2018010201.data.Student;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Student s = new Student();
        s.id = 1;
        s.name = "Bob";
        s.score = 95;
        Log.d("Data", s.id + "," + s.name + "," + s.score);

    }
}
