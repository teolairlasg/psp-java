package ej10_minaPuertoCuartel;

public class Programa {

	public static void main(String[] args) throws InterruptedException {
		Mina mina = new Mina(0);
		Puerto puertoAlgeciras = new Puerto(0, mina, "Algeciras");
		Puerto puertoBarcelona = new Puerto(0, mina, "Barcelona");
		Puerto puertoBilbao = new Puerto(0, mina, "Bilbao");

		
		System.out.println(mina);
		Thread hiloMinero = new Thread(new Minero(mina));
		Thread hiloMinero2 = new Thread(new Minero(mina, 3000));
		hiloMinero.start();
		hiloMinero2.start();
		puertoAlgeciras.construirSiHayDinero();
		System.out.println(puertoAlgeciras);

		System.out.println(mina);

		puertoAlgeciras.construirEnCola();
		puertoBarcelona.construirEnCola();
		puertoBilbao.construirEnCola();
		System.out.println(puertoAlgeciras);
		System.out.println(puertoBarcelona);
		System.out.println(puertoBilbao);

		System.out.println(mina);
	}
}
