package Model;

import java.awt.MouseInfo;
import view.PrincipalController;

public class GravaMouse extends Thread implements Runnable {

	public double posicaoX[] = new double [50];
	public double posicaoY[] = new double [50];
	private int cont;
	private int breakClick;
	private long init;
	
	public GravaMouse(int breakClick) {
		this.breakClick = breakClick;
	}
	
	public double[] getPositionMouseX() {
		return posicaoX;
	}
	
	public double[] getPositionMouseY() {
		return posicaoY;
	}
	
	public void inicializaPosicao() {
		
		for(int i = 0; i<posicaoX.length; i++) {
			posicaoX[i] = -1;
			posicaoY[i] = -1;
		}
		
	}
	
	@Override
	public void run() {
		
		inicializaPosicao();
		
		init = System.currentTimeMillis();
		
		while(PrincipalController.gravandoMouse) {
			if(!PrincipalController.parada) {
				if(cont < 50 - 1 ) {
					if(System.currentTimeMillis() >= init + breakClick) {
						
						getPosition();
						System.out.println("clickou");
						
					}else {
						if(cont == 50) {
							PrincipalController.gravandoMouse = false;
							PrincipalController.parada = true;
						}
					}
				}
			}else {
				PrincipalController.gravandoMouse = false;		
			}
		}
		
	}
	
	public void getPosition() {
		
		posicaoX[cont] = MouseInfo.getPointerInfo().getLocation().getX();
		posicaoY[cont] = MouseInfo.getPointerInfo().getLocation().getY();
		
		System.out.println("X: " + posicaoX[cont] + "    Y: " + posicaoY[cont] + "   contador: " + cont +"\n");
		
		cont++;
		
		init = System.currentTimeMillis();
	}
	
}
