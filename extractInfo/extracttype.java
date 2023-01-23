package extractInfo;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class extracttype {
    static ArrayList<Integer> Partition = new ArrayList<>();
    static ArrayList<Integer> Cpu = new ArrayList<>();
    static ArrayList<Integer> Gpu = new ArrayList<>();
    static String [] parType = {"epyc", "gpu", "opteron"};
    static String [] cpuNo = {"cpu01", "cpu02", "cpu03","cpu04","cpu05","cpu06","cpu07","cpu08","cpu09",
            "cpu10","cpu11","cpu12","cpu13","cpu14","cpu15"};
    static String[] gpuNo = {"gpu01","gpu02","gpu03","gpu04","gpu05"};

    public static void main(String[] args) throws FileNotFoundException {

        for(int i=0; i<3; i++) {
            int num = extract("sched: Allocate",parType[i]);
            add(Partition, i, num);
        }
        System.out.println("Number of Jobs by Partitions");
        table(Partition, parType, " Partitions");

        for(int i=0; i<15; i++) {
            int num = extract("NodeList",cpuNo[i]);
            add(Cpu, i, num);
        }
        System.out.println("Number of Jobs Allocated to Nodelist (CPU)");
        table(Cpu, cpuNo, " Type of CPU");

        for(int i=0; i<5; i++) {
            int num = extract("NodeList", gpuNo[i]);
            add(Gpu, i, num);
        }
        System.out.println("Number of Jobs Allocated to Nodelist (GPU)");
        table(Gpu, gpuNo, " Type of GPU");
    }

    public static void add(ArrayList<Integer> array, int i, int count) {
        array.add(i,count);
    }

    public static int extract(String word, String word2) throws FileNotFoundException {
        Scanner read = new Scanner(new FileInputStream("extracted_log"));
        int count = 0;
        while (read.hasNextLine()) {
            String line = read.nextLine();
            if (line.contains(word) && line.contains(word2))
                count++;
        }
        return count;
    }

    public static void table(ArrayList<Integer> array, String[]array2, String label) {
        System.out.println("+---------------+---------------+");
        System.out.printf("| %-13s | %-13s|\n",label, "Number of Jobs");
        System.out.println("+---------------+---------------+");
        for (int i = 0; i < array.size(); i++) {
            System.out.printf("|  %-13s|  %-13s|\n", array2[i], array.get(i));
        }
        System.out.println("+---------------+---------------+\n\n");
    }
}
