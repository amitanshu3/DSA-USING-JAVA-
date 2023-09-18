class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

           // BRUTE FORCE
       int[] ans=new int[nums1.length];

         for(int i=0;i<nums1.length;i++)
         {
             int track1=0;
             int ind=999;
             int track2=0;
             int track3=0;
             for(int j=0;j<nums2.length;j++)
             {
                 if(nums1[i]==nums2[j]&&track2!=1)
                 {
                     track1=1;
                     ind=j;
                     track2=1;

                 }
                 if(track1==1&&j>ind&&nums2[j]>nums1[i])
                 {
                     ans[i]=nums2[j];
                     track3=1;
                     break;
                 }
             }
               if(track3!=1)
                 ans[i]=-1;
         }
         return ans;








          //OPTIMAL USING STACK AND HASHMAP
          int[] ans=new int[nums1.length];
         Stack<Integer> st=new Stack<>();
         HashMap<Integer,Integer> map=new HashMap<>();
         //finding all the next greater element of nums2 array and put it on the map
         for(int i:nums2)
         {
             while(!st.isEmpty()&&i>st.peek())
             {
                 map.put(st.pop(),i);
             }
             st.push(i);

         }

         //now fetching value from hashmap for nums1 array
         int ind=0;
         for(int i:nums1)
         {
           ans[ind++]=map.getOrDefault(i,-1);
         }

         return ans;

    }
}
