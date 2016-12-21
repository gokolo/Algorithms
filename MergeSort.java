/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesort;

/**
 *
 * @author admin
 */
public class MergeSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        final int LENGTH = 45;
        int A[] = new int[LENGTH];
        for (int i = 0; i < LENGTH; i++)
                A[i] = (int) (1 + Math.random() * LENGTH); // range [1..LENGTH]
        System.out.print("original array A: ");
        print(A);
        mergeSort(A);
        System.out.print("sorted array B: ");
        print(A);
    }//End of main method
    
    static void mergeSort(int A[]) {
        if (A.length <= 1){
                return;
        }

        int size1; // size of first & second temp arrays
        int size3; // size of third temp array
        
        if (A.length == 2) {
                size1 = 1;
                size3 = 0;
        }
        else {
                size1 = A.length / 3; // size of first & second temp arrays
                size3 = A.length - 2* size1; // size of third temp array
        } // end if
        
        int temp1[] = new int[size1];
        int temp2[] = new int[size1];
        int temp3[] = new int[size3];
        for (int i = 0; i < size1; i++)
                temp1[i] = A[i];
        for (int i = 0; i < size1; i++)
                temp2[i] = A[size1+i];
        for (int i = 0; i < size3; i++)
                temp3[i] = A[2*size1 + i];

        // sort each of the temporary arrays (recursive step)
        mergeSort(temp1);
        mergeSort(temp2);
        mergeSort(temp3);

        // merge the temp arrays back into the original array
        merge(temp1, temp2, temp3, A);

    } // end mergeSort method
    
    private static void merge(int[] source1, int[] source2, int[] source3, int[] dest) {
		
        int srcElt1 = getElement(source1, 0);
        int srcElt2 = getElement(source2, 0);
        int srcElt3 = getElement(source3, 0);

        int srcIndex1 = 0;
        int srcIndex2 = 0;
        int srcIndex3 = 0;

        int destIndex = 0;

        while (destIndex < dest.length) {
            if (srcElt1 <= srcElt2) {
                    if (srcElt3 <= srcElt1) { 
                            dest[destIndex] = srcElt3;
                            srcIndex3++;
                            srcElt3 = getElement(source3, srcIndex3);					
                    }
                    else { 
                            dest[destIndex] = srcElt1;
                            srcIndex1++;
                            srcElt1 = getElement(source1, srcIndex1);						
                    } 				
            }
            else { 
                    if (srcElt3 <= srcElt2) { 
                            dest[destIndex] = srcElt3;
                            srcIndex3++;
                            srcElt3 = getElement(source3, srcIndex3);					
                    }
                    else { 
                            dest[destIndex] = srcElt2;
                            srcIndex2++;
                            srcElt2 = getElement(source2, srcIndex2);						
                    } 				
            } 
            destIndex++;
        } 

    } // end merge
    
    public static int getElement(int array[], int index) {
		if (index < array.length)
			return array[index];
		else
			return Integer.MAX_VALUE;	
	} // end getElement
    
    static void print(int arr[]) {
            for (int i = 0; i < arr.length; i++) {
                    System.out.print(arr[i] + " ");
            } 
            System.out.println();
    } // end print
    
    
    
}//End of class
