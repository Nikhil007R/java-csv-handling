package com.bridgelabz.baiscProblems.interProblem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterRecords {
    public static void main(String[] args) {

        try(BufferedReader br = new BufferedReader(new FileReader("Student.csv"))){

            String line;
            br.readLine();  // skipping the first line
            while((line = br.readLine()) != null){
                String[] col = line.split(",");
                int num = Integer.parseInt(col[3].trim());
                if(num > 80){
                    System.out.printf("%-10s %-15s %-10s %-10s%n", col[0], col[1], col[2], col[3]);
                }

            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
