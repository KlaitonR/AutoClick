package Model;

import com.sun.glass.events.KeyEvent;

import view.PrincipalController;

public class Agilidade extends Habilidade{
	
	@Override
	public void run(){
		
		inicializaRobot();
		
		while (!PrincipalController.parada) {
			
			if(PrincipalController.agilidadePriff) {
				treinoEmPriffdinas();
			}
		}
	}
	
//	AGILIDADE EM PRIFF
	private void treinoEmPriffdinas() {
		
		click(2082, 178, 9000 + getRand().nextInt(200));

		click(1996, 264, 9000 + getRand().nextInt(200));

		click(1996, 264, 12000 + getRand().nextInt(150));

		click(2061, 335, 10000 + getRand().nextInt(300));

		click(2106, 349, 8500 + getRand().nextInt(100));

		click(1969, 370, 8000 + getRand().nextInt(150));

		getR().keyPress(KeyEvent.VK_N);
		getR().keyRelease(KeyEvent.VK_N);

		try {
			Thread.sleep(1000 + getRand().nextInt(500));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
