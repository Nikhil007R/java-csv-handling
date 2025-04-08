package com.bridgelabz.baiscProblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountRows {

    public static void main(String[] args) {

        try(BufferedReader br = new BufferedReader(new FileReader("Student.csv"))){
            String line;
            int count = 0;
            while((line = br.readLine()) != null){
                count++;
            }
            System.out.println("Number of records are " + --count);
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
}
