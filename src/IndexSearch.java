/*
 * Name:        IndexSearch - Challenge Assignment 1
 * Author:      Yifan Lu
 * Date:        Feb 5, 2017
 * Purpose:     Given n positive integer values, k1,k2,k3,...,kn,
 *              finds the smallest number ki that is in the sequence
 *              at least as many times as any other integer in the sequence.
 */

import java.io.*;
import java.util.*;

public class IndexSearch {

    public static void main(String[] args) {

        List<String> numList = new ArrayList<>(); // array list of raw input
        int[] arr;  // integer array for input without length header
        String singleLine; // one line for BufferedReader
        File input = new File("input.txt"); // Input file
        int size = 0; // input length acquired from length header
        Map<Integer, Integer> map = new HashMap<>(); // stores each integer and its occurance in array

        //load file into arraylist
        try {
            BufferedReader reader = new BufferedReader(new FileReader(input.getAbsolutePath()));
            while((singleLine = reader.readLine()) != null){
                numList.add(singleLine);
            } // while
        } catch (Exception e) {
            System.out.println("File does not exit");
            System.exit(0);
        } // try catch

        //load arraylist into int array
        try {
            size = Integer.parseInt(numList.get(0));  // gets the size of the data
        } catch (Exception e){
            System.out.println("File contains non-numeric values.");
            System.exit(0);
        }

        arr = new int[size]; // assigns the size of data

        // loads the integer array with data
        for (int i = 1; i < numList.size(); i++) {
            arr[i-1] = Integer.parseInt(numList.get(i));
        } // for

        Arrays.sort(arr); // sorts the array

        // stores the numbers in hashmap and their corresponding occurances
        for (int i = 0; i < arr.length; i++) {
            map.putIfAbsent(arr[i],1);
            if(i == (arr.length - 1)){
                break;
            } // if
            if(arr[i] == arr[i+1]){
                map.replace(arr[i], map.get(arr[i])+1);
            } // if
        } // if

        System.out.println(occuranceSort(map));

    }

    private static int occuranceSort (Map map){
        // convert the HashMap to two integer arrays with numbers and their occurances

        int[] num = new int[map.size()]; // array of given number; sorted; no duplicates
        int[] occurance = new int[map.size()]; // array of occurances of given number; sorted; no duplicates
        List<Integer> duplicateList = new ArrayList<>(); // the list of numbers with occurance != 1 and occur at least euqal times as others

        int i = 0;
        int key = 0;
        for(Object obj : map.keySet()){
            key = Integer.parseInt(obj.toString());
            num[i] = key;
            occurance[i] = Integer.parseInt(map.get(key).toString());
            i++;
        } // for


        /*for(i = 0; i < num.length; i++){
            System.out.println(num[i] + " " + occurance[i]);
        } // for*/

        for (i=0;i<occurance.length;i++) {
            for (int k = 0; k < occurance.length; k++) {
                if (occurance[k] == occurance[i] && occurance[k] != 1) { // duplicates
                    duplicateList.add(num[i]);
                    break;
                } // if
            } // for
        } // for

        //System.out.println(duplicateList.toString());
        return duplicateList.get(0);
    }


}

