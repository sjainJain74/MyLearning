package DP;

public class KnapSackGoogle {
	
	public static void main (String arg[]) {
		int amount = 2;
		int [] coins = new int [] {1,2};
		
				//int result = minIntervalHits(intervals,total_time,intervals.length) ;
				
//				if(result ==Integer.MAX_VALUE) {
//					result =-1;
//				}
//				
//				System.out.println(result);
				
				 
		        int[][]dp = new int [coins.length+1][amount+1];
		        //Filling the DP array
		        for(int i =0;i<=coins.length;i++){
		            for(int j =0;j<=amount;j++){
		                if(i==0 ||j ==0){
		                    dp[i][j]=Integer.MAX_VALUE-1;
		                }
		                else 
		                {
		                    dp[i][j]= -1;
		                }
		            }
		        }  
		        
				
				System.out.println (Solution.minIntervalHits(coins, amount, coins.length, dp));
	}
	
	
	 //
	 public static int minIntervalHits (int [] intervals,int total_time, int n) {
		
		 
		 if(n==1) {
			 if(total_time%intervals[n-1] ==0) {
				 return total_time/intervals[n-1];
			 }
			 else   return Integer.MAX_VALUE-1;
		 }
		 
		 
		 if(intervals[n-1]>total_time) {
			 return minIntervalHits (intervals,total_time,n-1);
		 }
		 
		 else {
			 return Math.min(1+ minIntervalHits (intervals,total_time -intervals[n-1],n),
					 minIntervalHits (intervals,total_time,n-1));
		 }
		
	}
	 
	 
	 static class Solution {
		 
		   
		     public static int minIntervalHits (int [] intervals,int total_time, int n,int[][] dp) {
				 if(n==1) {
					 if(total_time%intervals[n-1] ==0) {
						 return total_time/intervals[n-1];
					 }
					 else   return Integer.MAX_VALUE-1;
				 }
				 
				 if(!(dp[n][total_time]==-1 || dp[n][total_time]==Integer.MAX_VALUE-1 ||  dp[n][total_time]==Integer.MAX_VALUE)){
		             return dp[n][total_time];
		         }
		            
				 if(intervals[n-1]>total_time) {
		                  return dp[n-1][total_time]= minIntervalHits (intervals,total_time,n-1,dp);
				 }
				 
				 
					int minInvTakingCoin =  1+ minIntervalHits (intervals,total_time -intervals[n-1],n,dp);
		            // dp[n][total_time -intervals[n-1]] =minInvTakingCoin;
		         int minInvNotTakingCoin =  minIntervalHits (intervals,total_time,n-1,dp);
		            // dp[n][total_time] =minInvNotTakingCoin;
		              return dp[n][total_time] =Math.min(minInvTakingCoin,minInvNotTakingCoin);
		                 
		                //return  Math.min(1+ minIntervalHits (intervals,total_time -intervals[n-1],n,dp),
							//minIntervalHits (intervals,total_time,n-1,dp));
				 
		         }
		     }
				
			


		    //
			


}
			