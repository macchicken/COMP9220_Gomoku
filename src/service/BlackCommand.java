package service;

import Common.Constants;
import model.Board;
import model.Coordinate;

public class BlackCommand extends Command {

	public BlackCommand(Coordinate currentC,Coordinate nextC) {
		super(currentC, nextC);
	}

	@Override
	void execute(Board board) {
		board.setBoard(nextC, Constants.black);
	}

	@Override
	void undo(Board board) {
		board.setBoard(nextC, Constants.empty);
	}

}
