package Checkers;


public class Piece {
	private Player player;
	private Tile tile;
	private int direction;
	private boolean kinged;
	
	public Piece(Player player, Tile tile, int direction) {
		this.player = player;
		this.tile = tile;
		this.direction = direction; // 1 for down, -1 for up 
		this.kinged = false;
	}

	public boolean canCapture(Piece other) {
		if(other.getPlayer() != this.player) {
			return true;
		}
		return false;
	}
	
	public boolean canMoveTo(Tile tile) {
		if(tile.isOccupied()) {
			return false;
		}
		// Check for non king
		// Standard, move on space diagonally
		if( tile.row == (this.tile.row + 1 | this.tile.row - 1) 
			& (this.direction <= tile.col - this.tile.col)) {
			
			return true;
		}
		// Standard, capture and move two spaces diagonally
		// Currently does not account whether there is a piece between 
		else if( tile.row == (this.tile.row + 2 | this.tile.row - 2)
				& (this.direction <= tile.col - this.tile.col)) {
			
			return true;	
		}
		//check for king
		if(isKinged()) {
			if( tile.row == (this.tile.row + 1 | this.tile.row - 1)){
				
				return true;
			}
			// Standard, capture and move two spaces diagonally
			// Currently does not account whether there is a piece between 
			else if( tile.row == (this.tile.row + 2 | this.tile.row - 2)) {
				
				return true;	
			}
		}
		 return false;
	}
	public Player getPlayer() {	
		return this.player;
	}
	public boolean isKinged() {
		return kinged;
	}
	public void king() {
		this.kinged = true;
	}
}

