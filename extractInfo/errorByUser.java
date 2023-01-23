package extractInfo;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class errorByUser {
    public static void main(String[] args) {
        try {
            Scanner read = new Scanner(new FileInputStream("extracted_log"));
            PrintWriter os = new PrintWriter(new FileOutputStream("User.txt"));
            Pattern pattern = Pattern.compile("(?<=user=')[^']+");

            while (read.hasNextLine()) {
                String line = read.nextLine();
                Matcher match = pattern.matcher(line);

                while (match.find()) {
                    os.println(match.group());
                }
            }
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Scanner read = new Scanner(new FileInputStream("User.txt"));

            LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
            String word;
            int num = 0;

            while (read.hasNext()) {
                num++;
                word = read.next();
                if (map.get(word) == null)
                    map.put(word, 1);
                else
                    map.put(word, map.get(word) + 1);
            }

            map = sortDescending(map);
            System.out.println("+-------------------------+-------------------+");
            System.out.printf("|%-24s | %-18s|\n", "  Users", "Number of Errors");
            System.out.println("+-------------------------+-------------------+");
            map.forEach((keyword, count) -> System.out.printf("|  %-22s | %-18d|\n", keyword, count));
            System.out.println("+-------------------------+-------------------+");
            System.out.println("|  Total number of error caused by user: " + num  +"  |");
            System.out.println("+---------------------------------------------+");
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found!");
        }
    }

    public static LinkedHashMap<String, Integer> sortDescending(LinkedHashMap<String,Integer> dict){

        List<Map.Entry<String, Integer>> userlist = new LinkedList<>(dict.entrySet());
        userlist.sort((map1, map2) -> map2.getValue().compareTo(map1.getValue()));

        LinkedHashMap<String, Integer> newDict = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> map: userlist) { newDict.put(map.getKey(), map.getValue()); }

        return newDict;
    }
}
