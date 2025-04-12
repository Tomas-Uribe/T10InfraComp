import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Scanner;
import java.util.Base64;

public class Main2 {

    private final static String ALGORITMO = "AES";

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Escriba el texto que desea cifrar: ");
            String mensaje = sc.nextLine();

            // 1. Generar dos llaves simétricas k1 y k2
            KeyGenerator keygen = KeyGenerator.getInstance(ALGORITMO);
            SecretKey k1 = keygen.generateKey();
            SecretKey k2 = keygen.generateKey();

            // 2. Cifrar con k1
            byte[] tc1 = Simetrico.cifrar(k1, mensaje);
            System.out.println("Texto cifrado con k1 (tc1):");
            imprimir(tc1);

            // 3. Cifrar con k2
            byte[] tc2 = Simetrico.cifrar(k2, mensaje);
            System.out.println("Texto cifrado con k2 (tc2):");
            imprimir(tc2);

            // 4. Descifrar tc1 con k1
            byte[] descifrado = Simetrico.descifrar(k1, tc1);
            String resultado = new String(descifrado);
            System.out.println("Descifrado tc1 con k1: " + resultado);

            // Mostrar claves en base64
            System.out.println("Clave k1: " + Base64.getEncoder().encodeToString(k1.getEncoded()));
            System.out.println("Clave k2: " + Base64.getEncoder().encodeToString(k2.getEncoded()));

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void imprimir(byte[] contenido) {
        for (byte b : contenido) {
            System.out.print(b + " ");
        }
        System.out.println();
    }
}
