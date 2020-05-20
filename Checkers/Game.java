package Checkers;

import java.util.ArrayList;
import java.util.List;

public class Game {
	Tile[][] tile;
	Player player1, player2, turn;
	List<Move> moves = new ArrayList<Move>();
	
	public Game() {
		this.player1 = this.player2 = null;
		
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++) {
				this.tile[i][j] = new Tile(i, j);
			}
		}
	}

	public void AddPlayer(Player newPlayer) {
		if(this.player1 == null) {
			this.player1 = newPlayer;
			player1.setColour(java.awt.Color.RED);
			this.player1.setDirection(1);
		} else if (this.player2 == null) {
			this.player2 = newPlayer;
			this.player2.setColour(java.awt.Color.BLACK);
			this.player2.setDirection(-1);
		} 
	}
	
	protected boolean endGame() { 
		if((player1.getNumPieces() | player2.getNumPieces()) == 0) {
			return true;
		}
		return false;
	}
	
	public Tile getTile(int row, int col) { 
		return tile[col][row];
	}
	protected void exectuteMove(Move move) {
		Piece capturedPiece;
		
		this.player1.executeMove(move);
		this.player2.executeMove(move);
		
		// Update the board
		move.dest.setOccupant(move.start.getOccupant());
		move.dest.setOccupant(null);
		
		if(move.capture) {
			//Captured, removed and updates players list
			capturedPiece = tile[(move.dest.col + move.start.col)/2][(move.dest.row + move.start.row)/2].getOccupant();
			capturedPiece.getPlayer().removePiece(capturedPiece);
		}
		// If kinged
		if(((move.dest.row == 7) & (move.dest.getOccupant().direction == 1))
			|((move.dest.row == 0) & (move.dest.getOccupant().direction == -1))){
			move.dest.getOccupant().king();
		}
		// Update the list of moves 
		this.moves.add(move);		
	}
	/*
	 * Is a legal move if: 
	 * a) The initial tile has a piece to move
	 * b) the piece being moved is the player whose turn it is
	 * c) the destination tile is not out of bounds
	 * d) There is not a current piece on the tile
	 * e) If wanting to jump, there must be a piece in between
	 */
	protected boolean isLegalMove(Move move) {
		//a)
		if(!move.start.isOccupied()) {
			return false;
		}
		//b)
		if(move.start.getOccupant().getPlayer() != turn) {
			return false;
		}
		//c)
		if((0 > move.dest.col | move.dest.col >= 8)
		  |(0 > move.dest.row | move.dest.row >= 8)){
			return false;
		}
		//d)
		if(move.dest.isOccupied()) {
			return false;
		}
		//e)
		if((move.capture) & (!tile[(move.dest.col + move.start.col)/2][(move.dest.row + move.start.row)/2].isOccupied())) {
			return false;
		}
		
		return true;
	}
	
	protected void play() {
		while(!this.endGame()) {
			Move selectedMove;
			
			//Temp values must change to Tile select 
			do{
				selectedMove = turn.chooseMove(new Move(tile[1][2], tile[3][4]));
			}while (!this.isLegalMove(selectedMove));
			
			this.exectuteMove(selectedMove);
			this.switchTurns();
		}
	}
	protected void startGame() {
		//Set all spaces to empty
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++) {
				tile[i][j].setOccupant(null);
			}
		}
		boolean blackTile = false;
		//Set red side (upper)
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 8; j++) {
				if(blackTile) {
					player1.addPiece(tile[i][j]);
					tile[i][j].setOccupant(player1.getPieces()[player1.getNumPieces()]);
				}
			}
		}
		
		blackTile = true;
		//Set black side (upper)
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 8; j++) {
				if(blackTile) {
					player2.addPiece(tile[i][j]);
					tile[i][j].setOccupant(player2.getPieces()[player2.getNumPieces()]);
				}
			}
		}
		
		// start the game
		this.play();		
	}
	
	protected void switchTurns() {
		if(this.turn == player1) {
			this.turn = player2;
		} else {
			this.turn = player1;
		}
	}
	
}
