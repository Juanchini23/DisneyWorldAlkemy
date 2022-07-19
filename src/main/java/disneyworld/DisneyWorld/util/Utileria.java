package disneyworld.DisneyWorld.util;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class Utileria {

	public static String guardarArchivo(MultipartFile multiPart, String ruta) {
		// Obtenemos el nombre original del archivo.
		String nombreOriginal = multiPart.getOriginalFilename();
		nombreOriginal.replace(" ", "-");
		String nombreFinal = randomAlphaNumeric(8) + nombreOriginal;
		try {
			// Formamos el nombre del archivo para guardarlo en el disco duro.
			File imageFile = new File(ruta + nombreFinal);
			// Guardamos fisicamente el archivo en HD.
			multiPart.transferTo(imageFile);
			return nombreFinal;
		} catch (IOException e) {
			System.out.println("Error " + e.getMessage());
			return null;
		}
	}

	public static String randomAlphaNumeric(Integer count) {
		String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder builder = new StringBuilder();
		
		while(count-- != 0) {
			Integer caracter = (int) (Math.random()*caracteres.length());
			builder.append(caracteres.charAt(caracter));
		}
		return builder.toString();
		
	}
}
