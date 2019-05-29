//Assignment2_group33
import java.lang.reflect.Array;

//Group 33
//Hassan Mualla & Fredrik Ullman
class Array2{
    private final int max_elements = 200;
    private int size = 0;
    private int[] arr;
    public Array2(int n) {
        if ((n < 0) || (n > max_elements)) {
            throw new IllegalArgumentException("Array size must be non-negative");
        }
        arr = new int[max_elements];
        size = n;
    }
    /**
     *
     *  @return the size of the Array
     */
    public int size() {
        return size;
    }
    /**
     *  Set the i-th element to x We are not checking whether the index is
     in bounds,
     *  because dereferencing the array element does it for us.
     *
     *  @param i the index of the element
     *  @param x the element we're adding
     */
    public void set(int i, int x) {
        arr[i] = x;
    }
    /**
     *  Get the i-th element, Again, we are not checking if the index is in
     bounds.
     *
     *  @param i the index of the element to get
     *  @return the element found
     */
    public int get(int i) {
        return arr[i];
    }
    /**
     *
     *  @return the content of the array as a String
     */
    public String toString() {
        StringBuilder res = new StringBuilder("{");
        if (size > 0) {
            res.append(arr[0]);
            for (int i = 1; i < size; ++i) {
                res.append(", ");
                res.append(arr[i]);
            }
        }
        res.append("}");
        return res.toString();
    }
    /**
     *  Hands on session 1 Exercise 1 - Insert element x at index i assuming
     i is max
     *  the size of the array.
     *
     *  @param i the index where to insert
     *  @param x the element to insert
     */
    public void insert(int i, int x) {
        if( i == this.size){
            set(i,x);
            size++;
        }
        else if ( size != max_elements ) {
            this.shift(i,x);
            size++;
        } else if ( i <= max_elements && i > size){
            throw new IndexOutOfBoundsException("index out of bounds, The array size is " + size() + ", and the index you inserted is " + i);
        }
        else {
            throw new IndexOutOfBoundsException("index out of bounds, make sure number is between 0 and 200");
        }

    }
    /**
     * Follows Hands on session 1 Exercise 1 (not originally in skeleton)
     * shifts all elements in the array with index equal or higher than i 1 index up and inserts x at index i
     *
     * @param i the index indicating shifting point
     * @param x the element to insert at i
     */
    public void shift(int i, int x) {
        for( int m = this.size -1 ; m >= i; m-- ) {
            arr[m+1] = arr[m];
        }
        arr[i] = x;
    }

