class Solution {
    public int[] nextGreaterElements(int[] nums) {
        //BRUTE FORCE
       /int[] ans=new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            int track=0;
            for(int j=0;j<nums.length;j++)
            {
                if(nums[j]>nums[i]&&i!=j&&track!=1)
                {
                   ans[i]=nums[j];
                   track=1;
                }
                if(nums[j]>nums[i]&&j>i)
                {
                    ans[i]=nums[j];
                    track=1;
                    break;
                }
            }
            if(track!=1)
             ans[i]=-1;
        }
        return ans;



      

        //OPTIMAL SOLUTION

        Stack<Integer> s=new Stack<>();
        int[] nge=new int[nums.length];
        int n=nums.length;
        for(int i=2*n-1;i>=0;i--)
        {
            while(!s.isEmpty()&&nums[i%n]>=s.peek())
            {
                s.pop();
            }
            if(s.isEmpty())
              nge[i%n]=-1;
            else
             nge[i%n]=s.peek();
             
            s.push(nums[i%n]);
        }
        return nge;
    }
}
