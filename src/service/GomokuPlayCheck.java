package service;

import java.util.HashMap;

import Common.Constants;

public class GomokuPlayCheck extends CheckRule {

	private int maxDisks;
	private char winner;
	
	public GomokuPlayCheck(int maxDisks) {
		super("");
		this.maxDisks = maxDisks;
		this.winner=0;
	}

	@Override
	public boolean check(HashMap<String,Object> checkObjs) {
		char currentPlayer=(Character) checkObjs.get("currentPlayer");
		char[][] matrix=(char[][]) checkObjs.get("matrix");
		int count=((Integer) checkObjs.get("count")).intValue();
		// horizontal
	    for (int x=0;x<matrix.length;x++)
	    {
	        for (int y=0; y < matrix[x].length-4; y++ )
	        {
	            if (currentPlayer == matrix[x][y]
	            	&&currentPlayer == matrix[x][y+1]
	            	&&currentPlayer == matrix[x][y+2]
	            	&&currentPlayer == matrix[x][y+3]
	            	&&currentPlayer == matrix[x][y+4])
	            {
	            	this.winner=currentPlayer;
	            }
	        }
	    }
	    // vertical
	    for (int x=0;x<matrix.length-4;x++){
	    	for (int y=0; y < matrix[x].length; y++ )
	        {
	            if (currentPlayer == matrix[x][y]
	            	&&currentPlayer == matrix[x+1][y]
	            	&&currentPlayer == matrix[x+2][y]
	            	&&currentPlayer == matrix[x+3][y]
	            	&&currentPlayer == matrix[x+4][y])
	            {
	            	this.winner=currentPlayer;
	            }
	        }
	    }
	    // for '\' line
	    for (int x=0;x<matrix.length-4;x++){
	    	for (int y=0; y < matrix[x].length-4; y++ )
	        {
	            if (currentPlayer == matrix[x][y]
	            	&&currentPlayer == matrix[x+1][y+1]
	            	&&currentPlayer == matrix[x+2][y+2]
	            	&&currentPlayer == matrix[x+3][y+3]
	            	&&currentPlayer == matrix[x+4][y+4])
	            {
	            	this.winner=currentPlayer;
	            }
	        }
	    }
	    // '/' line
	    for (int x=0;x<matrix.length-4;x++){
	    	for (int y=4; y < matrix[x].length; y++ )
	    	{
	    		if (currentPlayer == matrix[x][y]
    				&&currentPlayer == matrix[x+1][y-1]
					&&currentPlayer == matrix[x+2][y-2]
					&&currentPlayer == matrix[x+3][y-3]
	    			&&currentPlayer == matrix[x+4][y-4])
	    		{
	    			this.winner=currentPlayer;
	    		}
	    	}
	    }
	    return winOrDraw(count);
	}
	
	private boolean isDraw(int count){
		boolean draw=this.winner==0&&count==this.maxDisks;
		if (draw){this.checkResult="game come to end, draw ";return true;}
		return false;
	}
	
	private boolean winOrDraw(int count){
		if (this.winner!=0){this.checkResult="winner is "+Constants.getDiskName(this.winner);return true;}
		return isDraw(count);
	}
}
