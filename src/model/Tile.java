package model;

public class Tile {
	private boolean hasFruit;
	private boolean hasNorthWall;
	private boolean hasSouthWall;
	private boolean hasWestWall;
	private boolean hasEastWall;
	private boolean hasSnakeHead;
	private boolean hasSnakeBody;
	
	public Tile() {
		
	}
	/**
	 * check if current tile has snake head
	 * @return true if current tile has snake head, false if not
	 */
	public boolean hasSnakeHead() {
		return hasSnakeHead;
	}
	/**
	 * check if current tile has snake body
	 * @return true if current tile has snake body, false if not
	 */
	public boolean hasSnakeBody() {
		return hasSnakeBody;
	}
	/**
	 * Check if current tile has fruit
	 * @return true if current tile has fruit, false if not
	 */
	public boolean hasFruit() {
		return hasFruit;
	}
	/**
	 * return if current tile has north wall.
	 * @return true if current tile has north wall, false if not
	 */
	public boolean isHasNorthWall() {
		return hasNorthWall;
	}
	/**
	 * return if current tile has south wall.
	 * @return true if current tile has south wall, false if not
	 */
	public boolean isHasSouthWall() {
		return hasSouthWall;
	}
	/**
	 * return if current tile has west wall.
	 * @return true if current tile has west wall, false if not
	 */
	public boolean isHasWestWall() {
		return hasWestWall;
	}
	/**
	 * return if current tile has east wall.
	 * @return true if current tile has east wall, false if not
	 */
	public boolean isHasEastWall() {
		return hasEastWall;
	}
	/**
	 * Set current tile as snake head
	 * @param isSnakeHead
	 */
	public void setSnakeHead(boolean isSnakeHead) {
		this.hasSnakeHead = isSnakeHead;
	}
	/**
	 * Set current tile as snake body
	 * @param isSnakeBody
	 */
	public void setSnakeBody(boolean isSnakeBody) {
		this.hasSnakeBody = isSnakeBody;
	}
	/**
	 * Set current tile to has north wall
	 * @param hasNorthWall
	 */
	public void setHasNorthWall(boolean hasNorthWall) {
		this.hasNorthWall = hasNorthWall;
	}
	/**
	 * Set current tile to has south wall
	 * @param hasSouthWall
	 */
	public void setHasSouthWall(boolean hasSouthWall) {
		this.hasSouthWall = hasSouthWall;
	}
	/**
	 * Set current tile to has west wall
	 * @param hasWestWall
	 */
	public void setHasWestWall(boolean hasWestWall) {
		this.hasWestWall = hasWestWall;
	}
	/**
	 * Set current tile to has east wall
	 * @param hasEastWall
	 */
	public void setHasEastWall(boolean hasEastWall) {
		this.hasEastWall = hasEastWall;
	}
	
}
