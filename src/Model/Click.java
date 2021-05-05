package Model;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class Click {

	@SuppressWarnings("deprecation")
	public static void click(int x, int y) throws AWTException{
	
	  Robot bot = new Robot();
	  bot.mouseMove(x, y);    
	  bot.mousePress(InputEvent.BUTTON1_MASK);
	  bot.mouseRelease(InputEvent.BUTTON1_MASK);

	}
	
	@SuppressWarnings("deprecation")
	public static void clickDireito(int x, int y) throws AWTException{
	
	  Robot bot = new Robot();
	  bot.mouseMove(x, y);    
	  bot.mousePress(InputEvent.BUTTON3_MASK);
	  bot.mouseRelease(InputEvent.BUTTON3_MASK);

	}

}
