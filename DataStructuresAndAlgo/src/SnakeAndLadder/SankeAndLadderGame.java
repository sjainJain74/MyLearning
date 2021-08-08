package SnakeAndLadder;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SankeAndLadderGame {

	private static Queue<Player> queue;
	private static List<Snake> snakeList;
	private static List<Ladder> ladderList;
	private static GameBoard board;
	private static Dice dice;

	public SankeAndLadderGame(Queue<Player> queue, Integer snakeCount, Integer ladderCount, Integer boardSize) {
		this.queue = queue;
		this.snakeList = createListOfSnakes(snakeCount);
		this.ladderList = createListOfLadder(ladderCount);
		this.board = new GameBoard(boardSize);
		this.dice = new Dice();
	}

	public void playGame() {

		while (true) {

			// 1. Offer from queue, Let'suppose we get player Blue
			// 2. Roll a Dice to give a count ( 1-6)
			// 3. Check if player.getCurrentPosition() + count is on start of snake or
			// ladder
			// if yes decide based on snake or ladder
			// else if player.getCurrentPosition() + count >100 ==> No change
			// else if player.getCurrentPosition() ==100 ==>Break player won
			// Else player.setCurrentPosition(player.getCurrentPosition() + count)
			// queue.offer(player)

			Player currentPlayer = queue.poll();
			int count = dice.roll();

			if (checkIfBiteBySnakeOrReachedLadder(currentPlayer.getCurrentBox(), count)) {
				updatePlayerPositionAfterSnakeOrLadder(currentPlayer.getCurrentBox(), count);
			}

			else if (Integer.sum(currentPlayer.getCurrentBox().getBoxNumber(), count) > 100) {
				// No change
			} else if (Integer.sum(currentPlayer.getCurrentBox().getBoxNumber(), count) < 100) {
				currentPlayer
						.setCurrentBox(new SmallBox(Integer.sum(currentPlayer.getCurrentBox().getBoxNumber(), count)));
			} else if (Integer.sum(currentPlayer.getCurrentBox().getBoxNumber(), count) == 100) {
				System.out.println(" Hurray Player Won " + currentPlayer.getName());
				break;
			}

			// Adding at end for queue for next chance
			queue.offer(currentPlayer);

		}

	}

	private static void updatePlayerPositionAfterSnakeOrLadder(SmallBox currentBox, int count) {
		// TODO Auto-generated method stub

	}

	private static boolean checkIfBiteBySnakeOrReachedLadder(SmallBox currentBox, int count) {
		return false;
		// TODO Auto-generated method stub

	}

	private static List<Ladder> createListOfLadder(Integer ladderCount) {
		// TODO Auto-generated method stub
		return null;
	}

	private static LinkedList<Snake> createListOfSnakes(Integer snakeCountsnakeCount) {
		return null;
		// TODO Auto-generated method stub

	}

}
