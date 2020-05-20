
public class Piece {
	public Piece(Player player, Tile tile, int direction) {}
	public boolean canCapture(Piece other) { return false; }
	public boolean canMoveTo(Tile tile) { return true; }
	public Player getPlayer() {	return null; }
	public boolean isKinged() {	return false; }
	public void king() {}
}

