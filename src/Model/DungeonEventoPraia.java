package Model;

import view.PrincipalController;

public class DungeonEventoPraia extends Habilidade {
	
	@Override
	public void run(){
		
		while (!PrincipalController.parada) {
			
//			eventoPraia();
//			mineracaoPrif();
//			invencao();
			necromancia();
			
		}
	}
	
	private void necromancia() {
		
		clickDireito(959, 467, 1500 + getRand().nextInt(1000));
		click(931, 525, 5000 + getRand().nextInt(1000));		
		
		//+ getRand().nextInt(1000)
		click(959 + getRand().nextInt(10), 788 + getRand().nextInt(2), 48000 + getRand().nextInt(1000));
		click(959 + getRand().nextInt(10), 788 + getRand().nextInt(2), 44000 + getRand().nextInt(1000));
		click(959 + getRand().nextInt(10), 788 + getRand().nextInt(2), 44000 + getRand().nextInt(1000));
		click(959 + getRand().nextInt(10), 788 + getRand().nextInt(2), 44000 + getRand().nextInt(1000));
		click(959 + getRand().nextInt(10), 788 + getRand().nextInt(2), 44000 + getRand().nextInt(1000));
		click(959 + getRand().nextInt(10), 788 + getRand().nextInt(2), 44000 + getRand().nextInt(1000));
	}
	
	
	
//	private void invencao() {
//		click(1252 + getRand().nextInt(10), 378 + getRand().nextInt(10), 1300  + getRand().nextInt(100));
//		click(1223 + getRand().nextInt(10), 563 - getRand().nextInt(10), 60000  + getRand().nextInt(3000));
//	}
	
//	AGRICULTURA NA ARENA DE DUELO
	private void eventoPraia() {
		
//		Tela 1
//		click(723 + getRand().nextInt(20), 338 + getRand().nextInt(20), 10000  + getRand().nextInt(100));
//		click(723 + getRand().nextInt(20), 338 - getRand().nextInt(20), 9000  + getRand().nextInt(2000));
		
//		Tela 2
		click(-654 + getRand().nextInt(20), 152 + getRand().nextInt(30), 45000  + getRand().nextInt(1000));
		click(-654 + getRand().nextInt(20), 152 - getRand().nextInt(30), 3500  + getRand().nextInt(1200));		
	}
	
	private void mineracaoPrif() {
		click(719 + getRand().nextInt(20), 307 + getRand().nextInt(30), 40000  + getRand().nextInt(5000));
	}


}
