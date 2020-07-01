package com.twitter;

import com.twitter.Service.PrintCacheValueService;
import com.twitter.Service.ReadConsoleService;
import com.twitter.Service.ReadFileService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StartApplication {

    public static void main(String[] args) {
        System.out.println("Welcome...");
        
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            try{
                System.out.println("Please Choose option");
                System.out.println("1 for tweets in file format");
                System.out.println("2 for tweet in the console");
                System.out.println("3 for exit");

                int input = Integer.parseInt(br.readLine().trim());
                if(input==1){
                    System.out.println("Please give full file Name");
                    String fileName = br.readLine().trim();
                    ReadFileService.readTweets(fileName);
                }else if( input==2 ){
                    System.out.println("Please give the tweet");
                    String tweet = br.readLine().trim();
                    ReadConsoleService.readTweets(tweet);
                }else if( input==3 ){
                    PrintCacheValueService.printCacheValue();
                    System.out.println("Shutting down...");
                    System.exit(0);
                }else {
                    throw new Exception("Valid input");
                }

            }catch (Exception e){
                //System.out.println(e.getMessage());
                System.out.println("Please give valid input");
            }

        }


    }

}
