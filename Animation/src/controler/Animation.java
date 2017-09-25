package controler;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.*;
import view.*;

public class Animation implements ActionListener {

	// Quelques constantes
	public static double GRAVITATION = 9.80665; // acceleration de la gravitation

	private ViewFrame viewFrame;
	private ViewBall viewBall1,viewBall2;
	private Panel panel;
	private Ball ball1,ball2;
	// Objet permettant de provoquer une animation à temps réguliers
	private AnimationTimer timer;


	public Animation(String title) {
		//this.ball = modelBall;
		Ball ballon1 = new Ball();// added
		Ball ballon2 = new Ball();// added
		this.ball1 = ballon1;// added
		this.ball2 = ballon2;// added
		ball2.Setx0(ball2.Getx0()+1);
		panel = new Panel();	
		viewBall1 = new ViewBall();
		viewBall2 = new ViewBall();
		viewFrame = new ViewFrame(title, Panel.WIDTH, Panel.HEIGHT,
				Panel.XMIN, Panel.YMIN, Panel.XMAX, Panel.YMAX,
				Panel.SCALE, Panel.MARGIN, viewBall1, viewBall2);

		timer = new AnimationTimer(this);
		timer.start();
	}

	public void actionPerformed(ActionEvent e) {
		//this.step();
		ball1.step();// added
		viewBall1.setXY(ball1.Getx(), ball1.Gety(), 
				Ball.WIDTH, Ball.HEIGHT, 
				Panel.SCALE, Panel.MARGIN);
		
		ball2.step();// added
		viewBall2.setXY(ball2.Getx(), ball2.Gety(), // added
				Ball.WIDTH, Ball.HEIGHT, // added
				Panel.SCALE, Panel.MARGIN);// added
		
		viewFrame.panel.repaint();
		this.collistion(ball1, ball2);
		Toolkit.getDefaultToolkit().sync();
	}
	
	
	public void collistion(Ball ball1, Ball ball2){
		double distance=Math.sqrt(Math.pow(ball1.Getx()-ball2.Getx(), 2)+Math.pow(ball1.Gety()-ball2.Gety(), 2));
		if( distance <= ( ball1.GetRadius()+ball2.GetRadius() ) ){
			//System.out.println("Collision");
			
			
			ball1.Setx0(ball1.Getx());
			ball1.Sety0(ball1.Gety());
			ball1.Setvx0(ball2.Getvx());
			ball1.Setvy0(ball2.Getvy());
			ball1.Sett(0);
			
		    ball2.Setx0(ball2.Getx());
			ball2.Sety0(ball2.Gety());
			ball2.Setvx0(ball1.Getvx());
			ball2.Setvy0(ball1.Getvy());
			ball2.Sett(0);
			
		}
	}
	

	/*public void step() {
		ball.vx = ball.vx0 + ball.ax * ball.t;
		ball.vy = ball.vy0 + ball.ay * ball.t;
		double t2 = ball.t*ball.t;
		ball.x = ball.x0 + ball.vx0 * ball.t + (ball.ax * t2) / 2;
		ball.y = ball.y0 + ball.vy0 * ball.t + (ball.ay * t2) / 2;
		if(ball.x >= Panel.XMAX - Ball.WIDTH || ball.x <= Panel.XMIN){
			ball.vx0 = -ball.vx;
			ball.vy0 = ball.vy ;
			ball.x0 = ball.x;
			ball.y0 = ball.y;
			ball.t = 0;
		}
		if(ball.y >= Panel.YMAX - Ball.HEIGHT || ball.y <= Panel.YMIN){
			ball.vx0 = ball.vx;
			ball.vy0 = -ball.vy;
			ball.x0 = ball.x;
			ball.y0 = ball.y;
			ball.t = 0;
		}
		ball.t += AnimationTimer.MSSTEP;
	}*/


}
