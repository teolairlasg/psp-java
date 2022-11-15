package ej10_minaPuertoCuartel;

import java.util.ArrayList;

public class Puerto {
	int barcos;
	String nombre;
	Mina mina;

	public Puerto(int barcos, Mina mina, String nombre) {
		super();
		this.barcos = barcos;
		this.mina = mina;
		this.nombre = nombre;
	}
	
	public void construirSiHayDinero() {
		// cada barco cuesta dos monedas
		if(mina.getMonedas()>=2) {
			mina.gastar(2);
			barcos++;
		}else {
			System.out.println("Puerto de "+nombre+": ¡No hay monedas suficientes!. No construyo");
		}
	}
	public void construirEnCola() throws InterruptedException {
		synchronized(mina){
			while(mina.getMonedas()<2) {
				System.out.println("Puerto de "+nombre+": No hay monedas suficientes, esperando...");
				mina.wait();	
			}
			mina.gastar(2);
		}	
		barcos++;
		System.out.println("Puerto de "+nombre+": Se ha construido un barco. Ahora hay "+barcos+".");
	}

	@Override
	public String toString() {
		return "Puerto de "+nombre+" [barcos=" + barcos + "]";
	}
}

