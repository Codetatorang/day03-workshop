package day03_workshop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class ShowCat {
    public static void main(String[]args) throws IOException{
        //read the google playe store csv file
        Path cithPath = Paths.get("./googleplaystore.csv");
        File cith = cithPath.toFile();

        List <String> name = new LinkedList<String>();
        List <String> category = new LinkedList<String>();
        List <String> rating = new LinkedList<String>();
        
        if(!cith.exists()){
            System.err.println("File does not exist!");
            System.exit(1);
        }

        FileReader fr = new FileReader(cith); //read by character
        BufferedReader br = new BufferedReader(fr); 

        String line;

        while(null !=(line = br.readLine())){
            String[] splitline = line.split(",", -1);
            //check for errs in csv files
            if(line.length() <1){
                continue;
            }
        name.add(splitline[0]);
            category.add(splitline[1]);
            rating.add(splitline[2]);
            // System.out.printf("%s",splitline.length);
            System.out.println("\n");
        }

        //close the reader
        br.close();
        fr.close();

    }
}