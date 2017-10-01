package model;

import controler.Animation;

public class Ball {

	protected double width, height;
	protected double radius;

	protected double mass;

	protected double x, y;
	protected double vx, vy;
	protected double ax, ay;
	protected double x0, y0;
	protected double vx0, vy0;
	protected double fx, fy;
	protected double t;

	public Ball(double x, double y, double width, double mass) {
		this.width = height = width;
		radius = width / 2;
		this.mass = mass;
		this.x = x0 = x;
		this.y = y0 = y;
		vx = vx0 = 1;
		vy = vy0 = 0;
		fx = 0;
		fy = mass * Animation.GRAVITATION;
		ax = fx / mass;
		ay = fy / mass;
		t = 0;
	}

	public void step() {
		vx = vx0 + ax * t;
		vy = vy0 + ay * t;
		double t2 = t * t;
		x = x0 + vx0 * t + (ax * t2) / 2;
		y = y0 + vy0 * t + (ay * t2) / 2;
		if (x >= Panel.XMAX - width || x <= Panel.XMIN) {
			x0 = x;
			y0 = y;
			vx0 = -vx;
			vy0 = vy ;
			t = 0;
		}
		if (y >= Panel.YMAX - height || y <= Panel.YMIN) {
			x0 = x;
			y0 = y;
			vx0 = vx;
			vy0 = -vy;
			t = 0;
		}
		t += AnimationTimer.MSSTEP;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	public double getRadius() {
		return radius;
	}

	public double getMass() {
		return mass;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void reverse(Ball ball) {
		//vx0 = -vx;
		//vy0 = -vy;
		vx0 = (vx * (mass - ball.mass) + (2 * ball.mass * ball.vx)) / (mass + ball.mass);
		vy0 = (vy * (mass - ball.mass) + (2 * ball.mass * ball.vy)) / (mass + ball.mass);
		x0 = x;
		y0 = y;
		t = AnimationTimer.MSSTEP;
	}

	public static double distance(Ball ballA, Ball ballB) {
		return Math.sqrt(Math.pow(ballA.x - ballB.x, 2) + Math.pow(ballA.y - ballB.y, 2));
	}

	public void collision(Ball[] balls, int length) {
		if (length > balls.length) {
			length = balls.length;
		}
		for (int i = 0; i < length; i++) {
			if (balls[i] != this && distance(balls[i], this) <= balls[i].radius + radius) {
				balls[i].reverse(this);
				this.reverse(balls[i]);
			}
		}
	}

}
