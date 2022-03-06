//60. Permutation Sequence
//https://leetcode.com/problems/permutation-sequence/
//https://docs.google.com/spreadsheets/d/1Hk2dxaDNsqrDElQy5NKMWKAdYzjgWrmoFgT-vWRHkC8/edit#gid=0
//https://www.youtube.com/watch?v=wT7gcXLYoao&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=19


//Optimized Code
//TC:O(N^2)
//SC: O(N)  ->for list
class Solution {
    public String getPermutation(int n, int k) {
        String res="";
        List<Integer> list=new ArrayList<>();
        int fact=1;
        for(int i=1;i<n;i++){
            fact=fact*i;
            list.add(i);
        }
        list.add(n);
        k=k-1;
        
        while(true){
            res=res+list.get(k/fact);
            list.remove(k/fact);
            if(list.size()==0)
                break;
            
            k=k%fact;
            fact=fact/list.size();
        }
        return res;
    }
}
