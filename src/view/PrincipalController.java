package view;

import java.util.concurrent.ThreadLocalRandom;
import Model.ClickRandomico;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class PrincipalController {
	
	
	@FXML TextField minTimeWithing;
	@FXML TextField maxTimeWithing;
	@FXML TextField maxTtimeTecla;
	@FXML ComboBox<String> teclas;
	
	public static boolean parada;
	public static long init;
	public static long intervalo;
	
	private int maxTimeWaiting;
	private int minTimeWaiting;
	private int maxTimeTecla;
	
	private String tecla;
	
	public static boolean tecladoAtivo;
	public static int cont;
	
	@FXML
	public void initialize() {
		inicializaComboTeclas();
	}
	
	@FXML
	public void inicia() {
		
		parada = false;
	
		try {
			minTimeWaiting = Integer.parseInt(minTimeWithing.getText());
			maxTimeWaiting = Integer.parseInt(maxTimeWithing.getText());
			
			 if((minTimeWaiting <= 0 || maxTimeWaiting > 2147483) && (minTimeWaiting > maxTimeWaiting)) {
				mostraMensagem("> O número precisa ser maior que 0 e menor que 2.147.483 \n"
								+ "> O tempo mínimo não pode ser maior que o máximo", AlertType.WARNING);
			    IllegalArgumentException erro = new IllegalArgumentException();
			    throw erro;
			 }else {
				minTimeWaiting*=1000;
				maxTimeWaiting*=1000;
				init = System.currentTimeMillis();
				intervalo = ThreadLocalRandom.current().nextLong(minTimeWaiting, maxTimeWaiting);
					
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
				 Thread cr =  new ClickRandomico(init, intervalo, minTimeWaiting, maxTimeWaiting, maxTimeTecla, tecla);
					cr.start();		
			 }
			
		}else {
			Thread cr =  new ClickRandomico(init, intervalo, minTimeWaiting, maxTimeTecla, maxTimeWaiting);
			cr.start();		
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
