package Banco;

import java.util.*;
public class ClientePreferente extends Cliente{

	HashMap<Integer, Integer> fondo = new HashMap<Integer,Integer>();

	public ClientePreferente(String dni, String nombre, int numcuenta, int saldo, HashMap<Integer, Integer> fondo) {
		super(dni, nombre, numcuenta, saldo);
		this.fondo = fondo;
	}

	public HashMap<Integer, Integer> getFondo() {
		return fondo;
	}

	public void setFondo(HashMap<Integer, Integer> fondo) {
		this.fondo = fondo;
	}

	@Override
	public String toString() {
		return "ClientePreferente "  + super.toString() + "fondo=" + fondo + "]";
	}
	
	
	public void añadirFondo(int id, int saldo) {
		
		fondo.put(id, saldo);
		
		
		this.saldo=this.saldo+saldo;
		
	}//Añadir fondo y sumar saldo
	
	
	public void eliminarFondo(int num) {
		int cantidad=0;
		int cantidad2=0;
		
		for (Map.Entry<Integer,Integer> entrada : fondo.entrySet()) {  //Recorremos para sumar el value
				
			cantidad=cantidad+ entrada.getValue();
		}
		
		fondo.remove(num);
		
		for (Map.Entry<Integer,Integer> entrada : fondo.entrySet()) {  
			
			cantidad2=cantidad2+ entrada.getValue();
		}
		
		this.saldo=this.saldo-(cantidad-cantidad2);
		
	}
	
}// Eliminar fondo
