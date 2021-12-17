package Model;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.util.Random;

import view.PrincipalController;

public class ClickPadrao extends Thread implements Runnable{
	
	private int timeWait;
	Random rand = new Random();
	
	public ClickPadrao(int timeWait) {
		this.timeWait = timeWait;
	}
	
	@Override
	public void run() {
		
		while(!PrincipalController.parada) {
			
				Click();
				
				try {
					Thread.sleep(timeWait + rand.nextInt(10000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			
		}
		
	}
	
//Posição especifica
//	@Override
//	public void run() {
//		
//		while(!PrincipalController.parada) {
//		
//				clickRandomico(678 + rand.nextInt(30),500 - rand.nextInt(30), 22000 + rand.nextInt(5000));
//			
//		}
//		
//	}
	
	public void Click() {
		
		int x = MouseInfo.getPointerInfo().getLocation().x; 
		int y = MouseInfo.getPointerInfo().getLocation().y;
			
		try {
			Click.click(x, y);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
	}
	
//	private void clickRandomico(int x, int y, int intervalo) {
//		try {
//			Click.click(x, y);
//		} catch (AWTException e) {
//			e.printStackTrace();
//		}
//		
//		try {
//			Thread.sleep(intervalo);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}

}
