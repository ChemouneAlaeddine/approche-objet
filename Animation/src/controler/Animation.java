package controler;

import model.*;
import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Animation implements ActionListener {

	public static double GRAVITATION = 9.80665;
	
	public static int LIMITATION = 12;

	private ViewFrame viewFrame;
	private ViewBall[] viewBalls;
	private Ball[] balls;
	private int length;

	private AnimationTimer timer;

	public Animation(String title) {
		viewBalls = new ViewBall[LIMITATION];
		balls = new Ball[LIMITATION];
		length = 0;
		viewFrame = new ViewFrame(title, Panel.WIDTH, Panel.HEIGHT, Panel.XMIN, Panel.YMIN, Panel.XMAX, Panel.YMAX, Panel.SCALE, Panel.MARGIN);
		timer = new AnimationTimer(this);
		timer.start();
	}

	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < length; i++) {
			balls[i].step();
			if (balls[i] instanceof JokariBall) {
				JokariBall ball = (JokariBall)balls[i];
				ViewJokariBall viewJokariBall = (ViewJokariBall)viewBalls[i];
				viewJokariBall.setXY(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight(), ball.getXBox(), ball.getYBox(), Panel.SCALE, Panel.MARGIN);
				ball.collision(balls, length);
			}
			else {
				viewBalls[i].setXY(balls[i].getX(), balls[i].getY(), balls[i].getWidth(), balls[i].getHeight(), Panel.SCALE, Panel.MARGIN);
				balls[i].collision(balls, length);
			}
		}
		viewFrame.panel.repaint();
		java.awt.Toolkit.getDefaultToolkit().sync();
	}

	public void newBall(double x, double y, double width, double mass) {
		if (length < LIMITATION) {
			viewBalls[length] = new ViewBall();
			viewFrame.newViewBall(viewBalls[length]);
			balls[length] = new Ball(x, y, width, mass);
			length++;
		}
		else {
			System.out.println("Limitation reached!");
		}
	}

	public void newJokariBall(double x, double y) {
		if (length < LIMITATION) {
			viewBalls[length] = new ViewJokariBall();
			viewFrame.newViewBall(viewBalls[length]);
			balls[length] = new JokariBall(x, y);
			length++;
		}
		else {
			System.out.println("Limitation reached!");
		}
	}

}
