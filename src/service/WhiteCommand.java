package service;

import Common.Constants;
import model.Board;
import model.Coordinate;

public class WhiteCommand extends Command {
 
  
	public WhiteCommand(Coordinate currentC,Coordinate nextC) {
		super(currentC, nextC);
	}

	@Override
	void execute(Board board) {
		board.setBoard(nextC, Constants.white);
	}

	@Override
	void undo(Board board) {
		board.setBoard(nextC, Constants.empty);
	}

	

}
