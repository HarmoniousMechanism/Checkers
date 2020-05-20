package Checkers;


public class Move {
	Game game;
	public Tile start, dest;
	public Move(Tile start, Tile dest) {
		// If capturing:
		if( ((start.col + 2 == dest.col)
			|(start.col - 2 == dest.col))
		    &((start.row + 2 == dest.row)
		    |(start.row - 2 == start.row))) {
			
			game.tile[dest.col-start.col][dest.row-start.row].setOccupant(null);
		}
		dest.setOccupant(start.getOccupant());
		start.setOccupant(null);		
	}
}
