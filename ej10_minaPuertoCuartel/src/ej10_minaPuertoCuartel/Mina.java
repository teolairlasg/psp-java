package ej10_minaPuertoCuartel;

public class Mina {
	int monedas;
	
	public Mina(int monedas) {
		super();
		this.monedas = monedas;
	}
	public int getMonedas() {
		return monedas;
	}
	public void setMonedas(int monedas) {
		this.monedas = monedas;
	}
	public synchronized void minar() {
		monedas++;
		System.out.println("Mina: Se ha añadido una moneda");
		this.notify();
	}
	public synchronized void gastar(int n) {
			monedas-=n;
	}
	@Override
	public String toString() {
		return "Mina [monedas=" + monedas + "]";
	}
	
}
