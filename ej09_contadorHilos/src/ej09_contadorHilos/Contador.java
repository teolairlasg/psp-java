package ej09_contadorHilos;

import java.util.concurrent.ConcurrentHashMap;

public class Contador {

	//private int numero;
	ConcurrentHashMap<String, Integer> numero;
	
	public Contador(int numero) {
		super();
		//this.numero = numero;
		this.numero = new ConcurrentHashMap<>();
		this.numero.put("clave", numero);
	}
	public void incrementar() {
		//synchronized (this) {
		//	numero++;			
		//}
		
		// esto no nos vale, porque son dos
		//operaciones atómicas
		//numero.put("clave", numero.get("clave")+1 );

		// la operación compute guarda el valor del resultado 
		// de la función flecha dentro del valor "clave"
		// y es atómica
		numero.compute("clave", (c,valor) -> valor+1 );
		
		
		
	}
	public void decrementar() {
		//numero.put("clave", numero.get("clave")-1 );
		numero.compute("clave", (c,valor) -> valor-1 );
	}
	@Override
	public String toString() {
		return "Contador [numero=" + numero + "]";
	}
	
}
