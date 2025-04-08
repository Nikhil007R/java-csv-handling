package com.bridgelabz.interProblems;

import java.io.*;

public class ModifyFile {

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("employees.csv"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("updatedEmployees.csv"))) {

            String line = br.readLine(); // Read header
            bw.write(line);
            bw.newLine();

            while ((line = br.readLine()) != null) {
                String[] col = line.split(",");

                int salary = Integer.parseInt(col[3].trim());
                int updatedSalary = (int) (salary * 1.10); // Add 10%

                bw.write(col[0].trim() + "," + col[1].trim() + "," + col[2].trim() + "," + updatedSalary);
                bw.newLine();
            }

            System.out.println("File updated successfully: 'updatedEmployees.csv'");

        } catch (IOException e) {
            System.out.println("An error occurred while processing the file:");
            e.printStackTrace();
        }
    }

}

