package com.bridgelabz.advanceProblems;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class MergeTwoCSV {

    public static void main(String[] args) {
        HashMap<String, String[]> hm = new HashMap<>();

        try{
            CSVReader reader = new CSVReader(new FileReader("student1.csv"));
            String[] head1 = reader.readNext();
            String[] line;
            while((line = reader.readNext()) != null){
                hm.put(line[0], line);
            }

            CSVReader reader2 = new CSVReader(new FileReader("student2.csv"));
            String[] head2 = reader2.readNext();
            String[] line2;

            CSVWriter writer = new CSVWriter(new FileWriter("merged.csv"));
            writer.writeNext(new String[]{"id","name", "age", "marks", "grade"});

            while((line2 = reader2.readNext()) != null){
                String id = line2[0];
                if(hm.containsKey(id)){
                    String[] student1 = hm.get(id);
                    String[] merged = new String[]{
                            id,
                            student1[1],
                            student1[2],
                            line2[1],
                            line2[2]
                    };
                    writer.writeNext(merged);
                }
            }
            writer.close();
            System.out.println("Successfully merged ");
        }
        catch (IOException | CsvValidationException e){
            e.printStackTrace();
        }
    }
}
