package com.bridgelabz.advanceProblems;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Student{

    private int Id;
    private String Name;
    private int Age;
    private int Marks;

    Student(int id, String name,  int age, int marks){
        this.Id = id;
        this.Name = name;
        this.Age = age;
        this.Marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + Id +
                ", name='" + Name + '\'' +
                ", age=" + Age +
                ", marks=" + Marks +
                '}';
    }
}

public class CSVIntoObjects {

    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<>();
        try{
            CSVReader reader = new CSVReader(new FileReader("Student.csv"));

            String[] header = reader.readNext();
            String[] line;

            while((line = reader.readNext()) != null){

                int id = Integer.parseInt(line[0].trim());
                String name = line[1].trim();
                int age = Integer.parseInt(line[2].trim());
                int marks = Integer.parseInt(line[3].trim());

                Student student = new Student(id, name, age, marks);
                studentList.add(student);
            }
        }
        catch(IOException | CsvValidationException e){
            e.printStackTrace();
        }

        for(Student student: studentList){
            System.out.println(student.toString());
        }
    }
}
