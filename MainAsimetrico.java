import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Scanner;

public class MainAsimetrico {

    private final static String ALGORITMO = "RSA";

    public static void main(String[] args) throws Exception {

        Scanner sc =
         new Scanner(System.in);
        System.out.print("Escriba un mensaje de texto: ");
        String texto = sc.nextLine();

        // Mostrar mensaje original
        System.out.println("Input en texto plano: " + texto);

        // Mostrar texto claro en bytes
        byte[] textoClaro = texto.getBytes();
        System.out.print("Input en bytes[]: ");
        imprimir(textoClaro);

        // Generar llaves pública y privada
        KeyPairGenerator generator = KeyPairGenerator.getInstance(ALGORITMO);
        generator.initialize(1024);
        KeyPair keyPair = generator.generateKeyPair();
        PublicKey llavePublica = keyPair.getPublic();
        PrivateKey llavePrivada = keyPair.getPrivate();

        // Cifrar con la llave pública
        byte[] textoCifrado = Asimetrico.cifrar(llavePublica, ALGORITMO, texto);
        System.out.print("Input cifrado en RSA con Llaves de 1024 bits en byte[]: ");
        imprimir(textoCifrado);

        // Descifrar con la llave privada
        byte[] textoDescifrado = Asimetrico.descifrar(llavePrivada, ALGORITMO, textoCifrado);
        System.out.print("Input descifrado en byte[]: ");
        imprimir(textoDescifrado);

        // Convertir el texto descifrado a String
        String resultado = new String(textoDescifrado);
        System.out.println("Input descifrado convertido a texto plano: " + resultado);
    }

    // Método para imprimir arreglos de bytes
    public static void imprimir(byte[] contenido) {
        for (int i = 0; i < contenido.length; i++) {
            System.out.print(contenido[i] + " ");
        }
        System.out.println();
    }
}
