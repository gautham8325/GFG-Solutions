//{ Driver Code Starts
import java.io.*;
import java.util.*;

class fractionalKnapsack{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            // Read values array
            String[] valueInput = br.readLine().trim().split(" ");
            List<Integer> values = new ArrayList<>();
            for (String s : valueInput) {
                values.add(Integer.parseInt(s));
            }

            // Read weights array
            String[] weightInput = br.readLine().trim().split(" ");
            List<Integer> weights = new ArrayList<>();
            for (String s : weightInput) {
                weights.add(Integer.parseInt(s));
            }

            // Read the knapsack capacity
            int w = Integer.parseInt(br.readLine().trim());

            // Call fractionalKnapsack function and print result
            System.out.println(String.format(
                "%.6f", new Solution().fractionalKnapsack(values, weights, w)));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends

//helper class 
class Item {
        int value;
        int weight;
        double ratio;

        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
            this.ratio = (double) value / weight;
        }
    }
// User function Template for Java
class Solution {
    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        // code here
        List<Item > items =new ArrayList<>();
        for(int i =0;i<val.size();i++){
            items.add(new Item(val.get(i),wt.get(i)));
        }
        items.sort((a, b) -> Double.compare(b.ratio, a.ratio));
        double curr=0;
        double value=0;
        for(Item i : items){
            if(curr + i.weight <=capacity){
                curr+= i.weight;
                value+=i.value;
            }else{
                int remain = capacity-(int)curr ;
                value += i.value*((double)remain/i.weight);
                break;
            }
        }
        return value;
    }
}