package com.twitter.cache;

import com.twitter.constants.ApplicationCons;
import com.twitter.model.HashTag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

// it is a LFUCache to store trending HashTags
public class LFUCache {

    private static LFUCache instance;
    private int size;
    private HashMap<String, HashTag> hashTags;
    // Here I have used treeSet for LFUCache, Priority Queue also can be used
    private TreeSet<HashTag> sortedHashTags;
    private HashSet<String> pastTags;

    private LFUCache(){
        // according to the question
        this.size= ApplicationCons.CACHE_SIZE;
        hashTags = new HashMap<>();
        sortedHashTags = new TreeSet<>();
        pastTags = new HashSet<>();
    }


    public void updateCache(HashTag hashTag){

        if(hashTags.containsKey(hashTag.getName())){
            sortedHashTags.remove(hashTag);
            hashTag.setFreq(hashTag.getFreq()+1);
            hashTag.setTime();
            sortedHashTags.add(hashTag);
            return;
        }
        if(sortedHashTags.size()< size){
            sortedHashTags.add(hashTag);
            hashTags.put(hashTag.getName(),hashTag);
        }else {
            if(pastTags.contains(hashTag.getName())){
                hashTag.setFreq(hashTag.getFreq()+1);
                hashTag.setTime();
            }

            if( sortedHashTags.last().getFreq()<=hashTag.getFreq() ){
                hashTags.remove(sortedHashTags.last().getName());
                sortedHashTags.remove(sortedHashTags.last());
                sortedHashTags.add(hashTag);
                hashTags.put(hashTag.getName(),hashTag);
            }
        }
        pastTags.add(hashTag.getName());
    }


    public static LFUCache getInstance(){
        if(instance==null){
            synchronized (LFUCache.class){
                if(instance==null){
                    instance = new LFUCache();
                }
            }
        }
        return instance;
    }

    // it is for loose coupling, if something change it should not affect other code
    public ArrayList<HashTag> getHashTags() {
        ArrayList<HashTag> list = new ArrayList<>(sortedHashTags);
        return list;
    }

}
