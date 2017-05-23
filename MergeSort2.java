package Algorithm;

public class MergeSort2 {
    /*
     * 	merge sorted array a and b into c  
     */
    static void mergeArray(int a[], int n, int b[], int m, int c[])  
    {  
        int i, j, k;  
        i = j = k = 0;  
//    	if point of a and b didn't reach the end, then loop
        while (i < n && j < m){	
//			pick up the small one into array c, and move the point of that picked up array and c move to the next
        	c[k++]= a[i]<b[j]?a[i++]:b[j++];	
        }
        /*
         * if array b has been totally picked up, while array a has some items left,
         *  pick up the items in array a into array c one by one 
         */
        while (i < n)  
        	c[k++] = a[i++];  
        /*
         * if array a has been totally picked up, while array b has some items left,
         *  pick up the items in array b into array c one by one 
         */
        while (j < m)  
            c[k++] = b[j++];  
    }  
    
    /*
     * The merge sort algorithm is based on divide and conquer. Means, if there has more than
     *  one items in the array, divide it into two arrays from middle, left and right. Sort the
     *  left and right arrays separately using the method itself. If the left or right array has
     *  more than one items, repeat the operation until there has only one item in the array, then we
     *  thought the array was sorted. When the left and right arrays are both sorted, call mergeArray
     *  method into one sorted array.
     * */
    static void sortArray(int a[],int n,int sorted[]){
    	System.out.println("n="+n);
    	for(int i=0;i<a.length;i++){
    		System.out.print(a[i]+" ");
    	}
    	System.out.println("++++++");
    	int mid = n/2;
    	if(n==1){	//	jump out from the Recursive
    		sorted[0] = a[0];
    		return;
    	}
      	if(n>1){
    		int[] left = new int[mid];
    		int[] right = new int[n-mid];
    		int j = 0;	//	the point of a array
    		for(int i=0;i<left.length;i++){
    			left[i] = a[j++];
    		}
    		for(int i=0;i<right.length;i++){
    			right[i] = a[j++];
    		}
    		int []leftSorted = new int[left.length]; 
    		sortArray(left,left.length,leftSorted);
    		int []rightSorted = new int[right.length];
    		sortArray(right,right.length,rightSorted);
    		mergeArray(left, left.length, right, right.length,sorted);  
    	}
      	System.out.println("after sort");
      	for(int i=0;i<n;i++){
      		System.out.print(sorted[i]+" ");
      	}
    }
    
    public static void main(String[] args) {
        int[] a = new int[]{4,7,10,13,18,3,5,9,11,19,21};
    //    int[] a = new int[]{4};
        int[] sorted = new int[a.length];
        sortArray(a,a.length,sorted);
        for (int i = 0; i < sorted.length; ++i) {
            System.out.print(sorted[i] + "¡¡");
        }
    }

}
