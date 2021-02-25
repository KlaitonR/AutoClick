package view;

import java.util.concurrent.ThreadLocalRandom;
import Model.ClickPadrao;
import Model.ClickRandomico;
import Model.GravaMouse;
import Model.ReproduzirMouse;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class PrincipalController{

	@FXML TextField timeWaiting;
	
	@FXML TextField minTimeWaiting;
	@FXML TextField maxTimeWaiting;
	@FXML TextField maxTtimeTecla;
	@FXML ComboBox<String> teclas;
	
	public static boolean parada;
	public static long init;
	public static long intervalo;
	
	private int timeWait;
	
	private int maxTimeWait;
	private int minTimeWait;
	private int maxTimeTecla;
	
	private String tecla;
	
	public static boolean tecladoAtivo;
	public static int cont;
	
	public static boolean gravandoMouse;
	public static boolean reproduzindoMouse;
	GravaMouse gm;
	ReproduzirMouse rm;
	
	@FXML
	public void initialize() {
		inicializaComboTeclas();
	}
	
	@FXML
	public void iniciaClickPadrao() {
		
		parada = false;
		
		try {
			timeWait = Integer.parseInt(timeWaiting.getText());
			
			 if((timeWait <= 0 || timeWait > 2147483)) {
					mostraMensagem("> O número precisa ser maior que 0 e menor que 2.147.483 \n", AlertType.WARNING);
				    IllegalArgumentException erro = new IllegalArgumentException();
				    throw erro;
				 }else {
					timeWait*=1000;
					init = System.currentTimeMillis();
					intervalo = System.currentTimeMillis() + timeWait;
				 }
			
		}catch (NumberFormatException e) {
			mostraMensagem("Só é possivel digitar números.", AlertType.WARNING);
		}
		
		Thread cp =  new ClickPadrao(init, intervalo, timeWait);
		cp.start();		
				
	}
	
	@FXML
	public void iniciaClickRandomico() {
		
		parada = false;
	
		try {
			minTimeWait = Integer.parseInt(minTimeWaiting.getText());
			maxTimeWait = Integer.parseInt(maxTimeWaiting.getText());
			
			 if((minTimeWait <= 0 || maxTimeWait > 2147483) && (minTimeWait > maxTimeWait)) {
				mostraMensagem("> O número precisa ser maior que 0 e menor que 2.147.483 \n"
								+ "> O tempo mínimo não pode ser maior que o máximo", AlertType.WARNING);
			    IllegalArgumentException erro = new IllegalArgumentException();
			    throw erro;
			 }else {
				minTimeWait*=1000;
				maxTimeWait*=1000;
				init = System.currentTimeMillis();
				intervalo = ThreadLocalRandom.current().nextLong(minTimeWait, maxTimeWait);
			 }
			 
		} catch (NumberFormatException e) {
			mostraMensagem("Só é possivel digitar números.", AlertType.WARNING);
		}
		
		System.out.println(init);
		System.out.println(intervalo);
		System.out.println(init + intervalo);
		System.out.println(cont++ + "\n");
		
		tecla = teclas.getSelectionModel().getSelectedItem();
		
		if(maxTimeTecla > 0 && tecla == null) {
			mostraMensagem("Selecione uma tecla.", AlertType.WARNING);
			IllegalArgumentException erro = new IllegalArgumentException();
			throw erro;
		}
		
		if(tecla != null) {
			
			try {
				maxTimeTecla = Integer.parseInt(maxTtimeTecla.getText());
			} catch (NumberFormatException e) {
				mostraMensagem("Só é possivel digitar números.", AlertType.WARNING);
			}
			
			tecladoAtivo = true;
			if(maxTimeTecla <= 0 || maxTimeTecla > 2147483) {
				mostraMensagem("> O número precisa ser maior que 0 e menor que 2.147.483", AlertType.WARNING);
			    IllegalArgumentException erro = new IllegalArgumentException();
			    throw erro;
			 }else {
				 maxTimeTecla*=1000;
				 Thread cr =  new ClickRandomico(init, intervalo, minTimeWait, maxTimeWait, maxTimeTecla, tecla);
					cr.start();		
			 }
			
		}else {
			Thread cr =  new ClickRandomico(init, intervalo, minTimeWait, maxTimeTecla, maxTimeWait);
			cr.start();		
		}
	
	}
	
	@FXML
	public void gravacaoMouse() {
		
		parada = false;
		gravandoMouse = true;
		
		System.out.println("Iniciou gravação");
		
		Thread gm = new GravaMouse();
		this.gm = (GravaMouse) gm;
		this.gm.start();
		
	}

	@FXML
	public void reproducaoMouse() {
		
		parada = false;
		
		System.out.println("Iniciou reprodução");
		
		if(gm != null) {
			reproduzindoMouse =  true;
			Thread rm = new ReproduzirMouse(gm.getPositionMouseX(), gm.getPositionMouseY());
			this.rm = (ReproduzirMouse)rm;
			rm.start();
		}
		
	}
	
	@FXML
	public void parada() {
		
		parada = true;
		
	}
	
	private void inicializaComboTeclas() {

		teclas.getItems().add("SPACE");
		teclas.getItems().add("ENTER");
		teclas.getItems().add("ESC");
		teclas.getItems().add("TAB");
		teclas.getItems().add("CAPSLOOK");
		
//		teclas.getSelectionModel().select(0);	
	}
	
	
	 private void mostraMensagem (String msg, AlertType tipo) { // recebe uma String por paremetro
			
			Alert a = new Alert (tipo);
			
			a.setHeaderText(null); // modificar mensagem
			a.setContentText(msg);
			a.show();
		}
	
}
