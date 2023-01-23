package extractInfo;

import java.io.*;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AverageExecutionTime {
    public static void main(String[] args) {

        String[] tempStart = new String[54090];
        String[] tempComplete = new String[54090];
        int[] tempid = new int[54090];
        int[] jobid = new int[50000];
        int Duration1 = 0;      // less than 1 minute
        int Duration2 = 0;      // 1-30 minutes
        int Duration3 = 0;      // 31-60 minutes
        int Duration4 = 0;      // 1-3 hour

        try {
            Scanner read = new Scanner(new FileInputStream("extracted_log"));
            PrintWriter os = new PrintWriter(new FileOutputStream("Job started and completed"));
            Pattern pattern = Pattern.compile("_start_job");
            Pattern pattern2 = Pattern.compile("_job_complete");
            Pattern pattern3 = Pattern.compile("done");

            String line;
            int i = 0;
            int x = 0;

            while (read.hasNextLine()) {
                line = read.nextLine();
                Pattern jobIdPattern = Pattern.compile("JobId=(\\d+)");
                Matcher matcher = jobIdPattern.matcher(line);

                Matcher match = pattern.matcher(line);
                Matcher match1 = pattern2.matcher(line);
                Matcher match2 = pattern3.matcher(line);

                if (match.find() && matcher.find()) {
                    tempStart[i] = line;

                    String JobId = matcher.group(1);
                    tempid[i] = Integer.parseInt(JobId); // Store the value in the array

                    i++;

                } else if (match1.find() && matcher.find() && match2.find()) {
                    tempComplete[i] = line;

                    String JobId = matcher.group(1);
                    tempid[i] = Integer.parseInt(JobId);

                    for(int j=0; j<i; j++){
                        if(tempid[j] == tempid[i]){
                            jobid[x] = tempid[j];
                            x++;
                            os.println(tempStart[j]);
                            os.println(tempComplete[i]);
                        }
                    }
                    i++;
                }
            }
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        //------------------------------------------------------------------------------
        try {
            Scanner read = new Scanner(new FileInputStream("Job started and completed"));
            DecimalFormat df = new DecimalFormat("#.##");

            String[] temp;

            int i=0;
            int count = 1;
            double sum = 0;
            while(read.hasNextLine()) {
                String start_time = null;
                String end_time = null;

                if (count % 2 != 0) {
                    temp = read.nextLine().split(" ");
                    start_time = temp[0];
                    System.out.println("Start time: " + start_time);
                    count++;

                    temp = read.nextLine().split(" ");
                    end_time = temp[0];
                    System.out.println("End time: " + end_time);

                    count++;
                }

                double executionTime = calculateDifference(start_time, end_time);
                System.out.printf("The execution time for job ID %d is %.2f milliseconds", jobid[i], executionTime);
                System.out.println();

                sum += executionTime;

                convert(executionTime);

                if(executionTime < 60000) {
                    Duration1++;
                } else if (executionTime < 3600000) {
                    Duration2++;
                } else if (executionTime < 86400000) {
                    Duration3++;
                } else if (executionTime >= 86400000) {
                    Duration4++;
                }

                i++;
            }

            double average = sum/(i+1);
            System.out.println("---------------------------------------------------------------------------");

            System.out.printf("The average execution time is %.2f millisecond", average);
            System.out.println();

            int[] averageTime = convert(average);

            System.out.println("The number of job with execution time less than 1 minute \t\t\t:" + Duration1);
            System.out.println("The number of job with execution time between 1 minute to 1 hour \t:" + Duration2);
            System.out.println("The number of job with execution time between 1 to 24 hours \t\t:" + Duration3);
            System.out.println("The number of job with execution time more than 24 hours \t\t\t:" + Duration4);

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    // method to calculate the difference between two given date
    static double calculateDifference(String start, String end) {
        // SimpleDateFormat converts the string format to date object
        SimpleDateFormat sdf = new SimpleDateFormat("'['yyyy-MM-dd'T'HH:mm:ss.SSS']'");

        try {

            // parse method is used to parse the text from a string to produce the date
            Date d1 = sdf.parse(start);
            Date d2 = sdf.parse(end);

            //Calculate time difference in milliseconds
            return d2.getTime() - d1.getTime();
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    static int[] convert(double time) {

        // Calculate time difference in seconds, minutes, hours, years, and days
        long difference_In_Seconds = TimeUnit.MILLISECONDS.toSeconds((long) time) % 60;
        long difference_In_Minutes = TimeUnit.MILLISECONDS.toMinutes((long) time) % 60;
        long difference_In_Hours = TimeUnit.MILLISECONDS.toHours((long) time) % 24;
        long difference_In_Days = TimeUnit.MILLISECONDS.toDays((long) time) % 365;

        // Print the difference in years, in days, in hours, in minutes, and in seconds
        System.out.print("The execution time of the jobs submitted to UMHPC : ");
        System.out.println(difference_In_Days + " days, " + difference_In_Hours + " hours, " + difference_In_Minutes + " minutes, " + difference_In_Seconds + " seconds");
        System.out.println();

        int[] average = new int[4];
        average[0] = (int)difference_In_Days;
        average[1] = (int)difference_In_Hours;
        average[2] = (int)difference_In_Minutes;
        average[3] = (int)difference_In_Seconds;

        return average;
    }
}
