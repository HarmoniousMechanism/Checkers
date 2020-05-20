package Checkers;


public class Move {
	Game game;
	public Tile start, dest;
	public boolean capture;
	public Move(Tile start, Tile dest) {
		this.start = start;
		this.dest = dest; 
		
		// If capturing:
		if( ((start.col + 2 == dest.col)
			|(start.col - 2 == dest.col))
		    &((start.row + 2 == dest.row)
		    |(start.row - 2 == start.row))) {
			
			capture = true;	
		} else { 
			capture = false; 
		}
	}
}
