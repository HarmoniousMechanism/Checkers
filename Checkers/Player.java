package Checkers;
import java.util.List;
import java.util.ArrayList;

public abstract class Player {
	
	Game game;
	int playerNumber;
	int direction; 
	List<Piece> myList = new ArrayList<Piece>();
	java.awt.Color colour; 
	
	public Player() {
		this.playerNumber = 1;
		this.direction = 1;
	}
	
	public Piece addPiece(Tile initialPosition) { 
		Piece piece = new Piece(this, initialPosition, direction);
		myList.add(piece);
		
		return piece;
	}
	
	public void executeMove(Move move) {}
	public void getGame() {}
	public void setGame(Game game) {
		this.game = game;
	}
	public Piece[] getPieces() { 
		return (Piece[]) myList.toArray();
	}
	public int getNumPieces() { 
		return myList.size();
	}	
	public void removePiece(Piece remove) {
		myList.remove(remove);
	}
	public void setColour(java.awt.Color colour) {
		this.colour = colour;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	public abstract Move chooseMove(Move move);
	public void king(Piece piece) {
		piece.king();
	}
	
}
