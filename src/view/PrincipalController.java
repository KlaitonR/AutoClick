package view;

import java.awt.Toolkit;
import java.util.concurrent.ThreadLocalRandom;

import Model.Agilidade;
import Model.Agricultura;
import Model.AutoConstruiction;
import Model.ClickPadrao;
import Model.ClickRandomico;
import Model.DungeonEventoPraia;
import Model.GravaMouse;
import Model.Proteicos;
import Model.ReproduzirMouse;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class PrincipalController{

	@FXML TextField timeWaiting;
	@FXML TextField minTimeWaiting;
	@FXML TextField maxTimeWaiting;
	@FXML TextField maxTtimeTecla;
	@FXML TextField breakClick;
	@FXML TextField timeWaitingTecla;
	
	@FXML RadioButton agilidadePriffdinas;
	
	@FXML ComboBox<String> teclas;
	@FXML ComboBox<String> teclasRpMouse;
	
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
	
	public static boolean agilidadePriff;
	
	public static int contMove = 0;
	
	private double posicaoX[] = new double [50];
	private double posicaoY[] = new double [50];
	
	@FXML
	public void initialize() {
		inicializaComboTeclas();
		inicializaComboTeclasRpMouse();
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
				 }
			
		}catch (NumberFormatException e) {
			mostraMensagem("Só é possivel digitar números.", AlertType.WARNING);
		}
		
		Thread cp =  new ClickPadrao(timeWait);
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
	
	@FXML
	public void contrucao() {
		
		parada = false;
		
//		Thread c = new AutoConstruiction();
		AutoConstruiction c = new AutoConstruiction();
		c.setInit(System.currentTimeMillis());
		c.setIntervalo(900*1000); //900*1000
		c.start();
		
	}
	
	@FXML
	public void agilidade() {
		
		parada = false;
		
		Agilidade a = new Agilidade();
//		a.setInit(System.currentTimeMillis());
//		a.setIntervalo(900*1000); //900*1000
		a.start();
		
	}
	
	@FXML
	public void agricultura() {
		
		System.out.println("LARGURA" + Toolkit.getDefaultToolkit().getScreenSize().width);
		System.out.println("LARGURA" + Toolkit.getDefaultToolkit().getScreenSize().height);
		
		parada = false;
		
		Agricultura a = new Agricultura();
//		a.setInit(System.currentTimeMillis());
//		a.setIntervalo(900*1000); //900*1000
		a.start();
		
	}
	
	@FXML
	public void proteicos() {
		
		parada = false;
		
//		Proteicos p = new Proteicos();
//		p.start();
		
		DungeonEventoPraia d = new DungeonEventoPraia();
		d.start();
		
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

	public TextField getTimeWaiting() {
		return timeWaiting;
	}

	public void setTimeWaiting(TextField timeWaiting) {
		this.timeWaiting = timeWaiting;
	}

	public TextField getMinTimeWaiting() {
		return minTimeWaiting;
	}

	public void setMinTimeWaiting(TextField minTimeWaiting) {
		this.minTimeWaiting = minTimeWaiting;
	}

	public TextField getMaxTimeWaiting() {
		return maxTimeWaiting;
	}

	public void setMaxTimeWaiting(TextField maxTimeWaiting) {
		this.maxTimeWaiting = maxTimeWaiting;
	}

	public TextField getMaxTtimeTecla() {
		return maxTtimeTecla;
	}

	public void setMaxTtimeTecla(TextField maxTtimeTecla) {
		this.maxTtimeTecla = maxTtimeTecla;
	}

	public TextField getBreakClick() {
		return breakClick;
	}

	public void setBreakClick(TextField breakClick) {
		this.breakClick = breakClick;
	}

	public TextField getTimeWaitingTecla() {
		return timeWaitingTecla;
	}

	public void setTimeWaitingTecla(TextField timeWaitingTecla) {
		this.timeWaitingTecla = timeWaitingTecla;
	}

	public ComboBox<String> getTeclas() {
		return teclas;
	}

	public void setTeclas(ComboBox<String> teclas) {
		this.teclas = teclas;
	}

	public ComboBox<String> getTeclasRpMouse() {
		return teclasRpMouse;
	}

	public void setTeclasRpMouse(ComboBox<String> teclasRpMouse) {
		this.teclasRpMouse = teclasRpMouse;
	}

	public static boolean isParada() {
		return parada;
	}

	public static void setParada(boolean parada) {
		PrincipalController.parada = parada;
	}

	public static long getInit() {
		return init;
	}

	public static void setInit(long init) {
		PrincipalController.init = init;
	}

	public static long getIntervalo() {
		return intervalo;
	}

	public static void setIntervalo(long intervalo) {
		PrincipalController.intervalo = intervalo;
	}

	public int getTimeWait() {
		return timeWait;
	}

	public void setTimeWait(int timeWait) {
		this.timeWait = timeWait;
	}

	public int getMaxTimeWait() {
		return maxTimeWait;
	}

	public void setMaxTimeWait(int maxTimeWait) {
		this.maxTimeWait = maxTimeWait;
	}

	public int getMinTimeWait() {
		return minTimeWait;
	}

	public void setMinTimeWait(int minTimeWait) {
		this.minTimeWait = minTimeWait;
	}

	public int getMaxTimeTecla() {
		return maxTimeTecla;
	}

	public void setMaxTimeTecla(int maxTimeTecla) {
		this.maxTimeTecla = maxTimeTecla;
	}

	public int getBreakClicks() {
		return breakClicks;
	}

	public void setBreakClicks(int breakClicks) {
		this.breakClicks = breakClicks;
	}

	public int getTimeWaitingTeclas() {
		return timeWaitingTeclas;
	}

	public void setTimeWaitingTeclas(int timeWaitingTeclas) {
		this.timeWaitingTeclas = timeWaitingTeclas;
	}

	public String getTecla() {
		return tecla;
	}

	public void setTecla(String tecla) {
		this.tecla = tecla;
	}
	
	public static boolean isAgilidadePriff() {
		return agilidadePriff;
	}

	public static void setAgilidadePriff(boolean agilidadePriff) {
		PrincipalController.agilidadePriff = agilidadePriff;
	}

	public void setAgilidadePriffdinas(RadioButton agilidadePriffdinas) {
		this.agilidadePriffdinas = agilidadePriffdinas;
	}

	public static boolean isTecladoAtivo() {
		return tecladoAtivo;
	}

	public static void setTecladoAtivo(boolean tecladoAtivo) {
		PrincipalController.tecladoAtivo = tecladoAtivo;
	}

	public static int getCont() {
		return cont;
	}

	public static void setCont(int cont) {
		PrincipalController.cont = cont;
	}

	public static boolean isGravandoMouse() {
		return gravandoMouse;
	}

	public static void setGravandoMouse(boolean gravandoMouse) {
		PrincipalController.gravandoMouse = gravandoMouse;
	}

	public static boolean isReproduzindoMouse() {
		return reproduzindoMouse;
	}

	public static void setReproduzindoMouse(boolean reproduzindoMouse) {
		PrincipalController.reproduzindoMouse = reproduzindoMouse;
	}

	public GravaMouse getGm() {
		return gm;
	}

	public void setGm(GravaMouse gm) {
		this.gm = gm;
	}

	public ReproduzirMouse getRm() {
		return rm;
	}

	public void setRm(ReproduzirMouse rm) {
		this.rm = rm;
	}

	public static int getContMove() {
		return contMove;
	}

	public static void setContMove(int contMove) {
		PrincipalController.contMove = contMove;
	}

	public double[] getPosicaoX() {
		return posicaoX;
	}

	public void setPosicaoX(double[] posicaoX) {
		this.posicaoX = posicaoX;
	}

	public double[] getPosicaoY() {
		return posicaoY;
	}

	public void setPosicaoY(double[] posicaoY) {
		this.posicaoY = posicaoY;
	}
	
}
