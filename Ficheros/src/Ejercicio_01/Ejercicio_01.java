/*
 * Realizar un programa Java que utiliza la clase File. Deberá crear un directorio, dentro de dicho
directorio creará dos ficheros, hay que comprobar si existe; a uno de los ficheros le cambiará de
nombre y el otro se eliminará. Además mostrará los ficheros de un directorio. El nombre del
directorio se pasará al programa desde el teclado al ejecutarlo. El programa deberá mostrar también
información de un fichero cuyo nombre también se introducirá por teclado.
 */
package Ejercicio_01;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio_01 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Introduce el nombre del directorio: ");
		String directorio = scanner.nextLine();

		// Crear el directorio
		File dir = new File(directorio);
		if (!dir.exists()) {
			dir.mkdir();
			System.out.println("Directorio creado: " + directorio);
		} else {
			System.out.println("El directorio ya existe: " + directorio);
		}

		// Crear dos archivos dentro del directorio
		File file1 = new File(dir, "archivo1.txt");
		File file2 = new File(dir, "archivo2.txt");
		try {
			file1.createNewFile();
			file2.createNewFile();
			System.out.println("Archivos creados: " + file1.getName() + ", " + file2.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Cambiar el nombre de un archivo
		System.out.print("Introduce el nombre del archivo a renombrar: ");
		String nombreArchivo = scanner.nextLine();
		File archivo = new File(dir, nombreArchivo);
		if (archivo.exists()) {
			System.out.print("Introduce el nuevo nombre del archivo: ");
			String nuevoNombre = scanner.nextLine();
			File nuevoArchivo = new File(dir, nuevoNombre);
			if (archivo.renameTo(nuevoArchivo)) {
				System.out.println("Archivo renombrado a: " + nuevoArchivo.getName());
			} else {
				System.out.println("No se pudo renombrar el archivo");
			}
		} else {
			System.out.println("El archivo no existe: " + nombreArchivo);
		}

		// Eliminar un archivo
		System.out.print("Introduce el nombre del archivo a eliminar: ");
		nombreArchivo = scanner.nextLine();
		archivo = new File(dir, nombreArchivo);
		if (archivo.exists()) {
			if (archivo.delete()) {
				System.out.println("Archivo eliminado: " + archivo.getName());
			} else {
				System.out.println("No se pudo eliminar el archivo");
			}
		} else {
			System.out.println("El archivo no existe: " + nombreArchivo);
		}

		// Mostrar los archivos en el directorio
		System.out.println("Archivos en el directorio " + dir.getAbsolutePath() + ":");
		File[] files = dir.listFiles();
		for (File file : files) {
			System.out.println(file.getName());
		}

		// Mostrar información de un archivo
		System.out.print("Introduce el nombre de un archivo para mostrar su información: ");
		nombreArchivo = scanner.nextLine();
		archivo = new File(dir, nombreArchivo);
		if (archivo.exists()) {
			System.out.println("Información del archivo " + archivo.getName() + ":");
			System.out.println("Ruta absoluta: " + archivo.getAbsolutePath());
			System.out.println("Tamaño: " + archivo.length() + " bytes");
			System.out.println("¿Es directorio? " + archivo.isDirectory());
			System.out.println("¿Es archivo? " + archivo.isFile());
			System.out.println("¿Se puede leer? " + archivo.canRead());
			System.out.println("¿Se puede escribir? " + archivo.canWrite());
			System.out.println("¿Se puede ejecutar? " + archivo.canExecute());
		} else {
			System.out.println("El archivo no existe: " + nombreArchivo);
		}

		scanner.close();
	}
}
