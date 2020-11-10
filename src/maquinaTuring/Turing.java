/**
 * 
 */
package maquinaTuring;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Sergio González Guerra
 *
 */
public class Turing {
	
	ArrayList<Estado> conjuntoEstados_ = new ArrayList<Estado>();
	ArrayList<String> alfabeto_ = new ArrayList<String>();
	ArrayList<String> alfabetoCinta_ = new ArrayList<String>();
	ArrayList<String> estadosFinales_ = new ArrayList<String>();
	
	String estadoActual_;
	String simboloBlanco_;
	int cabeza_ = 0;
	
	LinkedList<String> cinta_ = new LinkedList<String>();
	
	public Turing(File archive) throws Exception{
		
		FileReader fr = new FileReader(archive);
		BufferedReader br = new BufferedReader(fr);
		
		String cad;
		String[] vect;
		Estado e;
		boolean check = true;
		
		while ((cad = br.readLine()) != null) {
			cad.trim();
			if (!cad.contains("#")) {
				vect = cad.split(" ");
				
				for (int i = 0; i < vect.length; i++) {
					e = new Estado(vect[i]);
					conjuntoEstados_.add(e);
				}
				
				cad = br.readLine();
				vect = cad.split(" ");
				for (int i = 0; i < vect.length; i++)
					alfabeto_.add(vect[i]);
				
				cad = br.readLine();
				vect = cad.split(" ");
				for (int i = 0; i < vect.length; i++)
					alfabetoCinta_.add(vect[i]);
				
				cad = br.readLine();
				estadoActual_ = cad;
				
				cad = br.readLine();
				simboloBlanco_ = cad;
				
				cad = br.readLine();
				vect = cad.split(" ");
				for (int i = 0; i < vect.length; i++)
					estadosFinales_.add(vect[i]);
				
				while ((cad = br.readLine()) != null) {
					vect = cad.split(" ");
					
					// Control de errores
					if (!estaEnConjuntoEstados(vect[0]))
						check = false;
					
					if (!estaEnAlfabeto(vect[1]))
						check = false;
					
					if (!estaEnConjuntoEstados(vect[2]))
						check = false;
					
					if (!estaEnAlfabetoCinta(vect[3]))
						check = false;
					
					if (!movimientoValido(vect[4]))
						check = false;
					
					if (!check) {
						br.close();
						throw new Exception("Error en el fichero, existe algun carácter que no "
								+ "pertenece al alfabeto o algún estado que no pertenece al "
								+ "conjunto de estados.");
					}
					
					for (int j = 0; j < conjuntoEstados_.size(); j++) {
						if (conjuntoEstados_.get(j).getEstado().equals(vect[0]))
							conjuntoEstados_.get(j).setTransicion(vect[1], vect[2], vect[3], vect[4]);
					}
					
				}
				
			}
		}
		
		
		br.close();
	}
	
	
	public boolean maquinaTuring(String cadena) {
		boolean transita = true;
		
		for (int i = 0; i < cadena.length(); i++) {
			cinta_.addLast(String.valueOf(cadena.charAt(i)));
		}
		
		while(transita) {
			transita = false;
			
			for (int i = 0; i < conjuntoEstados_.size(); i++) {
				if( estadoActual_.equals(conjuntoEstados_.get(i).getEstado()) ) {
					for (int j = 0; j < conjuntoEstados_.get(i).getConjuntoTransicionesSize(); j++) {
						if(!transita) {
							if(cinta_.get(cabeza_).equals(conjuntoEstados_.get(i).getTransicion(j).getSimboloLectura())) {
								transita = true;
								
								cinta_.set(cabeza_, conjuntoEstados_.get(i).getTransicion(j).getSimboloEscritura());
								estadoActual_ = conjuntoEstados_.get(i).getTransicion(j).getEstadoSiguiente();
	
								if( "R".equals(conjuntoEstados_.get(i).getTransicion(j).getMovimiento()) ) {
									if(cabeza_ >= (cinta_.size()-1)) {
										cinta_.addLast(simboloBlanco_);
										cabeza_++;
									}else
										cabeza_++;
										
								}else if( "L".equals(conjuntoEstados_.get(i).getTransicion(j).getMovimiento()) ) {
									if(cabeza_ <= 0) {
										cinta_.addFirst(simboloBlanco_);
										cabeza_--;
									}else
										cabeza_--;
								}
							}
						}
					}
				}
				
			}
		}
		System.out.println("Cadena resultante: " + cinta_);
		
		for (int i = 0; i < estadosFinales_.size(); i++) {
			if(estadoActual_.equals(estadosFinales_.get(i)))
				return true;
		}
		
		return false;
		
	}
	
	private boolean estaEnConjuntoEstados(String v) {
		for (int i = 0; i < conjuntoEstados_.size(); i++) {
			if (v.equals(conjuntoEstados_.get(i).getEstado()))
				return true;
		}
		return false;
	}
	
	private boolean estaEnAlfabeto(String v) {
		for (int i = 0; i < alfabeto_.size(); i++) {
			if (v.equals(alfabeto_.get(i)))
				return true;
		}
		
		if(v.equals(simboloBlanco_))
			return true;
		
		
		return false;
	}
	
	private boolean estaEnAlfabetoCinta(String v) {
		for (int i = 0; i < alfabetoCinta_.size(); i++) {
			if (v.equals(alfabetoCinta_.get(i)))
				return true;
		}
		return false;
	}
	
	private boolean movimientoValido(String v) {
		if(v.equals("R"))
			return true;
		else if(v.equals("L"))
			return true;
		else if(v.equals("S"))
			return true;
		
		return false;
	}
	
	public String toString() {
		String cad = "";
		for (int i = 0; i < alfabeto_.size(); i++) {
			cad += alfabeto_.get(i) + " ";
		}
		cad += "\n";
		
		for (int i = 0; i < alfabetoCinta_.size(); i++) {
			cad += alfabetoCinta_.get(i) + " ";
		}
		cad += "\n";
		
		for (int i = 0; i < estadosFinales_.size(); i++) {
			cad += estadosFinales_.get(i) + " ";
		}
		cad += "\n";
		
		for (int i = 0; i < conjuntoEstados_.size(); i++) {
			cad += conjuntoEstados_.get(i).toString();
		}
		cad += "\n";
		
		return cad;
	}
}
