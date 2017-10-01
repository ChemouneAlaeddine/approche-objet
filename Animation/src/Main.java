import controler.*;

import model.Panel;

import java.util.Random;

public class Main {

	static Animation animation;

	public static void main(String[] args) {
		Random random = new Random();
		animation = new Animation("Animation");
		animation.newBall(0.60 + random.nextDouble() * (Panel.XMAX - 0.60), 0.60 + random.nextDouble() * (Panel.XMAX - 0.60), 0.30, 0.750);
		animation.newBall(0.40 + random.nextDouble() * (Panel.XMAX - 0.40), 0.40 + random.nextDouble() * (Panel.XMAX - 0.40), 0.20, 0.500);
		animation.newBall(0.20 + random.nextDouble() * (Panel.XMAX - 0.20), 0.20 + random.nextDouble() * (Panel.XMAX - 0.20), 0.10, 0.250);
		animation.newBall(0.60 + random.nextDouble() * (Panel.XMAX - 0.60), 0.60 + random.nextDouble() * (Panel.XMAX - 0.60), 0.30, 0.750);
		animation.newBall(0.40 + random.nextDouble() * (Panel.XMAX - 0.40), 0.40 + random.nextDouble() * (Panel.XMAX - 0.40), 0.20, 0.500);
		animation.newBall(0.20 + random.nextDouble() * (Panel.XMAX - 0.20), 0.20 + random.nextDouble() * (Panel.XMAX - 0.20), 0.10, 0.250);
		animation.newBall(0.60 + random.nextDouble() * (Panel.XMAX - 0.60), 0.60 + random.nextDouble() * (Panel.XMAX - 0.60), 0.30, 0.750);
		animation.newBall(0.40 + random.nextDouble() * (Panel.XMAX - 0.40), 0.40 + random.nextDouble() * (Panel.XMAX - 0.40), 0.20, 0.500);
		animation.newBall(0.20 + random.nextDouble() * (Panel.XMAX - 0.20), 0.20 + random.nextDouble() * (Panel.XMAX - 0.20), 0.10, 0.250);
		animation.newJokariBall(0.30 + random.nextDouble() * (Panel.XMAX - 0.30), 0.30 + random.nextDouble() * (Panel.XMAX - 0.30));
		animation.newJokariBall(0.30 + random.nextDouble() * (Panel.XMAX - 0.30), 0.30 + random.nextDouble() * (Panel.XMAX - 0.30));
		animation.newJokariBall(0.30 + random.nextDouble() * (Panel.XMAX - 0.30), 0.30 + random.nextDouble() * (Panel.XMAX - 0.30));
	}

}
