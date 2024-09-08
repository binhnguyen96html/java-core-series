package com.example.jdbc.collection;

import java.util.HashMap;
import java.util.Map; // Importing java.util.Map

public class MapMain {  // Changed class name to Main

  public static void main(String[] args){

    Map<String, String> map = new HashMap<>();
    map.put("1", "A");  // Corrected to put()
    map.put("2", "B");

    for(Map.Entry<String, String> entry: map.entrySet()){
      System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
    }

  }
  
}
