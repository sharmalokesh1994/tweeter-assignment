package com.twitter.customeException;

public class FileNotValid extends Exception{

	private static final long serialVersionUID = 1L;

	public FileNotValid(String msg){
        super(msg);
    }

}
