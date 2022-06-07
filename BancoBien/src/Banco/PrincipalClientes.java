package Banco;
import java.util.*;
public class PrincipalClientes {

	static Scanner lector= new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcion;
		boolean salir=false;
		
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		HashMap<Integer, Integer> fondos1= new HashMap<Integer, Integer>();
		
		fondos1.put(01, 200);
		fondos1.put(02, 300);
		fondos1.put(03, 100);
		HashMap<Integer, Integer> fondos2= new HashMap<Integer, Integer>();

		fondos2.put(04, 150);
		fondos2.put(05, 100);
		
		clientes.add(new Cliente("70555111A", "PEPE", 00001, 200));
		clientes.add(new Cliente("706066068", "DANIEL", 00002, 400));
		clientes.add(new Cliente("70111222C", "JESUS", 00003, 150));
		clientes.add(new ClientePreferente("70123123D", "SARA", 0004, 750, fondos1));
		clientes.add(new ClientePreferente("70252525E", "LUIS", 00005, 400, fondos2));
		
		
		do {
			
			System.out.println("1. Ver Clientes");
			System.out.println("2. Añadir cliente");
			System.out.println("3. Modificar cliente");
			System.out.println("4. Salir");
			opcion=lector.nextInt();
			
			switch(opcion) {
			
			case 1:
				verClientes(clientes);
				break;
				
			case 2:
				
				añadirCliente(clientes);
				break;
				
			case 3:
				int opcion2;
				boolean salir2=false;
				do {
					System.out.println("1. Añadir saldo");
					System.out.println("2. Retirar saldo");
					System.out.println("3. Añadir fondo de inversion");
					System.out.println("4. Eliminar fondo de inversion");
					System.out.println("5. Salir");
					opcion2=lector.nextInt();
					
					switch(opcion2) {
					
					case 1:
						añadirSaldo(clientes);
						break;
						
					case 2:
						retirarSaldo(clientes);
						break;
						
					case 3:
						añadirFondo(clientes);
						break;
						
						
					case 4:
						eliminarFondo(clientes);
						break;
						
					case 5:
						salir2=true;
						break;
					}
					
				}while(salir2==false);
				
				break;
				
			case 4:
				
				System.out.println("Adios");
				salir=true;
			
			}
			
		}while(salir==false);
		
		
		
	}//FIN MAIN
	
	public static void verClientes(ArrayList<Cliente> clientes) {
		
		for(int i=0; i<clientes.size(); i++) { 
			
			if(clientes.get(i).getClass()==Cliente.class) {
				
				System.out.println(i + ". " + clientes.get(i).toString());
			}else if(clientes.get(i).getClass()==ClientePreferente.class) {
				System.out.println(i+ ". "+clientes.get(i).toString());

			}
		}
	}//Ver clientes
	
	
	
	public static void añadirCliente(ArrayList<Cliente> clientes) {
		int tipocliente, opcioncliente;	
		String dni,nombre;
		int numcuenta, saldo, numfondos, idfondo, saldofondo;
	
		System.out.println("¿Que tipo de cliente desea? 1.Normal 2.Preferente");
		tipocliente=lector.nextInt();
		
		System.out.println("Introduce DNI");
		dni=lector.next();
		System.out.println("Introduce nombre");
		nombre=lector.next();
		System.out.println("Introduce numero de cuenta");
		numcuenta=lector.nextInt();
		System.out.println("Introduce saldo");
		saldo=lector.nextInt();
		
		
		if(tipocliente==1) {
			
			clientes.add(new Cliente(dni, nombre, numcuenta, saldo));
			
		}else if(tipocliente==2) {
			
			clientes.add(new ClientePreferente(dni,nombre, numcuenta,saldo, new HashMap<Integer,Integer>()));	
			
			añadirFondo(clientes);
		}
	}// Añadir cliente
	
	public static void añadirSaldo(ArrayList<Cliente>clientes) {
		int opcioncliente;
		int cantidad;
		System.out.println("Selecciona cliente");
		verClientes(clientes);
		opcioncliente=lector.nextInt();
		System.out.println("Introduce cantidad a ingresar");
		cantidad=lector.nextInt();
		clientes.get(opcioncliente).ingresar(cantidad);
	}//Añadir saldo

	public static void retirarSaldo(ArrayList<Cliente>clientes) {
		int opcioncliente;
		int cantidad;
		System.out.println("Selecciona cliente");
		verClientes(clientes);
		opcioncliente=lector.nextInt();
		System.out.println("Introduce cantidad a ingresar");
		cantidad=lector.nextInt();
		
		clientes.get(opcioncliente).retirar(cantidad);
		
	}//Retirar saldo
	
	public static void añadirFondo(ArrayList<Cliente> clientes) {
		int numfondos, idfondo, saldofondo;
		int opcioncliente;
		System.out.println("Selecciona cliente preferente para añadirle fondo");
		for(int i=0; i<clientes.size(); i++) {
			
			if(clientes.get(i).getClass()==ClientePreferente.class) {
				System.out.println(i+ ". "+clientes.get(i).toString());

			}
			
		}
		opcioncliente=lector.nextInt();
		System.out.println("Introduce cantidad de fondos");
		numfondos=lector.nextInt();
		
		
		for(int i=0; i<numfondos; i++) {
			
			System.out.println("Introduce id del fondo");
			idfondo=lector.nextInt();
			System.out.println("Introduce saldo del fondo");
			saldofondo=lector.nextInt();
			
			
			if(clientes.get(opcioncliente).getClass()==ClientePreferente.class) {
				ClientePreferente preferente1 = (ClientePreferente)(clientes.get(opcioncliente));
				
				preferente1.añadirFondo(idfondo, saldofondo);
			}
			
		}
		
	}// Añadir fondo de inversion
	
	
	public static void eliminarFondo(ArrayList<Cliente> clientes) {
		int opcioncliente, fondoeliminar;

		System.out.println("Selecciona cliente preferente");
		for(int i=0; i<clientes.size(); i++) {
			
			if(clientes.get(i).getClass()==ClientePreferente.class) {

				System.out.println(i+ ". "+clientes.get(i).toString());
				
				
			}
			
		}
		opcioncliente=lector.nextInt();
		
			
			System.out.println("Selecciona fondo con el ID que desea eliminar ");
				
				ClientePreferente preferente1 = (ClientePreferente) clientes.get(opcioncliente);
				
				
				for (Map.Entry<Integer,Integer> entrada : preferente1.getFondo().entrySet()) {  //Muestra clave y valor de los fondos del cliente seleccionado
						
					System.out.println( "id: "+ entrada.getKey() + " saldo: " + entrada.getValue());

					
					
				}
				
				
				
				fondoeliminar=lector.nextInt();
				preferente1.eliminarFondo(fondoeliminar);
			
				
					

	}//Eliminar fondo de inversion de un cliente preferente en concreto
}//FIN CLASS
