package Model;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.ThreadLocalRandom;

import view.PrincipalController;

public class ClickRandomico extends Thread implements Runnable{
	
	private long init;
	private long intervalo;
	private long cont;
	private int maxTimeWaiting;
	private int minTimeWaiting;
	private int maxTimeTecla;
	
	private String tecla = "";
	private boolean teclaAtiva;
	
	private Robot r = null;

	public ClickRandomico(long init, long intervalo, int minTime,int maxTime, int maxTimeTecla) {
		this.init = init;
		this.intervalo = intervalo;
		this.minTimeWaiting = minTime;
		this.maxTimeWaiting = maxTime;
		this.maxTimeTecla = maxTimeTecla;
	}
	
	public ClickRandomico(long init, long intervalo, int minTime,int maxTime, int maxTimeTecla, String tecla) {
		this.init = init;
		this.intervalo = intervalo;
		this.minTimeWaiting = minTime;
		this.maxTimeWaiting = maxTime;
		this.maxTimeTecla = maxTimeTecla;
		this.tecla = tecla;
	}
	
	@Override
	public void run() {
		
		try {
			r = new Robot();
		} catch (AWTException e1) {
			e1.printStackTrace();
		}
		
		while(!PrincipalController.parada) {
			
			if(PrincipalController.tecladoAtivo) {
			
				if(System.currentTimeMillis() >= (init + intervalo)) {
					
				click();
				teclaAtiva = true;
				cont = System.currentTimeMillis() + ThreadLocalRandom.current().nextLong(maxTimeTecla + 2000);
				
				}else if (teclaAtiva) {
				
					if(System.currentTimeMillis() >= cont) {
						
						teclaAtiva = false;
						
						if(tecla.equals("SPACE")) {
							r.keyPress(KeyEvent.VK_SPACE);
							r.keyRelease(KeyEvent.VK_SPACE);
							System.out.println("\n Apertou espaço \n");
						}
						
						init += maxTimeTecla; 
					}
				}
				
			}else {
				
				if(System.currentTimeMillis() >= (init + intervalo)) 
					click();
				
			}
		}
		
		PrincipalController.tecladoAtivo = false;
	}		
	
	private void click() {
		
		int x = MouseInfo.getPointerInfo().getLocation().x; 
		int y = MouseInfo.getPointerInfo().getLocation().y;
			
		try {
			Click.click(x, y);
		} catch (AWTException e) {
			e.printStackTrace();
		}
			
		init = System.currentTimeMillis();
		intervalo = ThreadLocalRandom.current().nextLong(minTimeWaiting, maxTimeWaiting);
			
		System.out.println(init);
		System.out.println(intervalo);
		System.out.println(init + intervalo);
		System.out.println(PrincipalController.cont++ + "\n");
	}

}
