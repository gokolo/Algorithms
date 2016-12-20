/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minsort;

import java.util.Random;

/**
 *
 * @author Keevah
 */
public class MinSort {
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
               MinSort testAlgo2 = new MinSort(n[i]);
		//System.out.println("n is: "+n[i]);
                for(int j=0;j<m.length;j++){
                    startTime = System.nanoTime();
                        for (int x = 0; x < r; x++) {
                            testAlgo2.generateRandomArray(m[j]);
                            testAlgo2.selectionSort();
                        }
                    endTime = System.nanoTime();
                    System.out.println("AVG RUN TIME " + (endTime - startTime)/r);
                }
            }
        
    }
    
    public void selectionSort() {
      int i, j, k, tmp;
      int n = theArray.length;
      for (i = 0; i < n - 1; i++) {
            k = i;
            for (j = i + 1; j < n; j++)
                  if (theArray[j] < theArray[k])
                        k = j;
            if (k != i) {
                  tmp = theArray[i];
                  theArray[i] = theArray[k];
                  theArray[k] = tmp;
            }
      }
     
    }
       
    MinSort(int size) {

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
