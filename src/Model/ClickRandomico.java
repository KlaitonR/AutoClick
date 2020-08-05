package Model;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.util.concurrent.ThreadLocalRandom;

import view.PrincipalController;

public class ClickRandomico extends Thread implements Runnable{
	
	private long init;
	private long time;

	public ClickRandomico(long init, long time) {
		this.init = init;
		this.time = time;
	}
	
	@Override
	public void run() {
		
		while(!PrincipalController.parada) {
			if(System.currentTimeMillis() == (init + time)) {
					
				int x = MouseInfo.getPointerInfo().getLocation().x;
				int y = MouseInfo.getPointerInfo().getLocation().y;
					
				try {
					Click.click(x, y);
				} catch (AWTException e) {
					e.printStackTrace();
				}
					
				init = System.currentTimeMillis();
				time = ThreadLocalRandom.current().nextLong(25000, 35000);
					
				System.out.println(init);
				System.out.println(time);
				System.out.println(init + time);
					
			}
		}
	}		

}
