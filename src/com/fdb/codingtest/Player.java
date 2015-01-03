package com.fdb.codingtest;

public class Player {
	private int x; // A to H form left to right
	private int y; // 1 to 8 from bottom to top
	private Direction direction;

	public Player() {
		initialState();
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	private void initialState() {
		this.x = 1;
		this.y = 1;
		this.direction = Direction.NORTH;
	}

	public void forward() {
		switch (direction) {
		case EAST:
			++x;
			break;
		case WEST:
			--x;
			break;
		case NORTH:
			++y;
			break;
		case SOUTH:
			--y;
			break;
		}
	}

	public void rotateClockwise() {
		switch (direction) {
		case EAST:
			this.direction = Direction.SOUTH;
			break;
		case WEST:
			this.direction = Direction.NORTH;
			break;
		case NORTH:
			this.direction = Direction.EAST;
			break;
		case SOUTH:
			this.direction = Direction.WEST;
			break;
		}
	}

	private void rotateClockwise(int numberOfTimes) {
		for (int i = 1; i <= numberOfTimes; i++) {
			rotateClockwise();
		}
	}

	public void rotateAntiClockwise() {
		rotateClockwise(3);
	}

	public boolean isAtRow8() {
		return y == 8;
	}

	@Override
	public String toString() {
		return "Player [x=" + x + ", y=" + y + ", direction=" + direction + "]";
	}
}
