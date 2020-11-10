/**
 * 
 */
package maquinaTuring;

/**
 * @author Sergio González Guerra
 *
 */
public class Transicion {

	String simboloLectura_;
	String estadoSiguiente_;
	String simboloEscritura_;
	String movimiento_;

	public Transicion(String simboloLectura, String estadoSiguiente, String simboloEscritura, String movimiento) {
			simboloLectura_ = simboloLectura;
			estadoSiguiente_ = estadoSiguiente;
			simboloEscritura_ = simboloEscritura;
			movimiento_ = movimiento;
	}

	public String getEstadoSiguiente() { return estadoSiguiente_; }
	public String getSimboloLectura() { return simboloLectura_; }
	public String getSimboloEscritura() { return simboloEscritura_; }
	public String getMovimiento() { return movimiento_; }
	
	public String toString() {
		String cad = "";
		cad += simboloLectura_ + " " + estadoSiguiente_ + " " + simboloEscritura_ + " " + movimiento_ + "\n";
		return cad;
	}
}
