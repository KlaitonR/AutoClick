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
		
		click(2128 + getRand().nextInt(20), 375 + getRand().nextInt(20), 10000  + getRand().nextInt(100));
		click(2128 + getRand().nextInt(20), 375 - getRand().nextInt(20), 9000  + getRand().nextInt(2000));
		click(2128 - getRand().nextInt(20), 375 + getRand().nextInt(20), 13000  - getRand().nextInt(3000));
		click(2128 - getRand().nextInt(20), 375 - getRand().nextInt(20), 10000  + getRand().nextInt(1000));
		
//		click(808 + getRand().nextInt(20), 400 + getRand().nextInt(20), 10000  + getRand().nextInt(100));
//		click(808 + getRand().nextInt(20), 400 - getRand().nextInt(20), 9000  + getRand().nextInt(2000));
//		click(808 - getRand().nextInt(20), 400 + getRand().nextInt(20), 13000  - getRand().nextInt(3000));
//		click(808 - getRand().nextInt(20), 400 - getRand().nextInt(20), 10000  + getRand().nextInt(1000));
		
	}


}
