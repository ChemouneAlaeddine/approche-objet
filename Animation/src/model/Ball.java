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
	
	public void step(){/*
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
		this.t += AnimationTimer.MSSTEP;*/
				
			this.t += AnimationTimer.MSSTEP;
			this.vx = this.vx0 + this.ax * this.t;
			this.vy = this.vy0 + this.ay * this.t;
			double t2 = this.t*this.t;
			this.x = this.x0 + this.vx0 * this.t + (this.ax * t2) / 2;
			this.y = this.y0 + this.vy0 * this.t + (this.ay * t2) / 2;
		    this.Move();		
		
		// TO DO
	}
	public void Move(){
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
	}
	
	public double Getx(){
		return this.x;
	}
	
	public void Setx(double x){
		this.x=x;
	}
	public double Gety(){
		return this.y;
	}
	
	public void Sety(double y){
		this.y=y;
	}
	public double Getvx(){
		return this.vx;
	}
	
	public void Setvx(double vx){
		this.vx=vx;
	}
	
	public double Getvy(){
		return this.vy;
	}
	
	public double Getax(){
		return this.ax;
	}
	
	public void Setax(double ax){
		this.ax=ax;
	}
	public double Getay(){
		return this.ay;
	}
	
	public void Setay(double ay){
		this.ay=ay;
	}
	public double Getx0(){
		return this.x0;
	}
	
	public void Setx0(double x0){
		this.x0=x0;
	}
	public double Gety0(){
		return this.y0;
	}
	
	public void Sety0(double y0){
		this.y0=y0;
	}
	public double Getvx0(){
		return this.vx0;
	}
	
	public void Setvx0(double vx0){
		this.vx0=vx0;
	}
	public double Getvy0(){
		return this.vy0;
	}
	
	public void Setvy0(double vy0){
		this.vy0=vy0;
	}
	public double Getfx(){
		return this.fx;
	}
	
	public void Setfx(double fx){
		this.fx=fx;
	}
	public double Getfy(){
		return this.fy;
	}
	
	public void Setfy(double fy){
		this.fy=fy;
	}
	public double Gett(){
		return this.t;
	}
	
	public void Sett(double t){
		this.t=t;
	}
	
	public double GetRadius(){
		return Ball.RADIUS;
	}

	
}
