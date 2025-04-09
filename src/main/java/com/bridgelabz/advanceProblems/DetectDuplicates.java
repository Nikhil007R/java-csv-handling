package com.bridgelabz.advanceProblems;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DetectDuplicates {

    public static void main(String[] args) {

        Set<String> set = new HashSet<>();  // storing id's
        List<String[]> arr = new ArrayList<>();  // storing duplicates

        try{
            CSVReader reader = new CSVReader(new FileReader("DuplicateStudents.csv"));
            String[] header = reader.readNext();
            String[] line;

            while((line = reader.readNext()) != null){
                if(!set.contains(line[0])){
                    set.add(line[0]);
                }
                else{
                    arr.add(line);
                }
            }

            for(String[] s: arr){
                System.out.println(Arrays.toString(s));
            }

        }
        catch (IOException | CsvValidationException e){
            e.printStackTrace();
        }

    }
}
