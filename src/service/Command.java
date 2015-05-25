package service;

import java.util.ArrayList;
import java.util.List;

import model.Board;
import model.Coordinate;

public abstract class Command {

	private int row=15;
	private int cos=15;
	private int x;
	private int y;
	private int a;
	private int b;
	public Board board;
	public GomokuPlay gu;
	public Coordinate coor1=new Coordinate(x,y);
	public Coordinate coor2=new Coordinate(a,b);
	List[][] collection=new ArrayList[row][cos];
 
  
  
	public Command(Coordinate coor1,Coordinate coor2){}
	abstract void execute();
	abstract void undo();
	abstract void redo();

}
