package com.twitter.utilities;

import com.twitter.customeException.FileNotValid;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ReadFileUtility {

	// read from file and convert it into words
	@SuppressWarnings("resource")
    public static ArrayList<String> readFile(String fileName) throws FileNotValid {
        ArrayList<String> words = new ArrayList<>();

        try{
			BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line="";

            while( (line = br.readLine())!=null ){
                String w[] = line.trim().split(" ");
                words.addAll(Arrays.asList(w) );
            }
        }catch(IOException e1){
            throw new FileNotValid("File not valid");
        }

        return words;
    }

}
