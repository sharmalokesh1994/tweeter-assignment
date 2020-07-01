package com.twitter.Service;

import com.twitter.cache.LFUCache;

public class PrintCacheValueService {
    private static LFUCache lfuCache = LFUCache.getInstance();

    // To print all the values
    public static void printCacheValue(){
    	
    	System.out.println("Top 10 trending tweets");
    	
        lfuCache.getHashTags().forEach((hashTag)->{
            System.out.println(hashTag.getName()+" : "+hashTag.getFreq());
        });
    }

}
