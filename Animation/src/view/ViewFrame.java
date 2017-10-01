package view;

import java.awt.Rectangle;

import javax.swing.JFrame;

public class ViewFrame extends JFrame {

	public ViewPanel panel;

	public ViewFrame(String string, int width, int height, double xmin, double ymin, double xmax, double ymax, double scale, int margin) {
		super(string);
		panel = new ViewPanel(width, height, xmin, ymin, xmax, ymax, scale, margin);
		panel.setBounds(new Rectangle(0, width, 0, height));
		panel.setLayout(null);
		add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(width, height);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void newViewBall(ViewBall viewBall) {
		panel.newViewBall(viewBall);
	}

}
