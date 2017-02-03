/**
 * Created by everythingtech on 2017-01-31.
 */
import java.io.*;
import java.util.*;

public class IndexSearch {

    public static void main(String[] args) {
        List<String> numList = new ArrayList<String>();
        int[] arr = null;
        String singleLine;
        File input = new File("input.txt");
        System.out.println(input.getAbsolutePath());
        int size;
        Map<Integer, Integer> map = new HashMap<>();


        //load file into arraylist
        try {
            BufferedReader reader = new BufferedReader(new FileReader(input.getAbsolutePath()));
            while((singleLine = reader.readLine()) != null){
                numList.add(singleLine);
            }
        } catch (Exception e) {
            System.out.println("No such file.");
        }

        //load arraylist into int array
        try {
            size = Integer.parseInt(numList.get(0));  // assigns the size of the data
            arr = new int[size];

            for (int i = 1; i < numList.size(); i++) {
                arr[i-1] = Integer.parseInt(numList.get(i));

            }
        } catch (Exception e){
            System.out.println("File contains non-numeric values.");
        }

        Arrays.sort(arr); // sorts the array



        for (int i = 0; i < arr.length; i++) {

            map.putIfAbsent(arr[i],1);
            if(i == (arr.length - 1)){
                break;
            }
            if(arr[i] == arr[i+1]){
                map.replace(arr[i], map.get(arr[i])+1);
            }
        }

        System.out.println(map.toString());
    }


}

