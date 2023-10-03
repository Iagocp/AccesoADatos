/*
 * Codificar un programa que cree el fichero Texto.txt, después copiará determinados datos
seleccionados de dicho fichero, almacenándolos en otro fichero Copia.txt. La selección consiste en
que de cada 3 caracteres leídos se escribirá uno.
 */
package Ejercicio_02;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio_02 {

	public static void main(String[] args) {
		String sourceFile = "Texto.txt";
		String destinationFile = "Copia.txt";

		try {
			// Crear el archivo Texto.txt
			FileWriter writer = new FileWriter(sourceFile);
			writer.write(
					"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
			writer.close();

			// Copiar los datos seleccionados al archivo Copia.txt
			FileReader reader = new FileReader(sourceFile);
			FileWriter writer2 = new FileWriter(destinationFile);

			int charCount = 0;
			int c;
			while ((c = reader.read()) != -1) {
				charCount++;
				if (charCount % 3 == 0) {
					writer2.write(c);
				}
			}

			reader.close();
			writer2.close();

			System.out.println("Copia de archivo completada.");
		} catch (IOException e) {
			System.err.println("Hubo un error de entrada/salida: " + e.getMessage());
		}
	}
}
