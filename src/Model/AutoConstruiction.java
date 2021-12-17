package Model;

public class AutoConstruiction  extends Habilidade {

	@Override
	public void run(){
		
		inicializaRobot();
		
	//	int posXDireito = 0;
//		int posXEsquerdo = 0;
	//	int posYDireito = 0;
//		int posYEsquedo = 0;
		
		
//		POSIÇÃO COLHER COQUEIRO - EVENTO DA PRAIA (AGRICULTURA)
		
//		X: 1947.0    Y: 292.0 
//		click(2457, 264, 1000); //Click na poção
//		click(1947, 292, 1500);
		
			
//ARTESANATO - LÁPIDAR GEMAS
			
//			click(2008, 273, 1500 + getRand().nextInt(200));
//			System.out.println("clicou");
//			
//			getR().keyPress(KeyEvent.VK_F5); //PREDEFINIÇÃO
//			getR().keyRelease(KeyEvent.VK_F5);
//			System.out.println("apertou F5");
//			
//			try {
//				Thread.sleep(1200 + getRand().nextInt(200));
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			
//			getR().keyPress(KeyEvent.VK_B);
//			getR().keyRelease(KeyEvent.VK_B);
//			System.out.println("apertou b");
//			
//			try {
//				Thread.sleep(1200 + getRand().nextInt(200));
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			
//			getR().keyPress(KeyEvent.VK_SPACE);
//			getR().keyRelease(KeyEvent.VK_SPACE);
//			System.out.println("apertou espaço");
//			
//			try {
//				Thread.sleep(16300 + getRand().nextInt(500));
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			System.out.println("terminou \n");
			
			
			
		//COLHER COQUEIRO - EVENTO DA PRAIA (AGRICULTURA)
			
//			X: 2457.0    Y: 264.0   
//		if(System.currentTimeMillis() >= (init + intervalo)) {
//			click(2457, 264, 1000); //Click na poção
//			click(1947, 292, 1500); //click no coqueiro
//			init = System.currentTimeMillis();
//		}
//		
//		try {
//			Thread.sleep(15000 + getRand().nextInt(4000));
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		getR().keyPress(KeyEvent.VK_M);
//		try {
//			Thread.sleep(3000 + getRand().nextInt(3000));
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		getR().keyRelease(KeyEvent.VK_M);
			
		//DESMONTAR PEÇAS (INVENÇÃO)
			
//			X: 1182.0    Y: 348.0   contador: 9
//			
//			posXEsquerdo = (1182 - getRand().nextInt(3));
//			posYEsquedo = (348 + getRand().nextInt(3));
//			click(posXEsquerdo, posYEsquedo, 1500 + getRand().nextInt(700));
//			
//			posXEsquerdo = (1182 - getRand().nextInt(3));
//			posYEsquedo = (348 + getRand().nextInt(3));
//			click(posXEsquerdo, posYEsquedo, 60000 + getRand().nextInt(5000));
			
			
//			
//			posXEsquerdo = (890 - getRand().nextInt(5));
//			posYEsquedo = (225 + getRand().nextInt(8));
//			click(posXEsquerdo, posYEsquedo, 8500 + getRand().nextInt(500));
//			
//			posXEsquerdo = (888 + getRand().nextInt(5));
//			posYEsquedo = (350 - getRand().nextInt(8));
//			click(posXEsquerdo, posYEsquedo, 7000 + getRand().nextInt(500));
//			
//			posXEsquerdo = (888 + getRand().nextInt(5));
//			posYEsquedo = (350 - getRand().nextInt(8));
//			click(posXEsquerdo, posYEsquedo, 10000 + getRand().nextInt(500));
//			
//			posXEsquerdo = (888 + getRand().nextInt(5));
//			posYEsquedo = (350 - getRand().nextInt(8));
//			click(posXEsquerdo, posYEsquedo, 10500 + getRand().nextInt(500));
//			
//			posXEsquerdo = (888 + getRand().nextInt(5));
//			posYEsquedo = (350 - getRand().nextInt(8));
//			click(posXEsquerdo, posYEsquedo, 7500 + getRand().nextInt(500));
//			
//			posXEsquerdo = (490 + getRand().nextInt(5));
//			posYEsquedo = (280 - getRand().nextInt(8));
//			click(posXEsquerdo, posYEsquedo, 6500 + getRand().nextInt(500));
//			
//			
//			getR().keyPress(KeyEvent.VK_K);
//			getR().keyRelease(KeyEvent.VK_K);
//			
//			try {
//				Thread.sleep(3000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			
//		}
		
	
			//MONTAR COMODORO (CONSTRUÇÃO)
//		//Clicando para construir 1
//		click(683 - getRand().nextInt(20), (522 - getRand().nextInt(20)), (1500 + getRand().nextInt(300)));
//		click(683 + getRand().nextInt(25), (480 + getRand().nextInt(20)), (2100 + getRand().nextInt(350)));
//		
//		//Clicando para destruir 1
//		posYDireito = (496 - getRand().nextInt(15));
//		posYEsquedo = ((posYDireito + 75) + getRand().nextInt(3)); 
//		posXDireito = (676 + getRand().nextInt(20));
//		posXEsquerdo = (posXDireito + getRand().nextInt(10));
//		clickDireito(posXDireito, posYDireito, (1500 + getRand().nextInt(340)));
//		click(posXEsquerdo, posYEsquedo, (1500 + getRand().nextInt(400)));
//		
//		//Clicando para construir 2
//		click(683 + getRand().nextInt(25), (522 + getRand().nextInt(13)), (1550 + getRand().nextInt(300)));
//		click(683 - getRand().nextInt(15), (480 - getRand().nextInt(17)), (2100 + getRand().nextInt(200)));
//		
//		//Clicando para destruir 2 
//		posYDireito = (496 - getRand().nextInt(15));
//		posYEsquedo = ((posYDireito + 75) + getRand().nextInt(3)); 
//		posXDireito = (676 + getRand().nextInt(20));
//		posXEsquerdo = (posXDireito + getRand().nextInt(10));
//		clickDireito(posXDireito, posYDireito, (1500 + getRand().nextInt(340)));
//		click(posXEsquerdo, posYEsquedo, (1500 + getRand().nextInt(400)));
//		
//		//Clicando para construir 3
//		click((683 - getRand().nextInt(25)), (522 + getRand().nextInt(14)), (1500 + getRand().nextInt(400)));
//		click((683 + getRand().nextInt(18)), (480 - getRand().nextInt(17)), (2200 + getRand().nextInt(300)));
//		
//		//Clicando para destruir 3
//		posYDireito = (496 - getRand().nextInt(15));
//		posYEsquedo = ((posYDireito + 75) + getRand().nextInt(3)); 
//		posXDireito = (676 + getRand().nextInt(20));
//		posXEsquerdo = (posXDireito + getRand().nextInt(10));
//		clickDireito(posXDireito, posYDireito, (1500 + getRand().nextInt(340)));
//		click(posXEsquerdo, posYEsquedo, (1500 + getRand().nextInt(400)));
//		
//		//Clicando na interface Mordomo caso o mordomo cobre o valor
//		click((1240 + getRand().nextInt(25)), (455 - getRand().nextInt(12)), (3000 + getRand().nextInt(400)));
//		click((261 - getRand().nextInt(10)), (712 - getRand().nextInt(3)) , (1000 + getRand().nextInt(300)));
//		
//		//Clicando na interface Mordomo
//		click((1240 - getRand().nextInt(25)), (455 - getRand().nextInt(12)),(2000 - getRand().nextInt(400)));
//		
//		//Clicando no chão para fechar diálogo
//		click((673 + getRand().nextInt(5)), (422 - getRand().nextInt(3)), (2000 + getRand().nextInt(350)));
//		
//		//Clicando na interface Mordomo e na barra de diálogo definitivamente
//		click((1240 + getRand().nextInt(25)), (455 - getRand().nextInt(9)), (2000 + getRand().nextInt(500)));
//		click((1240 + getRand().nextInt(25)), (455 - getRand().nextInt(12)), (2000 + getRand().nextInt(300)));
//		
//		//Fazendo pedido ao mordomo
//		click((261 - getRand().nextInt(9)), (712 - getRand().nextInt(3)), (1500 + getRand().nextInt(300)));
//		click((261 + getRand().nextInt(10)), (637 - getRand().nextInt(3)), (1550 + getRand().nextInt(200)));
//		click((259 - getRand().nextInt(7)), (671 + getRand().nextInt(3)), (1500 + getRand().nextInt(400)));
//		click((261 + getRand().nextInt(8)), (637 + getRand().nextInt(3)), (7500 + getRand().nextInt(1000)));
			
			
		}

}
