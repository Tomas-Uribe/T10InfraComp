import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import java.util.Base64;
import java.util.Scanner;

public class Main {

    private final static String ALGORITMO = "AES";

    public static void main(String[] args) {
        try {
            // Leer texto desde el teclado
            Scanner sc = new Scanner(System.in);
            System.out.print("Escriba el texto que desea cifrar: ");
            String texto = sc.nextLine();

            // Mostrar texto recibido
            System.out.println("Mensaje de entrada en texto claro: " + texto);

            // Convertir texto a bytes y mostrarlo
            byte[] textoClaro = texto.getBytes();
            System.out.print("Texto claro: ");
            imprimir(textoClaro);

            // Generar la llave secreta
            KeyGenerator keygen = KeyGenerator.getInstance(ALGORITMO);
            SecretKey secretKey = keygen.generateKey();

            // Cifrar texto
            byte[] textoCifrado = Simetrico.cifrar(secretKey, texto);
            System.out.print("Texto cifrado: ");
            imprimir(textoCifrado);

            // Descifrar texto
            byte[] textoDescifrado = Simetrico.descifrar(secretKey, textoCifrado);
            System.out.print("Texto descifrado: ");
            imprimir(textoDescifrado);

            System.out.println("Clave generada: " + Base64.getEncoder().encodeToString(secretKey.getEncoded()));


            // Convertir byte[] a String
            String textoFinal = new String(textoDescifrado);
            System.out.println("Texto descifrado: " + textoFinal);

        } catch (Exception e) {
            System.out.println("Error en el proceso: " + e.getMessage());
        }
    }

    // Método para imprimir byte[]
    public static void imprimir(byte[] contenido) {
        for (int i = 0; i < contenido.length; i++) {
            System.out.print(contenido[i] + " ");
        }
        System.out.println();
    }
}
