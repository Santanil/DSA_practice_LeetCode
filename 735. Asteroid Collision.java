https://leetcode.com/problems/asteroid-collision/description/
https://www.youtube.com/watch?v=6GGTBM7mwfs&t=320s

//TC: O(N)
//SC: O(N)
class Solution {
    public static void rev(int[] arr){
        int s=0,e=arr.length-1;
        while(s<e){
            int temp=arr[s];
            arr[s]=arr[e];
            arr[e]=temp;
            s++;
            e--;
        }
    }
    public static char checkSign(int num){
        if(num<0)
            return 'n';
        return 'p';
    }
    public int[] asteroidCollision(int[] asteroid) {
        Stack<Integer> stk=new Stack<>();
        int n=asteroid.length;
        for(int i=0;i<n;i++){
            if(stk.isEmpty() && checkSign(asteroid[i])=='n')
                stk.add(asteroid[i]);
            else if(stk.isEmpty() || checkSign(stk.peek())==checkSign(asteroid[i]) || checkSign(stk.peek())=='n')
                stk.push(asteroid[i]);
            else{
                while(!stk.isEmpty() && checkSign(stk.peek())!=checkSign(asteroid[i]) && checkSign(stk.peek())=='p'){
                    if(Math.abs(asteroid[i])==Math.abs(stk.peek()))
                        break;
                    if(Math.abs(asteroid[i])<Math.abs(stk.peek()))
                        asteroid[i]=stk.peek();
                    stk.pop();
                }
                if(!stk.isEmpty() && Math.abs(asteroid[i])==Math.abs(stk.peek()) && checkSign(asteroid[i])!=checkSign(stk.peek()) && checkSign(stk.peek())=='p')
                    stk.pop();
                else
                    stk.push(asteroid[i]);
            }
        }
        int x=0;
        int[] res=new int[stk.size()];
        while(!stk.isEmpty()){
            res[x++]=stk.pop();
        }
        rev(res);
        return res;    
    }
}
