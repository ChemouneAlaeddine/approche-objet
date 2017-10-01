package model;

public class JokariBall extends Ball {

	public static int X = Panel.MARGIN + 2;
	public static int Y = Panel.HEIGHT - 2 * Panel.MARGIN - 4;
	
	public static int WIDTH = 50;
	public static int HEIGHT = 25;
	
	public static double MASS = 2.000;

	private double xBox, yBox;

	public JokariBall(double x, double y) {
		super(x, y, 0.15, 0.500);
		xBox = x * Panel.SCALE + X;
		yBox = Y;
	}

	public double getXBox() {
		return xBox;
	}

	public double getYBox() {
		return yBox;
	}

	public void reverse(Ball ball) {
		ball.vx0 = -ball.vx;
		ball.vy0 = -ball.vy;
		//ball.vx0 = (0 * (MASS - ball.mass) + (2 * ball.mass * ball.vx)) / (MASS + ball.mass);
		//ball.vy0 = (0 * (MASS - ball.mass) + (2 * ball.mass * ball.vy)) / (MASS + ball.mass);
		ball.x0 = ball.x;
		ball.y0 = ball.y;
		ball.t = AnimationTimer.MSSTEP;
	}

	public static double distance(Ball ball, double xBox, double yBox) {
		double x = ball.x * Panel.SCALE;
		double y = yBox - Panel.MARGIN - 2 - ball.y * Panel.SCALE;
		double deltaX = Math.max(xBox - X - WIDTH / 2, Math.min(x, xBox - X + WIDTH / 2));
		double deltaY = Math.min(yBox - Y + HEIGHT, y);
		return Math.sqrt(Math.pow(x - deltaX, 2) + Math.pow(y - deltaY, 2));
	}

	public void collision(Ball[] balls, int length) {
		super.collision(balls, length);
		if (length > balls.length) {
			length = balls.length;
		}
		for (int i = 0; i < length; i++) {
			if (distance(balls[i], xBox, yBox) <= balls[i].radius) {
				reverse(balls[i]);
			}
		}
	}

}
