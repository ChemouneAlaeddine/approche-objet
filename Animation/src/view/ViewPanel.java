package view;

import controler.Animation;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JPanel;

public class ViewPanel extends JPanel {

	private double xmin, xmax, ymin, ymax;
	private double scale;
	private int margin;

	private ViewBall[] viewBalls;
	private int length;

	public ViewPanel(int width, int height, double xmin, double ymin, double xmax, double ymax, double scale, int margin) {
		setBounds(new Rectangle(0, width, 0, height));
		this.xmin = xmin;
		this.ymin = ymin;
		this.xmax = xmax;
		this.ymax = ymax;
		this.scale = scale;
		this.margin = margin;
		viewBalls = new ViewBall[Animation.LIMITATION];
		length = 0;
	}

	public void paint(Graphics g) {
		super.paint(g);
		for (int i = 0; i < length; i++) {
			if (viewBalls[i] instanceof ViewJokariBall) {
				ViewJokariBall viewJokariBall = (ViewJokariBall)viewBalls[i];
				viewJokariBall.paint(g);;
			}
			else {
				viewBalls[i].paint(g);;
			}
		}
		((Graphics2D)g).drawLine((int)(xmin * scale) + margin, (int)(ymax * scale) + margin, (int)(xmax * scale) + margin, (int)(ymax * scale) + margin);
		for (double i = xmin; i <= xmax; i++) {
			((Graphics2D)g).drawLine((int)(i * scale) + margin, (int)(ymax * scale) + margin - 2, (int)(i * scale) + margin, (int)(ymax * scale) + margin + 2);
		}
		((Graphics2D)g).drawLine((int)(xmin * scale) + margin, (int)(ymin * scale) + margin, (int)(xmax * scale) + margin, (int)(ymin * scale) + margin);
		((Graphics2D)g).drawLine((int)(xmin * scale) + margin, (int)(ymin * scale) + margin, (int)(xmin * scale) + margin, (int)(ymax * scale) + margin);
		for (double j = ymin; j <= ymax; j++) {
			((Graphics2D)g).drawLine((int)(xmin * scale) + margin - 2, (int)((ymax - j) * scale) + margin, (int)(xmin * scale) + margin + 2, (int)((ymax - j) * scale) + margin);
		}
		((Graphics2D)g).drawLine((int)(xmax * scale) + margin, (int)(ymin * scale) + margin, (int)(xmax * scale) + margin, (int)(ymax * scale) + margin);
	}

	public void newViewBall(ViewBall viewBall) {
		if (length < Animation.LIMITATION) {
			viewBalls[length] = viewBall;
			length++;
		}
		else {
			System.out.println("Limitation reached!");
		}
	}

}
