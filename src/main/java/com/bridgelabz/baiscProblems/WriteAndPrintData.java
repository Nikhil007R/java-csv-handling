package com.bridgelabz.baiscProblems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteAndPrintData {

    public static void main(String[] args) {

        String outputFile = "output.csv";
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("outputFile"))){
            bw.write("ID, Name, Department, Salary");
            System.out.println("Enter how many rows you want to add ?");
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            System.out.println("Write ----- Id, Name, Department, Salary ----- like this");
            for(int i=0; i<n; i++){
                String temp = sc.nextLine();
                bw.write(temp + "\n");
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
