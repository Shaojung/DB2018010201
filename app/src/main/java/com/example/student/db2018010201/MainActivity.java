package com.example.student.db2018010201;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.student.db2018010201.data.Student;
import com.example.student.db2018010201.data.StudentDAO;
import com.example.student.db2018010201.data.StudentDAOFileImpl;
import com.example.student.db2018010201.data.StudentDAOImpl;

import java.util.ArrayList;
import java.util.zip.DeflaterInputStream;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    public static StudentDAO dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dao = new StudentDAOFileImpl(this);
        lv = (ListView) findViewById(R.id.listView);
        Student s1 = new Student(1, "Bob", 95);
        Student s2 = new Student(2, "Mary", 90);
        Student s3 = new Student(3, "Peter", 98);
        dao.add(s1);
        dao.add(s2);
        dao.add(s3);
        dao.printOut();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int id = dao.getList().get(i).id;
                Intent it = new Intent(MainActivity.this, DetailActivity.class);
                it.putExtra("id", id);
                startActivity(it);
            }
        });
    }

    public void refreshData()
    {
        String str[] = new String[dao.getList().size()];
        int i;
        for (i=0;i<dao.getList().size();i++)
        {
            str[i] = dao.getList().get(i).toString();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MainActivity.this, android.R.layout.simple_list_item_1,
                str
        );
        lv.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        AddDialogFragment dialog = new AddDialogFragment();
        dialog.show(getFragmentManager(), "AddDialog");

        return super.onOptionsItemSelected(item);
    }
}
