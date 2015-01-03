package com.fdb.codingtest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void test() {
		Player player = new Player();
		System.out.println(player);
		assertEquals(1, player.getX(), 0);
		assertEquals(1, player.getY(), 0);
		player.forward();
		assertEquals(1, player.getX(), 0);
		assertEquals(2, player.getY(), 0);
		player.rotateClockwise(); // E
		assertEquals(1, player.getX(), 0);
		assertEquals(2, player.getY(), 0); // position doesn't change after
											// rotation
		player.forward();
		assertEquals(2, player.getX(), 0);
		assertEquals(2, player.getY(), 0);
		player.rotateClockwise(); // S
		player.rotateClockwise(); // W
		System.out.println(player);
		player.forward();
		assertEquals(1, player.getX(), 0);
		assertEquals(2, player.getY(), 0);
		player.rotateClockwise(); // N
		for (int i = 1; i <= 6; i++) {
			player.forward();
		}
		System.out.println(player);
		assertTrue(player.isAtRow8());
	}

}
