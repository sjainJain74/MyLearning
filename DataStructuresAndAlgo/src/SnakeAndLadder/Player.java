package SnakeAndLadder;

public class Player {

	SmallBox smallBox;
	SnakeAndLadder.Color color;
	String name;
	SmallBox currentBox;

	public Player(SnakeAndLadder.Color color, String name, SmallBox currentBox) {
		// TODO Auto-generated constructor stub
	}

	public SmallBox getSmallBox() {
		return smallBox;
	}

	public void setSmallBox(SmallBox smallBox) {
		this.smallBox = smallBox;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SmallBox getCurrentBox() {
		return currentBox;
	}

	public void setCurrentBox(SmallBox currentBox) {
		this.currentBox = currentBox;
	}

}
