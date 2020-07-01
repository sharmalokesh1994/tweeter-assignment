package com.twitter.Service;

import com.twitter.customeException.FileNotValid;
import com.twitter.dao.ResourceInitializerSingleton;
import com.twitter.utilities.GetHashTagUtility;

import java.util.ArrayList;
import java.util.Arrays;

public class ReadConsoleService {

    private static ResourceInitializerSingleton ri = ResourceInitializerSingleton.getInstance();

    public static void readTweets(String tweet) throws FileNotValid {
        ArrayList<String> words = new ArrayList<>(Arrays.asList(tweet.trim().split(" ")));
        ArrayList<String> hashTags = GetHashTagUtility.findTags(words);
        hashTags.forEach(ri::addHashTags);

    }

}
