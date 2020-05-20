package Checkers;
public class Game {
	Tile[][] tile;
	Player player1, player2;
	/*
	 * Initializes the game and creates the board, an 8 by 8 array of Tiles.Does not yet add Pieces to the Board.
	 */
	public Game() {
		this.player1 = this.player2 = null;
		
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++) {
				this.tile[i][j] = new Tile(i, j);
			}
		}
	}
	/*
	 * If the game has no players, sets the supplied Player to be Player One. 
	 * If the game currently has one player, sets the supplied Player to be 
	 * Player Two, assigns colors and directions to each Player as appropriate, 
	 * and starts the game. If the game currently has two non-null players, does nothing.
	 */
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
	//protected void exectuteMove(Move move) {}
	// protected void isLegalMove(Move move) {}
	protected void play() {}
	protected void startGame() {}
	protected void switchTurns() {}
	
}
