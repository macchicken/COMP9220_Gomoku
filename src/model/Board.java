package model;

import Common.Constants;

public class Board {

	private char[][] matrix;
	
	public Board(int lenX,int lenY){
		this.matrix=new char[lenX][lenY];
		for (int x=0;x<this.matrix.length;x++){
			for (int y=0;y<this.matrix[x].length;y++){
				this.matrix[x][y]=Constants.empty;
			}
		}
	}
	
	public void disPlayBoard(){
		for (int x=0;x<this.matrix.length;x++){
			for (int y=0;y<this.matrix[x].length;y++){
				System.out.print(this.matrix[x][y]);
			}
			System.out.println();
		}
	}
	
	public boolean setBoard(Coordinate coordinate,char z){
		int x=coordinate.getX();
		int y=coordinate.getY();
		if (x>this.matrix.length||y>this.matrix[x-1].length){
			System.out.println(" should place a disk within the board ");
			return false;
		}
		if (this.matrix[x-1][y-1]==Constants.empty){this.matrix[x-1][y-1]=z;return true;}
		else{
			System.out.println(" this place has been occupied,try again ");
			return false;
		}
	}

	public char[][] getMatrix() {
		return matrix;
	}
	
}
