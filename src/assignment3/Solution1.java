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

public class Solution1 {
    
    public static void main(String[] args) {
        
        //openging the data1.csv using the absolute path and assigning the whole information
        // to a singular string named fileName
        String fileName = "/home/anastasia/NetBeansProjects/Assignment3/data1.csv";
        
        // try block has the code to be executed granted there is no error 
        try{
            
            //using the File Reader to read the character files storing it to
            // fileReader which will then be given to the the buffered reader (stored as reader).
            // The buffered reader reads text from the fileReader (character-input stream)
            FileReader fileReader = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(fileReader);
            
            // creation of the hashset to store the customer Id. As per nature of sets,
            // it cannot contain a duplicate, which is what is needed.
            // creation of an arraylist that contains an arraylist of the information
            // fields (gender, age, income).
            HashSet<String> customerID_set = new HashSet<>();
            ArrayList<ArrayList> information_fields = new ArrayList<>();
            
            
            // initilizing the lineCounter to be 0.
            // The string named line will read each line. The end of a line
            // is usually denoted with marker such as \n. The readLine() method
            // looks for the \n to consider it to be end of the line.
            int lineCounter = 0;
            String line = reader.readLine();
            
            
            // the code in this block will be executed for as long as the
            // condition is met
            do{
                
                // checking if the lineCounter is equal to 0, the lineCounter will
                // just be added and it will now equal to 1. The first line of the
                // csv file contains the header, which is the program is written
                // to read the next line in the file and continue 
                if(lineCounter == 0){
                    lineCounter++;
                    line = reader.readLine();
                    continue;
                }
                
                // This string array named split will contain the information
                // split by the delimiter ",". Information will be split
                // in this order [customerid , gender, age, income].
                String[] split = line.split(",");
                
                // adding the unique customer id to the hashset. This is the
                // condition to be checked. Mentioned above, the hashset can only
                // contain unique values, therefore if the program successfully
                // adds the id (denoted by index 0, look at previous explanation)
                // the other fields (gender, age, income) will be added to the
                // arraylist (with string type) named "info". After this has been
                // successfully done, this arraylist will then be added to another
                // arraylist named "information_fields".
                if(customerID_set.add(split[0])){
                    ArrayList<String> info = new ArrayList<>();
                    info.add(split[1]);
                    info.add(split[2]);
                    info.add(split[3]);
                    information_fields.add(info);
                }
                
                // line will now read the next line of the file
                // and as it does so, the lineCounter will be added by 1 to keep
                // track of the number of line
                line = reader.readLine();
                lineCounter++;
            // contains the condition to be met for the code in the do block to be executed
            }while(line != null);
            
            // These are the print statement to show the number of rows in the file (including header)
            // as well as the number of the unique customers in the file. size() method returns
            // the value of the hashset
            System.out.printf("The total number of rows in the file is: %d\n",lineCounter);       
            System.out.printf("The total number of unique customers in the file is: %d\n",customerID_set.size());

            // This is where user is asked if they want information of a specific customer based 
            // on their customer id. To read the input the scanner object is created
            System.out.println("Do you want to know more about a specific customer (Y/N): ");
            Scanner scanner = new Scanner(System.in);
            String searchInput = scanner.nextLine();

            //This part checks if the customer puts in 'Y' regardless of the case
            // that is why we put is as toUpperCase and we are only concerned in the first character
            if(searchInput.toUpperCase().charAt(0)=='Y'){

                // Asks the user to input the ID to be searched 
                // it is then stored to the idInput
                // The iterator (of string type) acts as a pointer to the next one
                System.out.println("Enter the ID: ");
                String idInput = scanner.nextLine();
                Iterator<String> id_it = customerID_set.iterator();

                //the code in this block will be executed for as long as
                // the condition remains true
                do{
                    // String named id will store the information as the iterator
                    // points to the next one
                    String id = id_it.next();
                    // program checks to see if the id and the idInput(obtained from user)
                    // is equal. It returns 0 if true
                    if(id.compareTo(idInput) == 0){
                        // the informations associated with the id is then stored
                        // to id_info arraylist. The information associated can be
                        // retrieved from the information_fields at the index id.
                        // Note that the id needs to be parsed from a string  to integer
                        // for the program to be able to retrieve it correctly
                        // It will then be printed to the output as per formatted in the
                        // proper sequence (ID, gender, age, income)
                        ArrayList<String> id_info = information_fields.get(Integer.parseInt(id));
                        System.out.printf("Customer Id:%s,Gender:%s,Age:%s,Income:%s\n"
                                ,id,id_info.get(0),id_info.get(1),id_info.get(2));
                    }
                // this is the condition that needs to remain true
                }while(id_it.hasNext());
            }
        
            System.out.println(fileName);
        // in the case an error occurs from the try block
        //the catch block code will be executed
        }catch(Exception IOException){
             System.out.println("Input Error Ocurred");
        }    
   }
}
