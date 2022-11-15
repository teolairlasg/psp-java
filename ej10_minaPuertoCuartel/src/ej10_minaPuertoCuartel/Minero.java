package ej10_minaPuertoCuartel;

public class Minero implements Runnable {
	Mina mina;
	int tiempoMinado;
	
	public Minero(Mina mina) {
		super();
		this.mina = mina;
		this.tiempoMinado = 5000;
	}
	public Minero(Mina mina, int tiempoMinado) {
		super();
		this.mina = mina;
		this.tiempoMinado = tiempoMinado;
	}
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(tiempoMinado);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mina.minar();
			System.out.println("Minero: He minado 1 moneda en "+ tiempoMinado+"milisegundos");
		}
	}

}
