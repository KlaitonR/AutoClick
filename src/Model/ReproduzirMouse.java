package Model;

import java.awt.AWTException;
import view.PrincipalController;

public class ReproduzirMouse extends Thread implements Runnable{
	
	private double posicaoX[] = new double [50];
	private double posicaoY[] = new double [50];
	private int cont;
	private int intervalo = 2000;
	private long init;
	
	public ReproduzirMouse(double x[], double y[]) {
		
		this.posicaoX = x;
		this.posicaoY = y;
		
	}
	
	@Override
	public void run() {
		
		while(PrincipalController.reproduzindoMouse) {
			if(!PrincipalController.parada) {
				if(System.currentTimeMillis() >= (init + intervalo)) {
					if(cont < 50 && posicaoX[cont] > 0 && posicaoY[cont] > 0) {
	
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
			}else {
				PrincipalController.reproduzindoMouse = false;
			}
		}
	}

}
