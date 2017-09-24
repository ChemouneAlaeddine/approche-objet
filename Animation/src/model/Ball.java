package model;

import controler.Animation;

public class Ball {

	// Taille de la thise
	public static double WIDTH = 0.35; // 35 cm
	public static double HEIGHT = WIDTH;
	public static double RADIUS = WIDTH/2;
	
	// Masse de la thise
	public static double MASS = 1.0;
	
	// données physiques
	public double x; // position
	public double y;
	public double vx; // vitesse
	public double vy;
	public double ax, ay; // acceleration
	public double x0, y0; // position initiale
	public double vx0; // vitesse initiale
	public double vy0;
	public double fx, fy; // force
	public double t; // temps relatif

	public Ball() {
		fx = 0; // force
		fy = MASS * Animation.GRAVITATION;
		ax = fx / MASS; // acceleration initiale
		ay = fy / MASS; 
		vx0 = vx = 1; // vitesse initiale 1 m/s
		vy0 = vy = 0;
		x0 = x = (Panel.XMIN + Panel.XMAX)/2; // position initiale
		y0 = x = (Panel.YMIN + Panel.YMAX)/2;
		t = 0;
	}
	
	public void step(){
		this.vx = this.vx0 + this.ax * this.t;
		this.vy = this.vy0 + this.ay * this.t;
		double t2 = this.t*this.t;
		this.x = this.x0 + this.vx0 * this.t + (this.ax * t2) / 2;
		this.y = this.y0 + this.vy0 * this.t + (this.ay * t2) / 2;
		if(this.x >= Panel.XMAX - this.WIDTH || this.x <= Panel.XMIN){
			this.vx0 = -this.vx;
			this.vy0 = this.vy ;
			this.x0 = this.x;
			this.y0 = this.y;
			this.t = 0;
		}
		if(this.y >= Panel.YMAX - this.HEIGHT || this.y <= Panel.YMIN){
			this.vx0 = this.vx;
			this.vy0 = -this.vy;
			this.x0 = this.x;
			this.y0 = this.y;
			this.t = 0;
		}
		this.t += AnimationTimer.MSSTEP;
		// TO DO
	}

	
}
