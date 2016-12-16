package autoclicker;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class Bot {

	public Bot() {
	}
	
	
	/*
	 * Performs n clicks with the left mouse button, with one click every quarter second.
	 */
	public static void clickALot(int n) throws AWTException{
		Robot r = new Robot();
		int i = 0;
		while (i < n){
			r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			i++;
		}
	}
	
	public static void main(String[] args) throws AWTException{
		clickALot(100);
	}

}
