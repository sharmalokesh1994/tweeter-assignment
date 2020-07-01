package com.twitter.dao;

import com.twitter.cache.LFUCache;
import com.twitter.model.HashTag;

import java.util.HashMap;

// it is a Singleton class for saving the Resources
public class ResourceInitializerSingleton {

    private LFUCache lfuCache = LFUCache.getInstance();
    private static ResourceInitializerSingleton instance;
    private HashMap<String, HashTag> hashTags;

    private ResourceInitializerSingleton(){
        hashTags = new HashMap<>();
    }

    // To add the HashTag
    public void addHashTags(String name){

        if(name.trim().equals("")){
            //todo : throw custom exception
            return;
        }

        // here we are adding cache first and then Saving in HashMap
        // we can use use other strategies also
        if(hashTags.containsKey(name)){
            HashTag hashTag = hashTags.get(name);
            lfuCache.updateCache(hashTag);
            hashTags.put(name,hashTag);

        }else {
            HashTag hashTag = new HashTag(name);
            lfuCache.updateCache(hashTag);
            hashTags.put(name,hashTag);
        }
    }


    // for getting instance
    public static ResourceInitializerSingleton getInstance() {
        if (instance == null) {
            synchronized (ResourceInitializerSingleton.class) {
                if (instance == null) {
                    instance = new ResourceInitializerSingleton();
                }
            }
        }
        return instance;
    }

}
