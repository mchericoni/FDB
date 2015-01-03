package com.fdb.codingtest;

public class Landmine {
	private final int x; // A to H from left to right
	private final int y; // 1 to 8 from bottom to top

	public Landmine(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return "Landmine [x=" + x + ", y=" + y + "]";
	}

}
