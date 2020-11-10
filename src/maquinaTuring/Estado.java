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
	
	// Constructor vacío
	public Estado() {}
	
	// Getters
	public String getEstado() { return estado_; }
	public int getConjuntoTransicionesSize() { return conjuntoTransiciones_.size(); }
	public Transicion getTransicion(int index) { return conjuntoTransiciones_.get(index); }
	// Setters
	public void setTransicion(String simboloLectura, String estadoSiguiente, String simboloEscritura, String movimiento) {
		Transicion t = new Transicion(simboloLectura, estadoSiguiente, simboloEscritura, movimiento);
		conjuntoTransiciones_.add(t);
	}
	


	
	public String toString() {
		String cad = "";
		cad += estado_ + ": \n";
		for (int i = 0; i < conjuntoTransiciones_.size(); i++) {
			cad += estado_ + " " + conjuntoTransiciones_.get(i).toString();
		}
		return cad;
	}
}
