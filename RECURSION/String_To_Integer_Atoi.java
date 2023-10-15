//itterative approach

class Solution {
    public int myAtoi(String s) {
    int index = 0;
    int sign = 1;
    int result = 0;
    
    // Remove leading whitespace
    while (index < s.length() && s.charAt(index) == ' ') {
        index++;
    }
    
    // Check for sign
    if (index < s.length() && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
        sign = (s.charAt(index) == '-') ? -1 : 1;
        index++;
    }
    
    // Process digits
    while (index < s.length() && Character.isDigit(s.charAt(index))) {
        int digit = s.charAt(index) - '0';
        
        // Check for overflow
        if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
            return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        
        result = result * 10 + digit;
        index++;
    }
    
    return result * sign;
    }
}


//recursive approach


class Solution {
    public int myAtoi(String s) {
           int ind=0;
           int result=0;
           int index=0;
           int sign=1;
           //remove the leading space
           while(index<s.length()&&s.charAt(index)==' ')
           {
               index++;
           }
           //check sign
    if (index < s.length() && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
        sign = (s.charAt(index) == '-') ? -1 : 1;
        index++;
    }
      int res=0;
   return helper(s,index,res,sign);

    }
    static int helper(String s,int index,int result,int sign)
    {
        if(index>=s.length()||!Character.isDigit(s.charAt(index)))
        {
             return sign==1?result:-1*result;
        }
        int digit=s.charAt(index)-'0';
         // Check for overflow
        if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
            return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        
        result = result * 10 + digit;
        index++;
        return helper(s,index,result,sign);
    }
}
