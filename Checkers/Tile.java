package Checkers;

public class Tile {
	
	public int col, row;
	private boolean occupied;
	private Piece occupant; 

	public Tile(int col, int row) {
		this.col = col;
		this.row = row;
		this.occupied = false;
		this.occupant = null;
	}

	public Piece getOccupant(){ 
		if(isOccupied()) {
			return occupant;
		} else {
			return null;
		}
	}
	
	public void setOccupant(Piece newOccupant){
		this.occupant = newOccupant;
		this.occupied = true;
	}
	public boolean isOccupied() { 
		return occupied;	
	}
}
