package com.fdb.codingtest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Landmines {
	private final List<Landmine> mines = new ArrayList<Landmine>();
	private final int MAX_MINES = 4;
	private final Random rand = new Random();

	public Landmines() {
		createLandmines();
	}

	private void createLandmines() {
		int randomNum = rand.nextInt(MAX_MINES) + 1;
		for (int i = 0; i < randomNum; i++) {
			mines.add(createRandomMine());
		}
	}

	private Landmine createRandomMine() {
		int randomX = rand.nextInt(8) + 1;
		int randomY = rand.nextInt(8) + 1;
		return new Landmine(randomX, randomY); // TODO Could already exists at
												// this position
	}

	/**
	 * Checks if there is a landmine at the given position.
	 * 
	 * @param x
	 *            the X coordinate
	 * @param y
	 *            the Y coordinate
	 * @return true if there is a landmine at the given position
	 */
	public boolean isThereAMineAt(int x, int y) {
		for (Iterator<Landmine> iterator = mines.iterator(); iterator.hasNext();) {
			Landmine landmine = (Landmine) iterator.next();
			if (landmine.getX() == x && landmine.getY() == y)
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Landmines [mines=" + mines + "]";
	}
}
