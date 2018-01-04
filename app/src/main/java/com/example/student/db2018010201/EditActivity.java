package com.example.student.db2018010201;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.student.db2018010201.data.Student;

public class EditActivity extends AppCompatActivity {
    TextView tv4;
    EditText ed4, ed6;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        tv4 = (TextView) findViewById(R.id.textView4);
        ed4 = (EditText) findViewById(R.id.editText4);
        ed6 = (EditText) findViewById(R.id.editText6);

        Intent it = getIntent();
        id = it.getIntExtra("id", 0);
        Student s = MainActivity.dao.getStudent(id);
        tv4.setText(String.valueOf(s.id));
        ed4.setText(s.name);
        ed6.setText(String.valueOf(s.score));
    }
}
