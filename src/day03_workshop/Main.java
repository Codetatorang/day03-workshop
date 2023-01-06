package day03_workshop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Main {
    public static void main(String[]args) throws IOException{
        Reader r = new FileReader("./googleplaystore.csv");
        BufferedReader br = new BufferedReader(r);

        //discard the first line
        String input = br.readLine();
        String[] columns;

        while(null != (input = br.readLine())){
            input=input.trim();
            if (input.length() <= 0){
                continue;
            }
            //Split the line by comma
            columns = input.split(",");
            //skip the row if column length is less than 3
            if(columns.length <3){
                continue;
            }

            String name = columns[0];
            String category = columns[1];
            String rating = columns[2];
            
            //if the rating is not a number NaN, discard it
            if(rating.toLowerCase().equals("nan")){
                continue;
            }

            System.out.printf("le category: %s\n",category);
        }

        //close the reader
        r.close();
        br.close();


    }
}
