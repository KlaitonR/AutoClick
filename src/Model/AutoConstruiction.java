package Model;

import java.awt.AWTException;
import view.PrincipalController;

public class AutoConstruiction  extends Thread implements Runnable {
	
	@Override
	public void run(){
		
		while(!PrincipalController.parada) {
				
				//Clicando para construir 1
				click(683, 522, 1500);
				click(683, 480, 1500);
				
				//Clicando para destruir 1
				clickDireito(676, 496, 2000);
				click(687, 569, 2000);
					
				//Clicando para construir 2
				click(683, 522, 1500);
				click(683, 480, 2000);
				
				//Clicando para destruir 2 
				clickDireito(676, 496, 2000);
				click(687, 569, 2000);
					
				//Clicando para construir 3
				click(683, 522, 1500);
				click(683, 480, 2000);
				
				//Clicando para destruir 3
				clickDireito(676, 496, 2000);
				click(687, 569, 2000);
			
				//Clicando na interface Mordomo caso o mordomo cobre o valor
				click(1235, 428, 2000);
				click(261, 712, 1000);
			
				//Clicando na interface Mordomo e na barra de diálogo
				click(1235, 428, 2000);
//				click(262, 712, 2000);
				
				//Clicando no chão para fechar diálogo
				click(1235, 428, 2000);
				
				//Clicando na interface Mordomo
				click(1235, 428, 1500);
				click(1235, 428, 1500);
				
				//Clicando no chão para fechar diálogo
				click(673, 422, 1000);
				
				//Clicando na interface Mordomo e na barra de diálogo definitivamente
				click(1235, 428, 1500);
				click(1235, 428, 1500);
				
				//Fazendo pedido ao mordomo
				click(261, 712, 1500);
				click(261, 637, 1500);
				click(259, 671, 1500);
				click(261, 637, 7500);
				
			}
	}		
	
	private void click(int x, int y, int intervalo) {
		try {
			Click.click(x, y);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(intervalo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void clickDireito(int x, int y, int intervalo) {	
		try {
			Click.clickDireito(x, y);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(intervalo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
