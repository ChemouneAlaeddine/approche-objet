package model;

import java.awt.event.ActionListener;

import javax.swing.Timer;

public class AnimationTimer extends Timer {

	static int STEP = 15;
	public static double MSSTEP = STEP / 1000.0;

	public AnimationTimer(ActionListener actionListener) {
		super(STEP, actionListener);
	}

}
