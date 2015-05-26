package service;

import model.Board;
import model.Coordinate;

public abstract class Command {

	public Coordinate currentC;
	public Coordinate nextC;
  
	public Command(Coordinate currentC,Coordinate nextC){this.currentC=currentC;this.nextC=nextC;}
	abstract void execute(Board board);
	abstract void undo(Board board);

}
