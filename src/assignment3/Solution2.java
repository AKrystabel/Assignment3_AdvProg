/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment3;

/**
 *
 * @author anastasia
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
        
        String fileName = "/home/anastasia/NetBeansProjects/Assignment3/data2.txt";
        
        
        try{
            FileReader fileReader = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(fileReader);
            
            int lineCounter = 0;
            String line = reader.readLine();
            
            int word_length;
            int more_than_4char = 0;
            
            HashMap<String, Integer> unique_words = new HashMap<>();
            
            do{
                String[] words = line.toLowerCase().split(" ");
                for(String word: words){
                    word_length = word.length();
                    if(word_length >= 4 && !unique_words.containsKey(word)){
                        unique_words.put(word,1);
                    } 
                    else if(word_length >= 4 && unique_words.containsKey(word)) {
                        unique_words.replace(word, unique_words.get(word)+1);
                    }
                }
                line = reader.readLine();
                lineCounter++;
            }while(line!=null);
           
            Collection<Integer> occurenceCounter = unique_words.values();
            for(int x : occurenceCounter){
                more_than_4char = more_than_4char + x;
            }
            
            System.out.printf("The total number of lines in the text file is: %d\n",lineCounter);
            System.out.printf("Total number of characters/words with at least four characters is: %d\n",more_than_4char);
            System.out.printf("Total number of unique words with at least four characters is: %d\n",unique_words.size());
            System.out.printf("The word battery appears %d times.\n",unique_words.get("battery"));
            
            
        }catch(Exception IOException){
             System.out.println("Input Error Ocurred");
        }
    }
}
