package task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final DecimalFormat df = new DecimalFormat("0.0000");

    public static void main(String[] args) throws IOException, FileNotFoundException {

        // getting the file path and convert them to file

        Path textFilePath = Paths.get(args[0]);

        File textFile = textFilePath.toFile();

        if (!textFile.exists()) {
            System.out.println("File doesn't exist");
        }

        Scanner input = new Scanner(textFile);

        int totalCounter = 0;

        HashMap<String, Double> termFreq = new HashMap<String, Double>();

        while (input.hasNext()) {
            String word = input.next();
            word = word.trim().toLowerCase();

            // removing all punctuation marks from words
            String newWord = word.replaceAll("\\p{Punct}", "");

            // counting all the words count
            totalCounter += 1.0;

            // adding the words to hashmap
            if (termFreq.containsKey(newWord)) {
                double wordCount = termFreq.get(newWord);
                wordCount += 1.0;
                termFreq.put(newWord, wordCount);

            } else {
                termFreq.put(newWord, 1.0);
            }
        }

        System.out.println(totalCounter);

        Map<String, Double> sortedFreq = sortByValue(termFreq);

        System.out.printf("Total words count: %d\n", totalCounter);

        // print the top 10 words in the sorted hashmap
        int count = 0;
        for (Map.Entry<String, Double> en : sortedFreq.entrySet()) {
            if (count == 10) {
                break;
            }
            System.out.println("Word = " + en.getKey() +
                    ", Frequency = " + df.format(en.getValue() / totalCounter));
            count += 1;
        }
    }

    // function to sort hashmap by values
    public static HashMap<String, Double> sortByValue(HashMap<String, Double> hash) {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Double>> list = new LinkedList<Map.Entry<String, Double>>(hash.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
            public int compare(Map.Entry<String, Double> o1,
                    Map.Entry<String, Double> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<String, Double> temp = new LinkedHashMap<String, Double>();
        for (Map.Entry<String, Double> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}
