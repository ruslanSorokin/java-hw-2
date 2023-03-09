package com.example;

import java.io.IOException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Parser p;

        String inPath;
        String outPath;

        if (args.length == 0) {
            Scanner s = new Scanner(System.in);

            System.out.println("Enter filename to parse date from");
            inPath = s.nextLine();

            System.out.println("Enter filename to store data to");
            outPath = s.nextLine();

            s.close();
        } else if (args.length == 2) {
            inPath = args[0];
            outPath = args[1];
        } else {
            System.out.println("Wrong amount of arguments. Requeired 2 strings: inPath outPath");
            return;
        }

        p = new Parser(inPath, outPath);

        try {
            p.parse();
        } catch (IOException e) {
            System.out.println("Error while parsing:");
            e.printStackTrace();
            return;
        }

        try {
            p.store();
        } catch (IOException e) {
            System.out.println("Error while storing:");
            e.printStackTrace();
            return;
        }

    }
}
