//1122. Relative Sort Array
//https://leetcode.com/problems/relative-sort-array/
//https://www.youtube.com/watch?v=Q0tVjuML7HM


//TC:O(N)   SC:O(N)  N-> size of the 1st array

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] ans=new int[arr1.length];
        //TreeMap is sorted Map
        TreeMap<Integer,Integer> map=new TreeMap<>();
        
        for(int num:arr1){
            //default count would be 0+1 else exixting count+1 
            map.put(num,map.getOrDefault(num,0)+1);             
        }
        
        int index=0;
        //check and add elements in array2 to the ans array
        for(int num:arr2){
            while(map.get(num)!=0){
                ans[index++]=num;
                map.put(num,map.get(num)-1);
            }
        }
        
        //check if there are elements in the map left then add them to the ans array
        while(map.size()>0){
            int key=map.firstKey(); //extracting 1st key of the current map
            int freq=map.remove(key); //extracting value for the current key
            
            for(int i=0;i<freq;i++) //adding elemenet to ans freq times
                ans[index++]=key;
        }
        
        return ans;
    }
}
