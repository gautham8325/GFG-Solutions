## Problem: Product of Array Except Self

### **Approach**

The goal of this problem is to calculate the product of all elements in the array except for the element at the current index for each index in the array. This must be done without using division.

We can solve this problem using **two passes**:

1. **Left Product Pass**: In the first pass, calculate the cumulative product of all elements to the left of the current index.
2. **Right Product Pass**: In the second pass, calculate the cumulative product of all elements to the right of the current index and multiply it with the result from the first pass.

### **Steps**

1. **Initialize the `ans` array**:
   - Initialize an array `ans[]` of the same size as the input array `arr[]`.
   - Set `ans[0] = 1` because there are no elements to the left of `arr[0]`.

2. **First Pass (Left Product Calculation)**:
   - Traverse the array from left to right. For each index `i`, calculate `ans[i]` as the product of `ans[i - 1]` (the cumulative product of elements to the left of `arr[i]`) and `arr[i - 1]`.

3. **Second Pass (Right Product Calculation)**:
   - Introduce a variable `rp` (right product) initialized to `1` because there are no elements to the right of `arr[n-1]`.
   - Traverse the array from right to left. For each index `i`, multiply `ans[i]` by the `rp` (the cumulative product of elements to the right of `arr[i]`).
   - Update `rp` by multiplying it with `arr[i]` as we move leftward in the array.

4. **Return the Result**:
   - The `ans[]` array will now contain the product of all elements except the current one for each index in the array.

### **Code**

```java
class Solution {
    public static int[] productExceptSelf(int arr[]) {
        int n = arr.length;
        int[] ans = new int[n];
        
        // Step 1: Initialize ans[0] to 1 as there's no element to the left of arr[0]
        ans[0] = 1;
        
        // Step 2: Compute the left product for each element (product of all elements to the left)
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * arr[i - 1];
        }
        
        // Step 3: Compute the right product and multiply with the current ans[i] value
        int rp = 1; // right product, initialized to 1 because there are no elements to the right of arr[n-1]
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = ans[i] * rp;
            rp = rp * arr[i]; // Update right product for the next index
        }
        
        return ans;
    }
}
```

# Entire Code

```java
//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob = new Solution();
            int[] ans = new int[n];
            ans = ob.productExceptSelf(arr);

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            System.out.println("~");
            t--;
        }
    }
}


class Solution {
    public static int[] productExceptSelf(int arr[]) {
        // code here
        int n= arr.length;
        int [] ans = new int[n];
        /* ### Brute Fore Approach ###
            for(int i=0;i<n;i++){
            int res =1;
            for(int j=0;j<n;j++){
                if(i==j){
                    continue;
                }else{
                    res *= arr[j];
                }
            }
            ans[i] = res;
        } */
        ans[0]=1;
        for(int i=1;i<n;i++){
            ans[i]= ans[i-1] * arr[i-1]; 
        }
        int rp =1;
        for(int i=n-1;i>=0;i--){
            ans[i] = ans[i] *rp;
            rp = rp*arr[i];
        }
        return ans;
    }
}
```
