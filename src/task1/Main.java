package task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, FileNotFoundException {

        // getting the file path and convert them to file

        Path textFilePath = Paths.get(args[0]);
        // System.out.println(textFilePath);

        File textFile = textFilePath.toFile();
        // System.out.println(textFile);

        if (!textFile.exists()) {
            System.out.println("File doesn't exist");
        }

        Scanner input = new Scanner(textFile);

        int totalCounter = 0;

        while (input.hasNext()) {
            String word = input.next();

            // removing all punctuation marks from words
            String newWord = word.replaceAll("\\p{Punct}", "");
            System.out.println(newWord);

            //counting all the characters count
            totalCounter += 1;



        }

    }
}
