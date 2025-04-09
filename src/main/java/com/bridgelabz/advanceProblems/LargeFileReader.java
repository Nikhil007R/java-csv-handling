package com.bridgelabz.advanceProblems;

import java.io.*;
import java.util.*;

public class LargeFileReader {

    public static void main(String[] args) {
        String filePath = "largefile.csv"; // Replace with your actual path
        int batchSize = 100;
        int totalCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int batchCount = 0;
            List<String> batch = new ArrayList<>();

            // Skip header if present
            String header = br.readLine();

            while ((line = br.readLine()) != null) {
                batch.add(line);
                batchCount++;

                // Process the batch
                if (batchCount == batchSize) {
                    processBatch(batch, totalCount);
                    totalCount += batchSize;
                    batch.clear();
                    batchCount = 0;
                }
            }

            // Process remaining lines if any
            if (!batch.isEmpty()) {
                processBatch(batch, totalCount);
                totalCount += batch.size();
            }

            System.out.println("Total records processed: " + totalCount);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Dummy processor — you can replace it with your logic
    private static void processBatch(List<String> batch, int offset) {
        System.out.println("Processing records " + (offset + 1) + " to " + (offset + batch.size()));
        // Example: Print first line in this batch
        // System.out.println("→ " + batch.get(0));
    }
}

