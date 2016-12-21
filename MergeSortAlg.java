/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesortalg;

import java.util.Random;

/**
 *
 * @author Keevah
 */
public class MergeSortAlg {
    private int[] array;
    private int[] tempMergArr;
    private int length;
    
    private int[] A;
    
    static int r= 2;
    private int arraySize;
    private int mergearrsize;

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
               MergeSortAlg ms_const = new MergeSortAlg(n[i]);
		//System.out.println("n is: "+n[i]);
                for(int j=0;j<m.length;j++){
                    startTime = System.nanoTime();
                        for (int x = 0; x < r; x++) {
                           ms_const.generateRandomArray(m[j]);
                           ms_const.sort();
                        }
                    endTime = System.nanoTime();
                    System.out.println("AVG RUN TIME " + (endTime - startTime)/r);
                }
            }
    }
    
    
    public void sort() {
        this.array = A;
        this.length = A.length;
        this.tempMergArr = new int[length];
        doMergeSort(0, length - 1);
    }
    
    private void doMergeSort(int lowerIndex, int higherIndex) {
         
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            doMergeSort(lowerIndex, middle);
            // Below step sorts the right side of the array
            doMergeSort(middle + 1, higherIndex);
            // Now merge both sides
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }
    
        private void mergeParts(int lowerIndex, int middle, int higherIndex) {
 
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }
 
    }
        
    MergeSortAlg(int size) {
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
