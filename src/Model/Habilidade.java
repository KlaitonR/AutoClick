package Model;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Random;

public class Habilidade extends Thread implements Runnable {

	private Random rand = new Random();
	private Robot r = null;
	private int cont;
	private long init;
	private long intervalo;
	
	//INICIALIZA ROBOT PARA PRECIONAR TECLAS
	public void inicializaRobot() {
		if(r == null) {
			try {
				r = new Robot();
			} catch (AWTException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public void click(int x, int y, int intervalo) {
		try {
			Click.click(x, y);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(intervalo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickDireito(int x, int y, int intervalo) {
		try {
			Click.clickDireito(x, y);
		} catch (AWTException e) {
			e.printStackTrace();
		}

		try {
			Thread.sleep(intervalo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
}
	
	public Random getRand() {
		return rand;
	}
	
	public void setRand(Random rand) {
		this.rand = rand;
	}
	
	public Robot getR() {
		return r;
	}
	
	public void setR(Robot r) {
		this.r = r;
	}
	
	public int getCont() {
		return cont;
	}
	
	public void setCont(int cont) {
		this.cont = cont;
	}
	
	public long getInit() {
		return init;
	}
	
	public void setInit(long init) {
		this.init = init;
	}
	
	public long getIntervalo() {
		return intervalo;
	}
	
	public void setIntervalo(long intervalo) {
		this.intervalo = intervalo;
	}
	
}
