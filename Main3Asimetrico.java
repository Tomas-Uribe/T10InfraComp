import java.io.*;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Scanner;

public class Main3Asimetrico {
    

    private static final String ALGORITMO = "RSA";

    public static void main(String[] args) throws Exception {
        // Leer el mensaje desde teclado
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el mensaje a cifrar: ");
        String mensaje = sc.nextLine();

        // Generar par de llaves RSA
        KeyPairGenerator generator = KeyPairGenerator.getInstance(ALGORITMO);
        generator.initialize(1024);
        KeyPair keyPair = generator.generateKeyPair();
        PublicKey llavePublica = keyPair.getPublic();
        PrivateKey llavePrivada = keyPair.getPrivate();

        // Guardar llave pública
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("llavePublica.key"));
        oos.writeObject(llavePublica);
        oos.close();

        // Guardar llave privada
        oos = new ObjectOutputStream(new FileOutputStream("llavePrivada.key"));
        oos.writeObject(llavePrivada);
        oos.close();

        // Cifrar mensaje con llave pública
        byte[] textoCifrado = Asimetrico.cifrar(llavePublica, ALGORITMO, mensaje);

        // Guardar texto cifrado
        oos = new ObjectOutputStream(new FileOutputStream("mensajeCifrado.dat"));
        oos.writeObject(textoCifrado);
        oos.close();

        System.out.println("Llaves y mensaje cifrado guardados exitosamente.");
    }
}
