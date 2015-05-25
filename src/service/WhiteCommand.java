package service;

import model.Board;
import model.Coordinate;

public class WhiteCommand extends Command {


	private GomokuPlay gu;
	private static int x;
	private static int y;
	private static int a;
	private static int b;
	public Board board;
 
	private static Coordinate coor1=new Coordinate(x,y);
	private static Coordinate coor2=new Coordinate(a,b);
  
	public WhiteCommand() {
		super(coor1, coor2);
	}

	@Override
	void execute() {
		gu.play();
	}

	@Override
	void undo() {

	}

	@Override
	void redo() {

	}

}
