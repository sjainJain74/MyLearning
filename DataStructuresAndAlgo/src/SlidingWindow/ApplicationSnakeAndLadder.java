package SlidingWindow;

import java.util.LinkedList;

import SnakeAndLadder.Color;
import SnakeAndLadder.Player;
import SnakeAndLadder.SankeAndLadderGame;
import SnakeAndLadder.SmallBox;

public class ApplicationSnakeAndLadder {

	public static void main(String arg[]) {

		Player pBlue = new Player(Color.BLUE, "Shashank", new SmallBox(0));
		Player pRed = new Player(Color.RED, "Shashank", new SmallBox(0));
		LinkedList<Player> queue = new LinkedList<Player>();
		queue.offer(pBlue);
		queue.offer(pRed);
		Integer BoardSize = 100;
		int snakeCount = 5;
		int ladderCount = 6;

		SankeAndLadderGame game = new SankeAndLadderGame(queue, snakeCount, ladderCount, BoardSize);
		game.playGame();

	}

}
