package Model;

import view.PrincipalController;

public class Necromancia extends Habilidade {
	
	@Override
	public void run(){
		while (!PrincipalController.parada) {
			necromancia();
		}
	}
	
	private void necromancia() {
		clickDireito(959, 467, 1500 + getRand().nextInt(1000));
		click(931, 525, 5000 + getRand().nextInt(1000));		
		
		click(959 + getRand().nextInt(10), 788 + getRand().nextInt(2), 48000 + getRand().nextInt(1000));
		click(959 + getRand().nextInt(10), 788 + getRand().nextInt(2), 44000 + getRand().nextInt(1000));
		click(959 + getRand().nextInt(10), 788 + getRand().nextInt(2), 44000 + getRand().nextInt(1000));
		click(959 + getRand().nextInt(10), 788 + getRand().nextInt(2), 44000 + getRand().nextInt(1000));
		click(959 + getRand().nextInt(10), 788 + getRand().nextInt(2), 44000 + getRand().nextInt(1000));
		click(959 + getRand().nextInt(10), 788 + getRand().nextInt(2), 44000 + getRand().nextInt(1000));
	}
}
