package ej02_hilos;

public class HilosThread {
	public static void main(String[] args) throws InterruptedException {
		
		Hilo1 hilo = new Hilo1(2000);
		hilo.start();
		System.out.println("He lanzado un hilo");
		hilo.join();
		System.out.println("El hilo ha acabado");
	}
}
