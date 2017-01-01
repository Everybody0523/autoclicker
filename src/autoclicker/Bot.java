package autoclicker;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class Bot {

	public Bot() {
	}
	
	
	/**
	 * Performs n clicks with the left mouse button, with a delay of m ms (milliseconds) after each click
	 * 
	 * @param n
	 * 			The number of clicks to be performed
	 * @param m
	 * 			The delay between each click
	 */
	public static void clickALot(int n, int m) throws AWTException{
		Robot r = new Robot();
		int i = 0;
		while (i < n){
			r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			r.delay(m);
			i++;
		}
	}
	
	public static void main(String[] args) throws AWTException{
		clickALot(100, 1);
	}

}
