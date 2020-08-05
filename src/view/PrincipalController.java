package view;

import java.util.concurrent.ThreadLocalRandom;

import Model.ClickRandomico;
import javafx.fxml.FXML;

public class PrincipalController {
	
	public static boolean parada = false;

	@FXML
	public void inicia() {
		
		parada = false;
		
		long init = System.currentTimeMillis();
		long time;
		time = ThreadLocalRandom.current().nextLong(2000, 3000);
		
		System.out.println(init);
		System.out.println(time);
		System.out.println(init + time);

		Thread cr =  new ClickRandomico(init, time);
		cr.start();			
	}
	
	@FXML
	public void parada() {
		
		parada = true;
		
	}
	
}
