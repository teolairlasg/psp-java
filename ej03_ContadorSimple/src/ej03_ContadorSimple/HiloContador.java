package ej03_ContadorSimple;

public class HiloContador implements Runnable {

	private int vueltas;
	private Contador contador;
	
	public HiloContador(int vueltas, Contador contador) {
		super();
		this.vueltas = vueltas;
		this.contador = contador;
	}

	@Override
	public void run() {
		for (int i = 0; i < vueltas; i++) {
//			synchronized (contador) {
				contador.contar();				
//			}
		}
	}
}
