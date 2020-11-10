package maquinaTuring;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Sergio González Guerra
 *
 */

public class mainTuring {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File archive = new File(args[0]);
		Scanner sc = new Scanner(System.in);

		Turing t = new Turing(archive);
		System.out.println(t);
		
		System.out.println("Introduzca la cadena para la cinta de entrada: ");
		String cad = sc.nextLine();
		
		t.maquinaTuring(cad);
		sc.close();
	}

}
