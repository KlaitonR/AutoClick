package Model;

import view.PrincipalController;

public class Agricultura extends Habilidade{
	
	@Override
	public void run(){
		
		while (!PrincipalController.parada) {
			
			arenaDeDuelo();
			
		}
	}
	
//	AGRICULTURA NA ARENA DE DUELO
	private void arenaDeDuelo() {
		
//		Tela 1
//		click(723 + getRand().nextInt(20), 338 + getRand().nextInt(20), 10000  + getRand().nextInt(100));
//		click(723 + getRand().nextInt(20), 338 - getRand().nextInt(20), 9000  + getRand().nextInt(2000));
//		click(723 - getRand().nextInt(20), 338 + getRand().nextInt(20), 13000  - getRand().nextInt(3000));
//		click(723 - getRand().nextInt(20), 338 - getRand().nextInt(20), 10000  + getRand().nextInt(1000));
		
//		Tela 2
		click(-635 + getRand().nextInt(20), 261 + getRand().nextInt(20), 10000  + getRand().nextInt(100));
		click(-635 + getRand().nextInt(20), 261 - getRand().nextInt(20), 9000  + getRand().nextInt(2000));
		click(-635 - getRand().nextInt(20), 261 + getRand().nextInt(20), 13000  - getRand().nextInt(3000));
		click(-635 - getRand().nextInt(20), 261 - getRand().nextInt(20), 10000  + getRand().nextInt(1000));
		

		
	}


}
