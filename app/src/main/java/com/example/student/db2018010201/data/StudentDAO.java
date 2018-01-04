package com.example.student.db2018010201.data;

import java.util.ArrayList;

/**
 * Created by student on 2018/1/4.
 */

public interface StudentDAO {
    public boolean add(Student s);
    public ArrayList<Student> getList();
    public void printOut();
    public Student getStudent(int id);
    public boolean delete(int id);
    public void update(Student s);
}
