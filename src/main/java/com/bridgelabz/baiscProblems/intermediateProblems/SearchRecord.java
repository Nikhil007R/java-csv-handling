package com.bridgelabz.baiscProblems.intermediateProblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchRecord {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee name to search: ");
        String searchName = scanner.nextLine().trim();
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader("employees.csv"))) {
            String line = br.readLine(); // skip header

            while ((line = br.readLine()) != null) {
                String[] col = line.split(",");
                String empName = col[1].trim();

                if (empName.equalsIgnoreCase(searchName)) {
                    String department = col[2].trim();
                    String salary = col[3].trim();
                    System.out.println("Department: " + department);
                    System.out.println("Salary: " + salary);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Employee '" + searchName + "' not found.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
