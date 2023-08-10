package Model;

import com.sun.glass.events.KeyEvent;

import view.PrincipalController;

public class Agilidade extends Habilidade{
	
	@Override
	public void run(){
		
		inicializaRobot();
		
		while (!PrincipalController.parada) {
			
//			if(PrincipalController.agilidadePriff) { 
//				treinoEmPriffdinas();
//			}
		}
	}
	
	
//	AGILIDADE EM PRIFF
	private void treinoEmPriffdinas() {
		
		click(806, 237, 9000 + getRand().nextInt(200)); ;//

		click(725, 336, 9000 + getRand().nextInt(200));	//

		click(714, 380, 12000 + getRand().nextInt(150)); //

		click(828, 414, 10000 + getRand().nextInt(300)); //

		click(832, 471, 8500 + getRand().nextInt(100)); //

		click(671, 441, 8000 + getRand().nextInt(150));

		getR().keyPress(KeyEvent.VK_N);
		getR().keyRelease(KeyEvent.VK_N);

		try {
			Thread.sleep(1000 + getRand().nextInt(500));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
