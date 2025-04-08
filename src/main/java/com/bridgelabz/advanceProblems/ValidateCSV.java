package com.bridgelabz.advanceProblems;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

public class ValidateCSV {

    public static void main(String[] args) {

        Pattern emailPattern = Pattern.compile("^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$");
        Pattern phonePattern = Pattern.compile("^[6-9][0-9]{9}$");

        try{
            CSVReader reader = new CSVReader(new FileReader("employees1.csv"));

            String[] header = reader.readNext();
            String[] line;
            while((line = reader.readNext()) != null){

                if(!emailPattern.matcher(line[2].trim()).matches()){
                    System.out.println("Invalid Email " + line[2]);
                    System.out.println(Arrays.toString(line));
                }
                if(!phonePattern.matcher(line[3].trim()).matches()){
                    System.out.println("Invalid Indian Phone " + line[3]);
                    System.out.println(Arrays.toString(line));
                }

            }
        }

        catch (IOException | CsvValidationException e){
            e.printStackTrace();
        }

    }
}
