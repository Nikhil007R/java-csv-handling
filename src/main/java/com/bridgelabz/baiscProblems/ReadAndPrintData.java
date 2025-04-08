package com.bridgelabz.baiscProblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadAndPrintData {
    public static void main(String[] args) {

        String studentDetails = "Student.csv";

        try(BufferedReader bf = new BufferedReader(new FileReader(studentDetails))){
            String line;

            while((line = bf.readLine()) != null){
                String[] col = line.split(",");
                System.out.printf("%-10s %-15s %-10s %-10s%n", col[0], col[1], col[2], col[3]);
//              System.out.printf(col[0] + "%s-10" + col[1] + " " + col[2] + " " + col[3]);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
