package ej02_hilos;

public class Hilo1 extends Thread {
	int milisegundos;

	public Hilo1(int segundos) {
		super();
		this.milisegundos = segundos;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(milisegundos);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Hola soy el hilo: "+this.getId());
		super.run();
	}
	
}
