package com.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Parser {

    private String inPath_;
    private String outPath_;
    private HashMap<Character, Integer> map_;

    public Parser() {
    }

    public Parser(String inPath, String outPath) {
        this.inPath_ = inPath;
        this.outPath_ = outPath;
    }

    public void parse() throws IOException {
        var bReader = new BufferedReader(new FileReader(this.inPath_));

        this.map_ = read(bReader);

        bReader.close();
    }

    public void store() throws IOException {
        var bWriter = new BufferedWriter(new FileWriter(this.outPath_));

        write(this.map_, bWriter);

        bWriter.close();
    }

    public HashMap<Character, Integer> read(BufferedReader bReader) throws IOException {
        var ret = new HashMap<Character, Integer>();

        while (true) {
            var rawInput = bReader.readLine();

            if (rawInput == null) {
                break;
            }

            for (int i = 0; i < rawInput.length(); i++) {
                var character = rawInput.charAt(i);
                ret.put(character, ret.getOrDefault(character, 0) + 1);
            }
        }

        return ret;
    }

    public void write(HashMap<Character, Integer> map, BufferedWriter bWriter) throws IOException {
        for (HashMap.Entry<Character, Integer> pair : map.entrySet()) {
            var key = pair.getKey();

            if (Character.isLetter(key) || Character.isDigit(key)) {
                bWriter.write(pair.toString() + '\n');
            }

        }
    }
}