    /**
     *  Hands on session 1 Exercise 2
     *
     *  @return true if the array is sorted
     */
    public boolean isSorted() {
        for ( int i = 0; i < size -1; i++){
            if ( arr[i] >= arr[i+1]){
                return false;
            }
        }
        return true;
    }
    /**
     *  Hands on session 1 Exercise 3
     *
     *  @return the length of longest increasing sub array
     */
    public int maxNonDecreasing() {
        if (isSorted()) {
            return size;
        }
        int maxLength = 1;
        int currentRecord = 1;
        for (int i = 0; i < size; i ++){
            if (i == size-1 ) {return maxLength;}
            if (arr[i]<=arr[i + 1]) {
                currentRecord++;
            } else {
                if (currentRecord > maxLength) {
                    maxLength = currentRecord;
                }
                currentRecord = 1;
            }
        }
        return maxLength;
    }
    /**
     *  Hands on session 1 Exercise 4 - returns the index of the first
     number in the
     *  first matching subarray
     *
     *  @param b The subarray to compare with
     *  @return the index where the subarray starts
     */
    public int subArrayIndex(Array2 b) {
        int bIndex = -1;
        int consecutiveMatch =0;
        for (int i = 0; i < this.size; i ++){
            if (arr[i] == b.get(0)){
                int k = i;
                for ( int j = 1;  j < b.size; j++){
                    if ( arr[k++] != b.get(j) ){
                        consecutiveMatch = j;
                        j = b.size();
                    }
                }
                if (consecutiveMatch == b.size -1){
                    bIndex = consecutiveMatch;
                    return bIndex;
                }
            }
        }
        return bIndex;
    }
    // Internal method for swapping
    private void swap( int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    /**
     *  Hands on Session 3 Exercise 2 Return the maximum sum of all
     contiguous
     *  subarrays of the array.
     *
     *  @param array the array
     *  @param lo    the index of the low boundary of the subarray
     *  @param hi    the index of the high boundary of the subarray
     *  @return the sum of the subarray
     */
    public static int maxSubarraySum(int[] array, int lo, int hi) {
        throw new UnsupportedOperationException();
    }
    /**
     *  Assignment 1 Question 1 Reverse the array
     */
    public void reverse() {
        for(int i =0;i<size/2;i++){
            swap(i,size-i-1);

        }
        // see if thers is a solution for when you remove the last index and puts it in the first place and so on
    }
    /**
     *  Assignment 1 Question 2 Remove the element of index i from the
     array.
     *
     *  @param i the element to remove
     */
    public void remove(int i) {
        for (int j = i; j < size; j++) {
            arr[j] = arr[j + 1];
        }
        size--;
    }
    /**
     *  Assignment 1 Question 2 Remove the element of index i from the
     array. This
     *  method may change the order of the other elements of the array.
     *
     *  @param i the element to remove
     */
    public void remove2(int i) {
        arr[i]=arr[size-1];
        size--;

    }
    /**
     *  Assignment 1 Question 3 Return the index of the first occurrence of
     x in the
     *  array, or -1 if x does not occur.
     *
     *  @param x the element to find
     *  @return the index of the first occurrence
     */
    public int find(int x){
        for(int i=0;i<size;i++) {
            if (x == arr[i]) {

                return i;
            }
        }

       return -1;
    }
    /**
     *  Assignment 1 Question 4 Find the length of the longest palindrome
     that is a
     *  contiguous subsequence of the array.
     *
     *  @return The length of the palindrome
     */
    //c
    public int maxPalindrome() {
        if (size == 0)
            return 0;
        int palindromeSize = 1;

        for (int i = 0; i < size; i++) {
            if (arr[i] == arr[i + 1]) {
                for (int j = i + 1, k = 0; j < size && k < i+1 && arr[j] == arr[i - k]; j++, k++) {
                    if (palindromeSize < (j - (i - k))+1) {
                        palindromeSize = (j - (i - k))+1;
                    }
                }
            }
            if (arr[i] == arr[i + 2]) {
                for (int j = i + 2, k = 0; j < size && k < i+1 && arr[j] == arr[i - k]; j++, k++) {
                    if (palindromeSize < (j - (i - k)+1)) {
                        palindromeSize = (j - (i - k))+1;
                    }
                }
            }
        }
        return palindromeSize;
    }

    public static int sumThing(int[] a, int left, int right){

        int leftCurrentLength = 0, rightCurrentLength = 0, center = (left + right)/2;

        //check if the length is 0 or 1.
        if (a.length == 0 || a.length == 1){
            return -1;
        }

        //First base Case, one element.
        if (left == right) {
            return a[left];
        }

        //Second base case, two elements ascending
        if (left == right -1 && a[left] < a[right]){
            return a[right] - a[left];
        }

        //Third base case, two elements not ascending
        if (left == right -1 ){
            return 0;
        }

        //Recursive calls
        int maxLeftLength = sumThing(a, left, center);
        int maxRightLength = sumThing(a, center + 1, right);

        //checks that there is a possibility for an ascending sub array between left and right
        if(!(a[center] > a[center + 1])) {

            //from center to left
            for (int i = center; i > left; i--){
                // break the loop if the ascending sub array is not there
                if (a[i] < a[i-1]) {
                    i = left;
                } else {
                    leftCurrentLength = a[i - 1];
                }
            }
            //if there are no matches, return the first checked element
            if(leftCurrentLength == 0) {
                leftCurrentLength = a[center];
            }

            //from center to right
            for (int i = center + 1; i <= right; i++) {
                //checks if there is only one element to the right to avoid index out of bound exception
                if (center == right - 1) {
                    rightCurrentLength = a[i];
                } else {
                    // break the loop if the ascending sub array is not there
                    if (a[i] > a[i + 1]) {
                        i = right;
                    } else {
                        rightCurrentLength = a[i + 1];
                    }
                }
            }
            //if there are no matches, return the first checked element
            if (rightCurrentLength == 0) {
                rightCurrentLength = a[center + 1];
            }

        }

        return Math.max(maxLeftLength, Math.max(maxRightLength, (rightCurrentLength - leftCurrentLength)));

    }

    /**
     *  Assignment 2 Question 3 returns the sum of the largest contiguous
     ascending
     *  array
     *
     *  @return the sum
     */
    public int maxInterval () {
        //check if the size is 1 or 0, if that is the case, return -1 indicating that there is not enough elements
        if(size == 0 || size == 1)
            return -1;
        return sumThing(arr, 0, size-1);
    }
    /**
     *  Assignment 2 Question 3 Return the median value of an array.
     *
     *  @return the median
     */
    public int median () {
        if (size == 0)
            return -1;
        if (size == 1 || size ==2)
            return arr[0];
        return getMedian( arr, 0, size - 1, (size -1) /2);
                //getMedian( 0, arr.length-1);
    }

    private static int getMedian(int[] array, int left, int right, int n) {
        if (left == right) { // If the list contains only one element,
            return array[left]; // return that element
        }

        // select a pivotIndex between left and right
        int PI = left;
        PI = partition(array, left, right, PI);
        // The pivot is in its final sorted position
        if (n == PI) {
            return array[n];
        } else if (n < PI) {
            return getMedian(array, left, PI - 1, n);
        } else {
            return getMedian(array, PI + 1, right, n);
        }
    }

    /**
     *	In quicksort, there is a subprocedure called partition that can, in
     *	linear time, group a list (ranging from indices left to right) into two
     *	parts, those less than a certain element, and those greater than or
     *	equal to the element. Here is pseudocode that performs a partition about
     *	the element list[pivotIndex]
     */
    private static int partition(int[] array, int left, int right, int pivotIndex) {
        int pivotValue = array[pivotIndex];
        swap(array, pivotIndex, right); // move pivot to end
        int storeIndex = left;
        for(int i = left; i < right; i++) {
            if(array[i] < pivotValue) {
                swap(array, storeIndex, i);
                storeIndex++;
            }
        }
        swap(array, right, storeIndex); // Move pivot to its final place
        return storeIndex;
    }

    private static void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }



    public static void main(String[] args){
        Array2 a = new Array2(4);
        a.arr[0] = 14;
        a.arr[1] = 11;
        a.arr[2] = -8;
        a.arr[3] = 10;
//        a.arr[4] = -6;
//        a.arr[5] = 25;
//        a.arr[6] = -4;
//        a.arr[7] = 8;
//        a.arr[8] = 5;
        System.out.println(a.median());
    }

}
