package maquinaTuring;

import java.io.File;
import java.io.IOException;

/**
 * @author Sergio Gonz�lez Guerra
 *
 */

public class mainTuring {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File archive = new File(args[0]);
		
		Turing t = new Turing(archive);
	}

}
