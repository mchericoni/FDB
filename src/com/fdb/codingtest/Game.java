package com.fdb.codingtest;

import java.util.Scanner;

public class Game {

	private static Player player;
	private static Landmines mines;
	private static final int MAX_MINES_HIT = 3;
	private static int hits;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		setupNewGame();

		while (true) {
			System.out.println("Enter command (e.g. RCM1, M2): ");
			String command = input.nextLine();
			System.out.println("Command: " + command);
			// Execute command
			if (command.length() == 4) {
				execute(command.substring(0, 2));
				execute(command.substring(2, 4));
			} else if (command.length() == 2) {
				execute(command);
			} else
				throw new IllegalArgumentException("Wrong command: " + command);

			// Check outcome
			if (hits >= MAX_MINES_HIT) {
				System.out.println("You lose!");
				setupNewGame();
			} else if (player.isAtRow8()) {
				System.out.println("You win!!");
				setupNewGame();
			}

			// Display new state
			System.out.println(player);
		}

	}

	private static void execute(String command) {
		if (command.length() != 2)
			throw new IllegalArgumentException("Wrong command " + command
					+ ", expected length is 2");
		if (command.startsWith("R")) {
			if (command.charAt(1) == 'C') {
				player.rotateClockwise();
			} else if (command.charAt(1) == 'A') {
				player.rotateAntiClockwise();
			} else
				throw new IllegalArgumentException("Wrong rotation command: "
						+ command);
		} else if (command.startsWith("M")) {
			int n = Character.getNumericValue(command.charAt(1));
			for (int i = 0; i < n; i++) {
				player.forward();
				if (mines.isThereAMineAt(player.getX(), player.getY())) {
					++hits;
					System.out.println("Boom! Hits: " + hits);
				}
			}
		} else {
			throw new IllegalArgumentException("Unrecognised command: "
					+ command);
		}
	}

	private static void setupNewGame() {
		player = new Player();
		mines = new Landmines();
		hits = 0;
		System.out.println(player);
		System.out.println(mines); // In a real game it shoudln't be displayed
	}
}
