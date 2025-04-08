package com.bridgelabz.interProblems;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class SortColumn {
    public static void main(String[] args) {

        List<String[]> arr = new ArrayList<>();
        try{
            CSVReader reader = new CSVReader(new FileReader("employees.csv"));
            String[] header = reader.readNext();
            String[] line;

            while((line = reader.readNext()) != null){
//                System.out.println(Arrays.toString(line));
                arr.add(line);
            }

//            for(String[] row : arr){
//                System.out.println(Arrays.toString(row));
//            }
            arr.sort((a,b) -> Integer.parseInt(b[3].trim()) - Integer.parseInt(a[3]));
//            for(String[] row : arr){
//                System.out.println(Arrays.toString(row));
//            }
            System.out.println(header[0] + ", " + header[1] + ", " + header[2] + ", " + header[3]);
            for(int i=0; i<Math.min(5, arr.size()); i++){
                String[] tempEmp = arr.get(i);
                System.out.println(tempEmp[0] + ", " + tempEmp[1] + ", " + tempEmp[2]+ ", " + tempEmp[3]);
            }
        }
        catch(IOException | CsvValidationException e){
            e.printStackTrace();
        }
    }
}
