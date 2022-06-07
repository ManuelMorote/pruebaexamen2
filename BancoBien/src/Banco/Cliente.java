package Banco;

public class Cliente {

	String dni, nombre;
	int numcuenta, saldo;
	
	public Cliente(String dni, String nombre, int numcuenta, int saldo) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.numcuenta = numcuenta;
		this.saldo = saldo;
		
		
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumcuenta() {
		return numcuenta;
	}

	public void setNumcuenta(int numcuenta) {
		this.numcuenta = numcuenta;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", nombre=" + nombre + ", numcuenta=" + numcuenta + ", saldo=" + saldo + "]";
	}
	
	public void ingresar(int ingreso) {
		
		saldo=saldo+ingreso;
	}//Ingresar
	
	public void retirar(int retiro) {
		
		saldo=saldo-retiro;
	}//Retirar
	
}
