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
        
        //opening the data1.csv using the absolute path and assigning the whole information
        //to a singular string named fileName
        String fileName = "/home/anastasia/NetBeansProjects/Assignment3/data2.txt";
        
        // try block has the code to be executed granted there is no error 
        try{
            //using the File Reader to read the character files storing it to
            // fileReader which will then be given to the the buffered reader (stored as reader).
            // The buffered reader reads text from the fileReader (character-input stream)
            FileReader fileReader = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(fileReader);
            
            // initilizing the lineCounter to be 0.
            // The string named line will read each line. The end of a line
            // is usually denoted with marker such as \n. The readLine() method
            // looks for the \n to consider it to be end of the line.
            int lineCounter = 0;
            String line = reader.readLine();
        
            // creating the variables word_length and more_than_4char,
            // initializing it to be 0
            int word_length;
            int more_than_4char = 0;
            
            // creating a hashmap that has a String as the key, and Integer as 
            // the value, then naming the hashmap to be unique_words
            HashMap<String, Integer> unique_words = new HashMap<>();
            
            // the code in this block will be executed for as long as the
            // condition is met
            do{
                //creating string array named words, it holds the line (refer above)
                // and we are making all of it to lower case, then split the line 
                // using the delimiter " " or space
                String[] words = line.toLowerCase().split(" ");
                // entering the for-loop, for each word in words string array
                for(String word: words){
                    //the .length() method returns the total number of 
                    //characters a given String contain
                    word_length = word.length();
                    // now the program checks if the length is more than 4
                    // characters, and that the hashmap unique_words does not
                    // already contain the word, it will then
                    // put the word in the hashmap with the word in the
                    // key and the value to be the counter of the word (number
                    // of appearance of the word in the file)
                    if(word_length >= 4 && !unique_words.containsKey(word)){
                        unique_words.put(word,1);
                    } 
                    // however, if the word is longer than 4 character but it
                    // is already in the hashmap, we then basically increment
                    // the appearance to +1 (the value of the hashmap)
                    else if(word_length >= 4 && unique_words.containsKey(word)) {
                        unique_words.replace(word, unique_words.get(word)+1);
                    }
                }
                // line will now read the next line of the file
                // and as it does so, the lineCounter will be added by 1 to keep
                // track of the number of line
                line = reader.readLine();
                lineCounter++;
            // contains the condition to be met for the code in the do block to be executed
            }while(line!=null);
           
            Collection<Integer> occurenceCounter = unique_words.values();
            for(int x : occurenceCounter){
                more_than_4char = more_than_4char + x;
            }
            
            System.out.printf("The total number of lines in the text file is: %d\n",lineCounter);
            System.out.printf("Total number of characters/words with at least four characters is: %d\n",more_than_4char);
            System.out.printf("Total number of unique words with at least four characters is: %d\n",unique_words.size());
            System.out.printf("The word battery appears %d times.\n",unique_words.get("battery"));
            
        // in the case an error occurs from the try block
        //the catch block code will be executed    
        }catch(Exception IOException){
             System.out.println("Input Error Ocurred");
        }
    }
}
