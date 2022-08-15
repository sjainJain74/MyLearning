package DP;

public class MultiDimesionAraayPath {
	
	public static void main(String agg[]) {
		
		int [][] input= new int [][] {{0,1},{0,0}};
		System.out.println (uniquePathsWithObstacles(input));
		
	}
	
	//https://leetcode.com/problems/unique-paths-ii/solution/
	
	 public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
	        //MXN matrix
	        return uniquePathsWithObstaclesRec(obstacleGrid,obstacleGrid.length,obstacleGrid[0].length) ;
	    }
	    
	     public static int uniquePathsWithObstaclesRec(int[][] obstacleGrid,int M,int N) {
	         if(M==0 ||N ==0) return 0;
	         if(M==1) {
	             for(int i =0;i<N;i++){
	             if(obstacleGrid[0][i] ==1) return 0;
	         }
	             return 1;
	         }
	         
	         if(N==1) {
	             for(int i =0;i<M;i++){
	             if(obstacleGrid[i][0] ==1) return 0;
	         }
	          return 1;
	         }
	         
	        
	         int pathOne=0;
	         int pathTwo=0;
	         
	         
	         if(obstacleGrid[M-1] [N-2]==0)
	          pathOne = uniquePathsWithObstaclesRec(obstacleGrid,M,N-1);
	        // else pathOne= 0;
	         
	         if(obstacleGrid[M-2] [N-1]==0)
	          pathTwo = uniquePathsWithObstaclesRec(obstacleGrid,M-1,N);
	          //else pathTwo=0;
	             
	         return pathOne+pathTwo;
	         
	    }
	    

}

