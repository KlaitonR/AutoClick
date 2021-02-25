package Model;

import java.awt.AWTException;
import java.awt.MouseInfo;
import view.PrincipalController;

public class ClickPadrao extends Thread implements Runnable{
	
	private long init;
	private long intervalo;
	private int timeWait;
	
	public ClickPadrao(long init, long intervalo, int timeWait) {
		this.init = init;
		this.intervalo = intervalo;
		this.timeWait = timeWait;
	}
	
	@Override
	public void run() {
		
		while(!PrincipalController.parada) {
			if(System.currentTimeMillis() >= (init + intervalo)) {
				Click();
			}
		}
		
	}
	
	public void Click() {
		
		int x = MouseInfo.getPointerInfo().getLocation().x; 
		int y = MouseInfo.getPointerInfo().getLocation().y;
			
		try {
			Click.click(x, y);
		} catch (AWTException e) {
			e.printStackTrace();
		}
			
		init = System.currentTimeMillis();
		intervalo = System.currentTimeMillis() + timeWait;
		
	}

}
