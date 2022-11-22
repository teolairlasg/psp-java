package ej09_contadorHilos;

public class Incrementador extends Thread {
	Contador contador;

	public Incrementador(Contador contador) {
		super();
		this.contador = contador;
	}

	@Override
	public void run() {
		for (int i = 0; i < 300000; i++) {
				contador.incrementar();
		}
	}
}
