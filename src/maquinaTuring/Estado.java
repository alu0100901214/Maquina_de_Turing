package maquinaTuring;

import java.util.ArrayList;


/**
 * @author Sergio González Guerra
 *
 */
public class Estado {

	String estado_;
	ArrayList<Transicion> conjuntoTransiciones_ = new ArrayList<Transicion>();
	
	// Constructor
	public Estado(String estado) {
		estado_ = estado;
	}
	
	public String getEstado() {
		return estado_;
	}
	
	public void setTransicion(String simboloLectura, String estadoSiguiente, String simboloEscritura, String movimiento) {
		Transicion t = new Transicion(simboloLectura, estadoSiguiente, simboloEscritura, movimiento);
		conjuntoTransiciones_.add(t);
	}
	
	// Constructor vacío
	public Estado() {}
	
	
	public String toString() {
		String cad = "";
		cad += estado_ + ": \n";
		for (int i = 0; i < conjuntoTransiciones_.size(); i++) {
			cad += estado_ + " " + conjuntoTransiciones_.get(i).toString();
		}
		return cad;
	}
}
