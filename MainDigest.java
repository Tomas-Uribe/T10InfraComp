import java.util.Scanner;

public class MainDigest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Entrada de usuario
        System.out.print("Escriba un mensaje de texto: ");
        String mensaje = sc.nextLine();

        System.out.println("Mensaje de entrada: " + mensaje);

        // Convertir a byte[]
        byte[] buffer = mensaje.getBytes();

        // Digest MD5
        byte[] digestMD5 = Digest.getDigest("MD5", buffer);
        System.out.print("Digest MD5 obtenido: ");
        Digest.imprimirHexa(digestMD5);

        // Digest SHA-1
        byte[] digestSHA1 = Digest.getDigest("SHA-1", buffer);
        System.out.print("Digest SHA-1 obtenido: ");
        Digest.imprimirHexa(digestSHA1);

        // Verificación (por ejemplo, comparación consigo mismo)
        boolean verificacion = Digest.verificar(digestMD5, digestMD5);
        System.out.println("¿Los digests MD5 son iguales? " + verificacion);
    }
}
