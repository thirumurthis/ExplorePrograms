package com.practice.algo;

public class OrangeProbs {

	public static void main(String[] args) {
	OrangeProbs prob = new OrangeProbs();
	if(false) {
	int [][] holder1 = {{2,1,1},{1,1,0},{0,1,1}};
	System.out.println(4==prob.orangesRotting(holder1)?"PASSES":"FAILED");
	int [][]holder2 = {{2,1,1},{0,1,1},{1,0,1}};
	System.out.println(-1==prob.orangesRotting(holder2)?"PASSES":"FAILED");
	int [][]holder3 = {{1,2}};
	System.out.println(1==prob.orangesRotting(holder3)?"PASSES":"FAILED");
	int [][]holder4 = {{1},{2}};
	System.out.println(1==prob.orangesRotting(holder4)?"PASSES":"FAILED");
	int [][]holder5 = {{1,1,2,0,2,0}};
	System.out.println(2==prob.orangesRotting(holder5)?"PASSES":"FAILED");
	}

	int [][]holder6 = {{1,2,1,1,2,1,1}};
	System.out.println(2==prob.orangesRotting(holder6)?"PASSES":"FAILED");

	}

    public int orangesRotting(int[][] grid) {
    	print(grid);
    	int counter =0;
    	int noOfOnes=0; 
    	int priviousnoOfOnes =-1;
    	//counter iteration since there is a possibility the cycle 
    	//happens even after complete iteration starting from 0,0
    	for(int cntr=0;cntr<(grid.length+grid[0].length);cntr++) {
    		//assuming the matrix is going to be a square matrix 3x3
    		for(int i=0;i<grid.length;i++) {
    			for(int j=0;j<grid[0].length;j++) {
    				if(grid[i][j]==2) {
    				//	System.out.println(String.format("after grid[%d][%d] = %d",i,j,grid[i][j]));
    					boolean changeRotten=false;
    					//right direction
    					if((j+1)<grid[0].length && grid[i][j+1]!=0 && grid[i][j+1] !=2 ) {
    						changeRotten=true;
    						grid[i][j+1]=2;
    					}
    					//down
    					if((i+1)<grid.length && grid[i+1][j]!=0 && grid[i+1][j]!=2) {
    						changeRotten=true;
    						grid[i+1][j]=2;
    					}

    					//left
    					if((j-1)>=0 && grid[i][j-1]!=0 && grid[i][j-1] !=2 ) {
    					//	System.out.println("before "+grid[i][j-1]+"  "+i+","+(j-1)+" j="+j+" "+grid[i][j]);
    						changeRotten=true;
    						grid[i][j-1]=2;
    						//System.out.println(String.format("after grid[%d][%d] = %d , j-1=%d",i,j,grid[i][j-1],j-1));
    					}
    					//up
    					if((i-1)>=0 && grid[i-1][j]!=0 && grid[i-1][j]!=2) {
    						//System.out.println("before "+grid[i-1][j]+"  "+i+j+(j-1));
    						changeRotten=true;
    						grid[i-1][j]=2;
    						//System.out.println("after "+grid[i-1][j]+"  ");
    					}
    					if(changeRotten) {counter++;
    					System.out.print("counter= "+counter);
    					print(grid);
    					}
    				}
    			}
    		}
    		
    		//count number of 1's, if past 2 iteration the count is same break out of the loop.
    		noOfOnes=0;
    		for(int i=0;i<grid.length;i++) {
    			for(int j=0;j<grid[0].length;j++) {

    				if(grid[i][j]==1) {
    					noOfOnes++;
    				}
    			}
    		}
    	//	System.out.println(noOfOnes+" "+priviousnoOfOnes);
    		//counts number of 1's current and previous, if same breaks the loop.
    		if(priviousnoOfOnes == noOfOnes) {
        		print(grid);
    			break;
    		}
    		if(noOfOnes==0)break;
    		priviousnoOfOnes=noOfOnes;
    	}
    	if(noOfOnes >0) return -1;
 //   	System.out.println(counter);
        return counter;
    }
    
    public void print(int[][] grid) {
    	System.out.println();
    	for(int i=0;i<grid.length;i++) {
    		for(int j=0;j<grid[0].length;j++) {
    			System.out.print(grid[i][j]+"  ");
    		}
    		System.out.println();
    	}
    }
}


/* working solution edge case not working
 class Solution {
    public int orangesRotting(int[][] grid) {
    	//print(grid);
    	int counter =0;
    	//assuming the matrix is going to be a square matrix 3x3
    	for(int i=0;i<grid.length;i++) {
    		for(int j=0;j<grid[0].length;j++) {
    			if(grid[i][j]==2) {
    				boolean changeRotten=false;
    				//right direction
    				if((j+1)<grid[0].length && grid[i][j+1]!=0 && grid[i][j+1] !=2 ) {
    					changeRotten=true;
    					grid[i][j+1]=2;
    				}
    				//down
    				if((i+1)<grid.length && grid[i+1][j]!=0 && grid[i+1][j]!=2) {
    					changeRotten=true;
    					grid[i+1][j]=2;
    				}
    				
    				//left
    				if((j-1)>=0 && grid[i][j-1]!=0 && grid[i][j-1] !=2 ) {
    					changeRotten=true;
    					grid[i][j-1]=2;
    				}
    				//up
    				if((i-1)>=0 && grid[i-1][j]!=0 && grid[i-1][j]!=2) {
    					changeRotten=true;
    					grid[i-1][j]=2;
    				}
    				if(changeRotten)++counter;
    			}
    		}
    	}
    	for(int i=0;i<grid.length;i++) {
    		for(int j=0;j<grid[0].length;j++) {
    		
    			if(grid[i][j]==1) {
    				return -1;
    			}
    		  }
    		}
        return counter;
    }
}
*/
