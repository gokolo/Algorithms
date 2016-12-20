/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insertionsort;

import java.util.Random;

/**
 *
 * @author Keevah
 */
public class InsertionSort {
    
    private int[] theArray;
    
    static int r= 2;

    private int arraySize;

    static long startTime;

    static long endTime;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int [] n = {2,10,100,1000,2000,3000,10000,100000};
        int [] m= {2,10,100,1000,2000,10000,100000};
            
        
            for(int i=0; i<n.length;i++){
               InsertionSort testAlgo2 = new InsertionSort(n[i]);
		//System.out.println("n is: "+n[i]);
                for(int j=0;j<m.length;j++){
                    startTime = System.nanoTime();
                        for (int x = 0; x < r; x++) {
                            testAlgo2.generateRandomArray(m[j]);
                            testAlgo2.insertsort();
                        }
                    endTime = System.nanoTime();
                    System.out.println("AVG RUN TIME " + (endTime - startTime)/r);
                }
            }
        
    }
    
    public void insertsort() {
        for(int i=1; i<arraySize; i++){
            int temp = theArray[i];
            for(int j=i; j>0;  j--){
                if(theArray[j-1] > temp){
                    theArray[j]=theArray[j-1];
                }
            }
        }
	
    }
    
        
    InsertionSort(int size) {
        arraySize = size;
	theArray = new int[size];
    }


    public void generateRandomArray(int m) {
        for (int i = 0; i < arraySize; i++) {
            Random rand = new Random();
            theArray[i] = rand.nextInt(m);
        }
    }
    
}
