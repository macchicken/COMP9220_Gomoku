package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import Common.Constants;
import model.Board;
import model.Coordinate;

public class GomokuPlay implements IPlay {

	private char play1;
	private char play2;
	private char playCurrent;
	private Board board;
	private InputStreamReader isr;
	private BufferedReader br;
	private CheckRule check;
	private int count;
	
	public GomokuPlay(char play1, char play2,int lenX,int lenY,CheckRule check) {
		super();
		this.play1 = play1;
		this.play2 = play2;
		this.playCurrent=play1;
		this.isr = new InputStreamReader(System.in);
		this.br = new BufferedReader(isr);
		this.board=new Board(lenX,lenY);
		this.count=0;
		this.check=check;
	}

	
	@Override
	public void play() {
		this.board.disPlayBoard();
		inputCoordinate();
	}
	
	private void inputCoordinate(){
		String input=null;
		String player=Constants.getDiskName(this.playCurrent);
		System.out.println(Constants.getDiskName(this.playCurrent)+"'s turn: Where do you wish to place your disc?\nPlease type x and y locations :");
		try {
			while ((input=this.br.readLine())!=null){
				input=input.trim();
				if ("".equals(input)){continue;}
				if (!Constants.numPair.matcher(input).matches()){
					System.out.println("type a location in a format of x,y");
					continue;
				}
				String[] location=input.split(",");
				Coordinate coordinate=new Coordinate(Integer.parseInt(location[0].trim()),Integer.parseInt(location[1].trim()));
				boolean placed=this.board.setBoard(coordinate, this.playCurrent);
				if (!placed){continue;}
				this.count++;
				System.out.println("You have placed "+ player+" disc at "+coordinate);
				break;
			}
		} catch (IOException e) {
			System.out.println("ioe"+e.getMessage());
			e.printStackTrace();
		}
	}

	private void switchPlayer(){
		if (this.playCurrent==this.play1){this.playCurrent=this.play2;}
		else{this.playCurrent=this.play1;}
	}

	public boolean check(){
		HashMap<String,Object> checkObjs=new HashMap<String,Object>();
		checkObjs.put("currentPlayer", this.playCurrent);
		checkObjs.put("matrix", this.board.getMatrix());
		checkObjs.put("count", count);
		boolean result=this.check.check(checkObjs);
		if (!result){switchPlayer();return true;}
		return false;
	}

	@Override
	public void end() {
		try {
			this.br.close();this.isr.close();
			System.out.println(this.check.getCheckResult());
			this.board.disPlayBoard();
		} catch (IOException e) {
			System.out.println("ioe "+e.getMessage());
		}
	}

}
