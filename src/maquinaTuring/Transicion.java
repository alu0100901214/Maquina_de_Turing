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

}
