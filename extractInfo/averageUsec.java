package extractInfo;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class averageUsec {
    public static void main(String[] args) {
        System.out.println("Total and Average of Time Taken to Submit Job in Microseconds (usec)");
        System.out.println("+---------------+---------------------+---------------------+");
        System.out.printf("| %-13s | %-20s| %-20s|\n","Month", "Total Time(usec)", "Average Time(usec)");
        System.out.println("+---------------+---------------------+---------------------+");
        extractUsec("2022-06");
        extractUsec("2022-07");
        extractUsec("2022-08");
        extractUsec("2022-09");
        extractUsec("2022-10");
        extractUsec("2022-11");
        extractUsec("2022-12");
        System.out.println("+---------------+---------------------+---------------------+");
    }

    public static void extractUsec(String month) {
        int i =0, sum=0;
        try {
            Scanner read = new Scanner(new FileInputStream("extracted_log"));
            int counter=0;
            while (read.hasNextLine()) {
                String line = read.nextLine();
                Pattern pattern = Pattern.compile("usec=(\\d+)");
                Matcher matcher = pattern.matcher(line);
                if(line.contains("_slurm_rpc_submit_batch_job")&&line.contains(month)&&line.contains("usec")){
                    counter++;

                    int[] usecValues = new int[counter]; // Initialize an array to store the values
                    while (matcher.find()) {
                        String usec = matcher.group(1);
                        usecValues[i] = Integer.parseInt(usec); // Store the value in the array
                        i++;
                    }
                    for (int j = 0; j < counter; j++) {
                        sum +=usecValues[j];
                    }
                }}
        } catch (IOException e) {
            System.out.println("Problem with file output");
        }
        System.out.printf("| %-13s | %-20s| %-20s|\n",month, sum, (sum/i));
    }
}
    
    