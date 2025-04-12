import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.*;
import java.util.Scanner;

public class Main3 {

    private final static String ALGORITMO = "AES";

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el mensaje a cifrar: ");
        String mensaje = sc.nextLine();

        // Generar llave
        KeyGenerator keygen = KeyGenerator.getInstance(ALGORITMO);
        SecretKey llave = keygen.generateKey();

        // Cifrar mensaje
        byte[] textoCifrado = Simetrico.cifrar(llave, mensaje);

        // Guardar la llave
        FileOutputStream archivo = new FileOutputStream("llave.aes");
        ObjectOutputStream oos = new ObjectOutputStream(archivo);
        oos.writeObject(llave);
        oos.close();

        // Guardar el texto cifrado
        archivo = new FileOutputStream("mensaje_cifrado.aes");
        oos = new ObjectOutputStream(archivo);
        oos.writeObject(textoCifrado);
        oos.close();

        System.out.println("Proceso completado: llave y mensaje cifrado guardados.");
    }
}
