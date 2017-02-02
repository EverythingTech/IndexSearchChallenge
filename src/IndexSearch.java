/**
 * Created by everythingtech on 2017-01-31.
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IndexSearch {

    public static void main(String[] args) {
        List<String> numList = new ArrayList<String>();
        int[] arr = null;
        String singleLine = "";
        File input = new File("input.txt");
        System.out.println(input.getAbsolutePath());
        int size = 0;

        //load file into arraylist
        try {
            BufferedReader reader = new BufferedReader(new FileReader(input.getAbsolutePath()));
            while((singleLine = reader.readLine()) != null){
                numList.add(singleLine);
            }
        } catch (Exception e) {
            System.out.println("No such file.");
        }



        try {

            //load arraylist into int array
            size = Integer.parseInt(numList.get(0));  // assigns the size of the data
            arr = new int[size];

            for (int i = 1; i < numList.size(); i++) {
                arr[i] = Integer.parseInt(numList.get(i));
            }
        } catch (Exception e){
            System.out.println("File contains non-numeric values.");
        }

        Arrays.sort(arr); // sorts the array

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}

