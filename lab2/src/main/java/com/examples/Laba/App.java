package com.examples.Laba;

public class App {
    public static void main(String[] args){
        if (args.length != 3) {
            System.err.println("Usage: SortApp <input path flight> <input path airport> <output path>");
            System.exit(-1);
            
        }
    }
}
