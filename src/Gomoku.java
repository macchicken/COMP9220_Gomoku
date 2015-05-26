import service.GomokuPlay;
import service.GomokuPlayCheck;
import service.IPlay;
import Common.Constants;


public class Gomoku {

	private IPlay play;
	
	public Gomoku(IPlay play) {
		this.play=play;
	}

	private void start(){
		boolean nottheEnd=true;
		while(nottheEnd){
			this.play.play();
			nottheEnd=this.play.check();
		}
		this.play.end();
	}

	public static void main(String[] args) {
		Gomoku gomoku = new Gomoku(new GomokuPlay(Constants.black,
				Constants.white, 15, 15, new GomokuPlayCheck(64),10));
		gomoku.start();
	}


}
