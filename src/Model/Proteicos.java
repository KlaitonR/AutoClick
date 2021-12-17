package Model;

import com.sun.glass.events.KeyEvent;

import view.PrincipalController;

public class Proteicos extends Habilidade {
	
	@Override
	public void run(){
		
		inicializaRobot();
		
		System.out.println("iniciou");
		
		while (!PrincipalController.parada) {
			
			try {
				Thread.sleep(3000 + getRand().nextInt(500));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
			getR().keyPress(KeyEvent.VK_N);
			getR().keyRelease(KeyEvent.VK_N);
					
			try {
				Thread.sleep(1000 + getRand().nextInt(500));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			getR().keyPress(KeyEvent.VK_SPACE);
			getR().keyRelease(KeyEvent.VK_SPACE);
									
			try { 
				Thread.sleep(250000 + getRand().nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

}
