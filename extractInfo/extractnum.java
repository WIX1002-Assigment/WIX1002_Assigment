package extractInfo;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class extractnum {
    static ArrayList<Integer> submit = new ArrayList<>();
    static ArrayList<Integer> allocate = new ArrayList<>();
    static ArrayList<Integer> complete = new ArrayList<>();
    static ArrayList<Integer> kill = new ArrayList<>();
    static ArrayList<Integer> timelimit = new ArrayList<>();
    static ArrayList<Integer> error = new ArrayList<>();
    static ArrayList<Integer> exit = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        String [] months = {"2022-06","2022-07","2022-08","2022-09","2022-10","2022-11","2022-12"};

        for(int i=0; i<7; i++) {
            int num = extract("_slurm_rpc_submit_batch_job", months[i]);
            add(submit, i, num);
        }
        System.out.println("Number of Jobs Submitted by Month");
        table(submit);

        for(int i=0; i<7; i++) {
            int num = extract("sched: Allocate", months[i]);
            add(allocate, i, num);
        }
        System.out.println("Number of Jobs Allocated by Month");
        table(allocate);

        for(int i=0; i<7; i++) {
            int num = extract("done", months[i]);
            add(complete, i, num);
        }
        System.out.println("Number of Jobs Completed by Month");
        table(complete);

        for(int i=0; i<7; i++) {
            int num = extract("_slurm_rpc_kill_job", months[i]);
            add(kill, i, num);
        }
        System.out.println("Number of Jobs Killed by Month");
        table(kill);

        for(int i=0; i<7; i++) {
            int num = extract("Time limit exhausted", months[i]);
            add(timelimit, i, num);
        }
        System.out.println("Number of Jobs Exceeded Time Limit by Month");
        table(timelimit);

        for(int i=0; i<7; i++) {
            int num = extract("error", months[i]);
            add(error, i, num);
        }
        System.out.println("Number of Errors by Month");
        table(error);

        for(int i=0; i<7; i++) {
            int num = extract("WEXITSTATUS 0", months[i]);
            add(exit, i, num);
        }
        System.out.println("Number of Jobs Completed with Exit Status 0");
        table(exit);
    }

    public static void add(ArrayList<Integer> array, int i, int count) {
        array.add(i,count);
    }

    public static int extract(String word, String month) throws FileNotFoundException {
        Scanner read = new Scanner(new FileInputStream("extracted_log"));
        int count = 0;
        while (read.hasNextLine()) {
            String line = read.nextLine();
            if (line.contains(word) && line.contains(month))
                count++;
        }
        return count;
    }

    public static void table(ArrayList<Integer> array) {
        String[] month = {"June", "July", "August", "September", "October", "November", "December"};
        System.out.println("+---------------+---------------+");
        System.out.printf("|  %-13s|  %-13s|\n", "Month", "Number");
        System.out.println("+---------------+---------------+");
        for (int i = 0; i < 7; i++) {
            System.out.printf("|  %-13s|  %-13s|\n", month[i], array.get(i));
        }
        System.out.println("+---------------+---------------+\n\n");
    }
}