/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minsearch;

import java.util.Random;

/**
 *
 * @author Keevah
 */
public class MinSearch {
    
    private int[] theArray;
    
    int r= 1000;

    private int arraySize;

    private int itemsInArray = 0;

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
               MinSearch testAlgo2 = new MinSearch(n[i]);
		//System.out.println("n is: "+n[i]);
                for(int j=0;j<m.length;j++){
                    //System.out.println("m is: "+m[j]);
                    testAlgo2.generateRandomArray(m[j]);
                    testAlgo2.getminVal();
                }
            }
    }
    
    
    
    public int getminVal() {
        int i = 0;
        int j=1;
        startTime = System.nanoTime();
        for (int x = 0; x < r; x++) {
            while(j<theArray.length)
            {
                if(theArray[i]>theArray[j])
                {
                    i=j;                
                }
                j++;
            }
        }
        endTime = System.nanoTime();
         //System.out.println(i);
        System.out.println("AVG RUN TIME " + (endTime - startTime)/r);
        return i;
	}
        
        
    MinSearch(int size) {

		arraySize = size;
		theArray = new int[size];

	}


	public void generateRandomArray(int m) {

		for (int i = 0; i < arraySize; i++) {
                    Random rand = new Random();
                    theArray[i] = rand.nextInt(m);
		}

		itemsInArray = arraySize - 1;

	}
    
}
