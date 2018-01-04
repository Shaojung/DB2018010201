package com.example.student.db2018010201;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.student.db2018010201.data.Student;

public class DetailActivity extends AppCompatActivity {
    TextView tv, tv2, tv3;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        tv = (TextView) findViewById(R.id.textView);
        tv2 = (TextView) findViewById(R.id.textView2);
        tv3 = (TextView) findViewById(R.id.textView3);

        Intent it = getIntent();
        id = it.getIntExtra("id", 0);
        Student s = MainActivity.dao.getStudent(id);
        tv.setText(String.valueOf(s.id));
        tv2.setText(s.name);
        tv3.setText(String.valueOf(s.score));
    }
    public void clickDelete(View v)
    {
        MainActivity.dao.delete(id);
        finish();
    }
    public void clickEdit(View v)
    {
        Intent it = new Intent(DetailActivity.this, EditActivity.class);
        it.putExtra("id", id);
        startActivity(it);

    }

}
