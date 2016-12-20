/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchtask;

/**
 *
 * @author Grace
 */

import java.util.Random;

public class SearchTask {
    
    private static int [] n_size = {2,10,100,1000,2000,3000,10000,100000};
    private static int [] m_val= {2,10,100,1000,2000,10000,100000,1000000};
    
    static long startTime;
    
    static long endTime;
    
    double avgRunTime;


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int r= 10000;
        
        startTime = System.currentTimeMillis();
        
        for(int i=0; i<r;i++){
        
            for(int j=0;j<n_size.length;j++){
                int[] theRArray= creatArr(n_size[j]);
                
                int value=genRval(m_val[j]);
                theRArray =PopulateArr(theRArray,m_val[j]);
               // System.out.println("Random variable = "+value);
                
                SearchForValue(theRArray, value);
            }
        }
        
        endTime = System.currentTimeMillis();
        System.out.println("Running Time = "+ (endTime - startTime)+"Milliseconds");
        System.out.println("Avaerage Running Time = "+ (endTime - startTime)/10000 +"Milliseconds");
        
    }
    
    
    public static int[] creatArr(int n_size) {
        int[] theRArray=new int[n_size-1];
        return theRArray;
    }
    
    public static int genRval(int m_val){
        Random rand = new Random();
        return rand.nextInt(m_val);
    }
          
    public static int[] PopulateArr(int[] theRArray, int m_val){
        for (int i=0; i<theRArray.length; i++){
            Random rand = new Random();
            theRArray[i]=rand.nextInt(m_val);
        }
        return theRArray;
    }
        
    
    public static int SearchForValue(int[] theRArray, int value) {
        for (int i = 0; i < theRArray.length; i++) {
            if (theRArray[i] == value) {
                 //System.out.println("Value: " + value +" Matches Array: " + theRArray[i]);    
            }
            else{ 
            // else code....
            }

        }
        return value; 
        
       }

    /**
     *
     * @param n
     */



    
}
