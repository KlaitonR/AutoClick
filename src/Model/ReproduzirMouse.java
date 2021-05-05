package Model;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import view.PrincipalController;

public class ReproduzirMouse extends Thread implements Runnable{
	
	private double posicaoX[] = new double [50];
	private double posicaoY[] = new double [50];
	private int cont;
	private int breakClick;
	private long init;
	private long initTeclado;
	private int timeWaitingTeclas;
	private String tecla = "";
	private Robot r = null;
	
	public ReproduzirMouse(double x[], double y[], int breakClick) {
		this.posicaoX = x;
		this.posicaoY = y;
		this.breakClick = breakClick;
	}
	
	public ReproduzirMouse(double x[], double y[], int breakClick, int timeWaitingTecla, String tecla) {
		this.posicaoX = x;
		this.posicaoY = y;
		this.breakClick = breakClick;
		this.timeWaitingTeclas = timeWaitingTecla;
		this.tecla = tecla;
	}
	
	@Override
	public void run() {
		
		try {
			r = new Robot();
		} catch (AWTException e1) {
			e1.printStackTrace();
		}
		
		init = System.currentTimeMillis();
		initTeclado = System.currentTimeMillis();
		
		while(PrincipalController.reproduzindoMouse) {
			if(!PrincipalController.parada) {
				if(System.currentTimeMillis() >= (init + breakClick)) {
					if(cont < 50 && posicaoX[cont] >= 0 && posicaoY[cont] >= 0) {
	
						try {
							Click.click((int)posicaoX[cont], (int)posicaoY[cont]);
						} catch (AWTException e) {
							e.printStackTrace();
						}
						
						cont++;
						init = System.currentTimeMillis();
						
					}else {
						cont = 0;
					}
				}
				
				if(PrincipalController.tecladoAtivo) {
					if(System.currentTimeMillis() >= (initTeclado + timeWaitingTeclas)){
						if(tecla.equals("M")) {
							r.keyPress(KeyEvent.VK_M);
							r.keyRelease(KeyEvent.VK_M);
							System.out.println("\n Apertou M \n");
						}
						
						initTeclado = System.currentTimeMillis();
					}	
				}
				
			}else {
				PrincipalController.reproduzindoMouse = false;		
				PrincipalController.tecladoAtivo = false;
			}			
		}
	}

}
