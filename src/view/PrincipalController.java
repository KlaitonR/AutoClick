package view;

import java.util.concurrent.ThreadLocalRandom;

import Model.AutoConstruiction;
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
	@FXML ComboBox<String> teclasRpMouse;
	
	@FXML TextField breakClick;
	
	@FXML TextField timeWaitingTecla;
	
	public static boolean parada;
	public static long init;
	public static long intervalo;
	
	private int timeWait;
	
	private int maxTimeWait;
	private int minTimeWait;
	private int maxTimeTecla;
	
	private int breakClicks;        
	private int timeWaitingTeclas;
	
	private String tecla;
	
	public static boolean tecladoAtivo;
	public static int cont;
	
	public static boolean gravandoMouse;
	public static boolean reproduzindoMouse;
	GravaMouse gm;
	ReproduzirMouse rm;
	
	private double posicaoX[] = new double [50];
	private double posicaoY[] = new double [50];
	
	@FXML
	public void initialize() {
		inicializaComboTeclas();
		inicializaComboTeclasRpMouse();
	}
	
	@FXML
	public void contrucao() {
		
		System.out.println("a");
		
		parada = false;
		
		Thread c = new AutoConstruiction();
		c.start();
		
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
		breakClicks = Integer.parseInt(breakClick.getText())*1000;
		
		Thread gm = new GravaMouse(breakClicks);
		this.gm = (GravaMouse) gm;
		this.gm.start();
		
	}

	@FXML
	public void reproducaoMouse() {
		
		System.out.println("Iniciou reprodução");
		
		parada = false;
		tecla = teclasRpMouse.getSelectionModel().getSelectedItem();
		
		if(tecla != null) {
			
			tecladoAtivo = true;
			
			try {
				
				timeWaitingTeclas = Integer.parseInt(timeWaitingTecla.getText())*1000;
				
			} catch (NumberFormatException e) {
				mostraMensagem("Só é possivel digitar números.", AlertType.WARNING);
			}
			
			teste();
			
//			if(gm != null) {
				breakClicks = Integer.parseInt(breakClick.getText())*1000;
				reproduzindoMouse = true;
//				Thread rm = new ReproduzirMouse(gm.getPositionMouseX(), gm.getPositionMouseY(), breakClicks, timeWaitingTeclas, tecla);
				Thread rm = new ReproduzirMouse(posicaoX, posicaoY, breakClicks, timeWaitingTeclas, tecla);
				this.rm = (ReproduzirMouse)rm;
				rm.start();
//			}
			
		}else {
		
			teste();
			
//			if(gm != null) {
				breakClicks = Integer.parseInt(breakClick.getText())*1000;
				reproduzindoMouse =  true;
//				Thread rm = new ReproduzirMouse(gm.getPositionMouseX(), gm.getPositionMouseY(), breakClicks);
				Thread rm = new ReproduzirMouse(posicaoX, posicaoY, breakClicks);
				this.rm = (ReproduzirMouse)rm;
				rm.start();
//			}
		}
		
	}
	
	public void teste() {
		
		posicaoX[0] = 814;
		posicaoY[0] = 422;
		
		posicaoX[1] = 1102;
		posicaoY[1] = 197;
		
		posicaoX[2] = 1226;
		posicaoY[2] = 185;
		
		posicaoX[3] = 852;
		posicaoY[3] = 421;
		
		posicaoX[4] = 1110;
		posicaoY[4] = 243;
		
		posicaoX[5] = 535;
		posicaoY[5] = 559;
		
		for(int i = 6; i<posicaoX.length; i++) {
			posicaoX[i] = -1;
			posicaoY[i] = -1;
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
		teclas.getItems().add("M");
		
//		teclas.getSelectionModel().select(0);	
	}
	
	private void inicializaComboTeclasRpMouse() {

		teclasRpMouse.getItems().add("SPACE");
		teclasRpMouse.getItems().add("ENTER");
		teclasRpMouse.getItems().add("ESC");
		teclasRpMouse.getItems().add("TAB");
		teclasRpMouse.getItems().add("CAPSLOOK");
		teclasRpMouse.getItems().add("M");
		
//		teclas.getSelectionModel().select(0);	
	}
	
	
	 private void mostraMensagem (String msg, AlertType tipo) { // recebe uma String por paremetro
			
			Alert a = new Alert (tipo);
			
			a.setHeaderText(null); // modificar mensagem
			a.setContentText(msg);
			a.show();
		}
	
}
