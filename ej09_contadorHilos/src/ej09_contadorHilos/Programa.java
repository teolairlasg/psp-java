package ej09_contadorHilos;

public class Programa {

	public static void main(String[] args) throws InterruptedException {
		Contador c = new Contador(150);
		Incrementador h1 = new Incrementador(c);
		Decrementador h2 = new Decrementador(c);
		h1.start();
		h2.start();
		h1.join();
		h2.join();
		System.out.println(c);
	}

}
