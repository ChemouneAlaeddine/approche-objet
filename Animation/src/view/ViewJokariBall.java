package view;

import model.JokariBall;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D;

public class ViewJokariBall extends ViewBall{

	Rectangle2D.Double rectangle;
	Line2D.Double line;

	public ViewJokariBall() {
		super();
		rectangle = new Rectangle2D.Double();
		line = new Line2D.Double();
	}

	public void paint(Graphics g) {
		super.paint(g);
		((Graphics2D)g).draw(rectangle);
		((Graphics2D)g).draw(line);
	}

	public void setXY(double x, double y, double width, double height, double xBox, double yBox, double scale, int margin) {
		super.setXY(x, y, width, height, scale, margin);
		rectangle.setRect(xBox - JokariBall.WIDTH / 2, yBox - JokariBall.HEIGHT, JokariBall.WIDTH, JokariBall.HEIGHT);
		line.setLine(xBox, yBox - JokariBall.HEIGHT, (x + width / 2) * scale + margin, (y + height / 2 ) * scale + margin);
	}

}
