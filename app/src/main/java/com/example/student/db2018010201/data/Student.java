package com.example.student.db2018010201.data;

/**
 * Created by student on 2018/1/2.
 */

public class Student {
    public int id;
    public String name;
    public int score;
    public Student(int id, String name, int score)
    {
        this.id = id;
        this.name = name;
        this.score = score;
    }
    public String toString()
    {
        return id + "," + name + "," + score;
    }
}
