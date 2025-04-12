import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Scanner;

public class Main2Asimetrico {

    private final static String ALGORITMO = "RSA";

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un mensaje: ");
        String mensaje = sc.nextLine();

        System.out.println("Mensaje original: " + mensaje);
        byte[] mensajeClaro = mensaje.getBytes();
        System.out.print("Mensaje claro en bytes: ");
        imprimir(mensajeClaro);

        // Generar llaves
        KeyPairGenerator generator = KeyPairGenerator.getInstance(ALGORITMO);
        generator.initialize(1024);
        KeyPair keyPair = generator.generateKeyPair();
        PrivateKey llavePrivada = keyPair.getPrivate();
        PublicKey llavePublica = keyPair.getPublic();

        // Cifrar con la llave privada (firma simulada)
        byte[] mensajeCifrado = Asimetrico.cifrar(llavePrivada, ALGORITMO, mensaje);
        System.out.print("Mensaje cifrado con llave privada: ");
        imprimir(mensajeCifrado);

        // Descifrar con la llave pública
        byte[] mensajeDescifrado = Asimetrico.descifrar(llavePublica, ALGORITMO, mensajeCifrado);
        System.out.print("Mensaje descifrado con llave pública: ");
        imprimir(mensajeDescifrado);

        System.out.println("Mensaje final descifrado: " + new String(mensajeDescifrado));
    }

    public static void imprimir(byte[] contenido) {
        for (int i = 0; i < contenido.length; i++) {
            System.out.print(contenido[i] + " ");
        }
        System.out.println();
    }
}
