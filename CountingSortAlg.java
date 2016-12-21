/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countingsortalg;

import java.util.Random;

/**
 *
 * @author Keevah
 */
public class CountingSortAlg {
    private int[] A;
    
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
               CountingSortAlg testAlgo2 = new CountingSortAlg(n[i]);
		//System.out.println("n is: "+n[i]);
                for(int j=0;j<m.length;j++){
                    startTime = System.nanoTime();
                        for (int x = 0; x < r; x++) {
                            testAlgo2.generateRandomArray(m[j]);
                            testAlgo2.countingsort(m[j]);
                        }
                    endTime = System.nanoTime();
                    System.out.println("AVG RUN TIME " + (endTime - startTime)/r);
                }
            }
    }
    
    public void countingsort(int m) {
        int C[] = new int[m];
                
	for(int i=0; i<arraySize-1; i++)
        {
                    C[A[i]]++;
        }
        
        int i=0;
        int j=0;
        
        while (i<arraySize)
        {
            if(C[j]>=0){
                A[i]=j;
                i++;
                C[j]--;
            }
            else {
                j++;
            }
        }
    }
    
    CountingSortAlg(int size) {
        arraySize = size;
	A = new int[size];
    }


    public void generateRandomArray(int m) {
        for (int i = 0; i < arraySize; i++) {
            Random rand = new Random();
            A[i] = rand.nextInt(m);
        }
    }
    
    
    
}
