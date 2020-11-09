/**
 * 
 */
package maquinaTuring;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


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
	int cabeza_;
	
	
	public Turing(File archive) throws IOException{
		
		FileReader fr = new FileReader(archive);
		BufferedReader br = new BufferedReader(fr);
		
		String cad;
		String[] vect;
		Estado e;
		
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
					
					for (int j = 0; j < conjuntoEstados_.size(); j++) {
						if (conjuntoEstados_.get(j).getEstado().equals(vect[0]))
							conjuntoEstados_.get(j).setTransicion(vect[1], vect[2], vect[3], vect[4]);
					}
					
				}
				
			}
		}
		
		
		br.close();
	}
}
