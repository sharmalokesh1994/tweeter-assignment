package com.twitter.Service;

import com.twitter.customeException.FileNotValid;
import com.twitter.dao.ResourceInitializerSingleton;
import com.twitter.utilities.GetHashTagUtility;
import com.twitter.utilities.ReadFileUtility;

import java.util.ArrayList;

public class ReadFileService {

    private static ResourceInitializerSingleton ri = ResourceInitializerSingleton.getInstance();

    public static void readTweets(String fileName) throws FileNotValid {
    	
    	// read file and convert into words
        ArrayList<String> words = ReadFileUtility.readFile(fileName);
        
        // find the HashTags
        ArrayList<String> hashTags = GetHashTagUtility.findTags(words);
        
        // add the HashTags in ResourceInitializer file and LFUcache
        hashTags.forEach(ri::addHashTags);

    }

}
